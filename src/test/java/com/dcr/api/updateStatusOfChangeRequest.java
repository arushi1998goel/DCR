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

public class updateStatusOfChangeRequest extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;

    @Given("^Request URL to update a change request status$")
    public void requestURLToUpdateAChangeRequestStatus() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName6.updateChangeRequestStatus.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/UpdateStatus";
        logRquestUrl(requestUrl);
    }

    @When("^User adds the data for updating the change request status$")
    public void userAddsTheDataForUpdatingTheChangeRequestStatus() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hit the update request to change the status of a Change Request$")
    public void userHitTheUpdateRequestToChangeTheStatusOfAChangeRequest() {

        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^verify the response code and message for updating the status of a Change Request$")
    public void verifyTheResponseCodeAndMessageForUpdatingTheStatusOfAChangeRequest() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
    }


}
