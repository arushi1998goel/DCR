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

public class postDataChangeByStudyId extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;
    @Given("^Request URL to post data change by study ID$")
    public void requestURLToPostDataChangeByStudyID() throws Exception {
        jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName9.postDataChange.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/9A11E558-436B-492A-8D03-0D8D3A1A9C68/DataChange";
        logRquestUrl(requestUrl);
    }

    @When("^User add the required data$")
    public void userAddTheRequiredData() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hit the post request for data change$")
    public void userHitThePostRequestForDataChange() {
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^verify the response code and message for data change by study ID$")
    public void verifyTheResponseCodeAndMessageForDataChangeByStudyID() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
    }

}
