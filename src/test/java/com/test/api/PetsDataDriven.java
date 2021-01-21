package com.test.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.apitest.model.PetsDataModel;
import com.apitest.model.PetsStatusModel;
import com.dataproviders.APIDataProviders;
import com.framework.utilities.BaseAPI;
import com.framework.utilities.BuildAPIPath;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import io.restassured.response.Response;

@Guice
public class PetsDataDriven extends BaseAPI {

	@Test(dataProvider = "PetsStatus", dataProviderClass = APIDataProviders.class)
	public void testDataDrivenGetPets(PetsStatusModel petsModel) {
		reportLog("Started execution of test get pets");
		logRquestUrl(BuildAPIPath.getPetsUriPath(petsModel.getStatus()));
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader()).when().get(BuildAPIPath.getPetsUriPath(petsModel.getStatus()));
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
	}

	@Test(dataProvider = "PetsPostData", dataProviderClass = APIDataProviders.class)
	public void testPostPetsByXml(PetsDataModel petsModel) throws Exception {
		reportLog("Started execution of test user Post pets");
		String requestUrl = GlobalConstant.Root_URI;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_POST);
		String xmlData = getPetsXml(petsModel);
		Response response = given().headers(getAllXMLHeaders()).body(xmlData).when().post(requestUrl);
		reportResponseLog(response.asString());
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_XML);
	}

}
