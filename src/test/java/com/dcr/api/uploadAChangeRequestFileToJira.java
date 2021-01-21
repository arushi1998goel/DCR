package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.JsonFileUtil;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class uploadAChangeRequestFileToJira extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;



    @Given("^Request URL to uploading a change request file to Jira$")
    public void requestURLToUploadingAChangeRequestFileToJira() throws Exception {
       //jsonData= JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName6.CreateDataChangeByStudyIdRequest.toString());
       reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequestFile/57E7BBD9-F655-4780-979A-026B49E8D767/UploadedToJira";
        logRquestUrl(requestUrl);


    }

    @When("^User wants to uploading a change request file to Jira request with required data passed in body$")
    public void userWantsToUploadingAChangeRequestFileToJiraRequestWithRequiredDataPassedInBody() {
        //logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hit the uploading a change request file to Jira Id post request$")
    public void userHitsTheUploadingAChangeRequestFileToJiraIdPostRequest() {

        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^Verify response body message$")
    public void verifyResponseBodyMessage() throws Exception {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String error = jsonPathEvaluator.get("error");
        System.out.println("Error received from Response: " + error);
        Assert.assertEquals(error, null, "Correct error message is received in the response");
        response.then().body("hasError", equalTo(false));

    }
}
