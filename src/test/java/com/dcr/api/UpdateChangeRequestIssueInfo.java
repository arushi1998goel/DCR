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

public class UpdateChangeRequestIssueInfo extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;

    @Given("^Request URL to update a change request issue info$")
    public void requestURLToUpdateAChangeRequestIssueInfo() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName4.UpdateChangeRequestIssueInfo.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/UpdateChangeRequestIssueInfo";
        logRquestUrl(requestUrl);
    }

    @When("^User wants to update a change request issue info with required data passed in body$")
    public void userWantsToUpdateAChangeRequestIssueInfoWithRequiredDataPassedInBody() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
        
    }

    @And("^User hit the update request to change the request issue$")
    public void userHitTheUpdateRequestToChangeTheRequestIssue() {
        logMethodType(MethodType.HTTP_POST);
        
    }

    @Then("^verify the response code and message after updating the change request issue$")
    public void verifyTheResponseCodeAndMessageAfterUpdatingTheChangeRequestIssue() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
    }

}
