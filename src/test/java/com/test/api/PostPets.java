package com.test.api;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.JsonFileUtil;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import static com.sample.apiconstant.GlobalConstant.FileName;
import io.restassured.response.Response;

public class PostPets extends BaseAPI {

	private int petsId;
	private JSONObject jsonData;

	@BeforeClass
	public void setJson() throws Exception {
		jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, FileName.Pets.toString());
	}

	@Test
	public void testPostPets() throws Exception {
		reportLog("Started execution of test user Post pets");
		String requestUrl = GlobalConstant.Root_URI;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_POST);
		logPostBody(jsonData.toString());
		
		Response response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl);
		reportResponseLog(response.asString());
		
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
		int id = ((Long) jsonData.get("id")).intValue();

		response.then().body("category.id", equalTo(0)).body("id", equalTo(id));
		petsId = response.then().extract().path("id");

		reportLog("Verify post response json schema");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/PostsShema.json"));
	}

	@Test(dependsOnMethods = "testPostPets")
	public void testGetPetsById() throws Exception {
		reportLog("Started execution of test get pets");
		String requestUrl = GlobalConstant.Root_URI + petsId;
		
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_GET);
		Response response = given().header(getAcceptJsonHeader()).when().get(requestUrl);
		reportResponseLog(response.asString());

		int id = ((Long) jsonData.get("id")).intValue();
		response.then().body("category.id", equalTo(0)).body("category.name", equalTo("string")).body("id", equalTo(id)).body("status", equalTo(jsonData.get("status"))).body("name",
				equalTo(jsonData.get("name")));

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
		reportLog("Verify get pets by id response json schema");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/GetPetSchema.json"));
	}

	@Test(dependsOnMethods = "testGetPetsById")
	public void testDeletePetsById() throws Exception {
		reportLog("Started execution of test delete pets");

		String requestUrl = GlobalConstant.Root_URI + petsId;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_DELETE);
		Response response = given().header(getAcceptJsonHeader()).when().delete(requestUrl);
		reportResponseLog(response.asString());
		
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
	}
	
}
