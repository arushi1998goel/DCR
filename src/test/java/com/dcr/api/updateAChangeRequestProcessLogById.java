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
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class updateAChangeRequestProcessLogById extends BaseAPI {

    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;
    @Given("^Request URL to post updating a Change Request Process Log by Id$")
    public void requestURLToPostUpdateChangeRequestProcessLogById() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName10.changeRequestProcessLog.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequestProcessLog/update/60B2424D-C1E6-45BE-B441-2B3EA70A724A";
        logRquestUrl(requestUrl);
    }

    @When("^User enters the required data$")
    public void userEntersTheRequiredData() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hit the post request for updating a Change Request Process Log by Id$")
    public void userHitThePostRequestForUpdateChangeRequestProcessLogById() {
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^Verify the response code and message for updating a Change Request Process Log by Id$")
    public void verifyTheResponseCodeAndMessageForUpdateChangeRequestProcessLogById() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
    }
}
