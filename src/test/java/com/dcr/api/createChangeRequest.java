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

public class createChangeRequest extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;



    @Given("^Request URL to create a change request$")
    public void requestURLToCreateAChangeRequest() throws Exception {
        jsonData=JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName2.CreateRequest.toString());
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/create";
        logRquestUrl(requestUrl);


    }

    @When("^User wants to create a change request with required data passed in body$")
    public void userWantsToCreateAChangeRequestWithRequiredDataPassedInBody() {
        logPostBody(jsonData.toString());
        response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl).then().log().body().extract().response();
       reportResponseLog(response.asString());
    }


    @And("^User hit the post request$")
    public void userHitThePostRequest() {

        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^verify the response code and message$")
    public void verifyTheResponseCodeAndMessage() throws Exception {
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




