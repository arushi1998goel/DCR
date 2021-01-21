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

public class updateChangeRequestandPartStatus extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;
    @Given("^Request URL to update a change request and part status from issue$")
    public void requestURLToUpdateAChangeRequestAndPartStatusFromIssue() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName5.updateChangeRequestandPartStatus.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/UpdateCRAndPartStatusFromIssue";
        logRquestUrl(requestUrl);

    }

    @When("^User update the data for change request and part status from issue$")
    public void userUpdateTheDataForChangeRequestAndPartStatusFromIssue() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hit the update request for change request and part status$")
    public void userHitTheUpdateRequestForChangeRequestAndPartStatus() {
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^verify the response code and message after updating the the change request and part status from issue$")
    public void verifyTheResponseCodeAndMessageAfterUpdatingTheTheChangeRequestAndPartStatusFromIssue() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
    }
}
