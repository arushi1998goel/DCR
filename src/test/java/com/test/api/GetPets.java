package com.test.api;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.apitest.model.PetsStatusModel;
import com.dataproviders.APIDataProviders;
import com.framework.utilities.BaseAPI;
import com.framework.utilities.BuildAPIPath;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;

import io.restassured.response.Response;

public class GetPets extends BaseAPI {
	
	@Test
	public void testGetPets() {

		String status = "pending";
		reportLog("Started execution of test user pets");
		PetsStatusModel petsModel = new PetsStatusModel.PetsStatusModelBuilder(status).build();
		
		logRquestUrl(BuildAPIPath.getPetsUriPath(petsModel));
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader())
				.when().get(BuildAPIPath.getPetsUriPath(petsModel));
		reportResponseLog(response.asString());
		reportLog("Response :");
		reportLog(response.asString());

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);	
	}

	@Test(dataProvider = "GetPetsBy", dataProviderClass = APIDataProviders.class)
	public void testDataDrivenGetPets(String status) {
		reportLog("Started execution of test get pets");

		logRquestUrl(BuildAPIPath.getPetsUriPath(status));
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader()).when().get(BuildAPIPath.getPetsUriPath(status));
		reportResponseLog(response.asString());
		System.out.println(response.asString());

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
	}
}
