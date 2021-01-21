package com.test.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import io.restassured.response.Response;

public class GetPetsById extends BaseAPI {

	@Test()
	public void testGetPetByIdNotFound() {
		reportLog("Started execution of test user document");

		String requestUrl = GlobalConstant.Root_URI + "1111111111111";
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader()).when().get(requestUrl);
		System.out.println(response.asString());
		reportResponseLog(response.asString());

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_NOT_FOUND, GlobalConstant.Application_JSON);
		reportLog("Verify response data : error, code, type and message");
		System.out.println(response.asString());
		response.then().body("code", equalTo(1)).body("type", equalTo("error")).body("message", equalTo("Pet not found"));
	}

	@Test()
	public void testGetPetById() {
		reportLog("Started execution of test user document");

		String requestUrl = GlobalConstant.Root_URI + 1;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader()).when().get(requestUrl);
		reportResponseLog(response.asString());
		System.out.println(response.asString());

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
		reportLog("Verify get pets by id response json schema");
		// response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/GetPetSchema.json"));
	}
}
