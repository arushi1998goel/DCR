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
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class availableActionsForChangeRequest extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;


    @Given("^User enters the request url for the available actions$")
    public void userEntersTheRequestUrlForTheAvailableActions() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName7.availableActionsForChangeRequest.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/actions";
        logRquestUrl(requestUrl);
    }


    @When("^User adds the data for the available actions$")
    public void userAddsTheDataForTheAvailableActions() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());

    }

    @And("^User hit the update request for the response of the available actions$")
    public void userHitTheUpdateRequestForTheResponseOfTheAvailableActions() {
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^verify the response code and message for response of the available actions based on the claims for a Change Request$")
    public void verifyTheResponseCodeAndMessageForResponseOfTheAvailableActionsBasedOnTheClaimsForAChangeRequest() throws Exception {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
       Assert.assertTrue(true,"[]");

    }
}
