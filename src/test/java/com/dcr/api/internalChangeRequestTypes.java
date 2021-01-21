package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class internalChangeRequestTypes extends BaseAPI {
    String baseUrl;
    Response response;

    @Given("^User enters the api request url for internal change request$")
    public void userEntersTheApiRequestUrlForInternalChangeRequest() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/ChangeRequestTypes";
        logRquestUrl(baseUrl);
    }

    @When("^User hit the internal post request api$")
    public void userHitTheInternalPostRequestApi() {
        response =given().
                header("Content-Type" , "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body("[1]").when().post(baseUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        logMethodType(MethodType.HTTP_POST);
    }
    @Then("^Success response should return with Status code$")
    public void successResponseShouldReturnWithStatusCode() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }


    @And("^Validate the response \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheResponse(String definitionData, String changeReasonTypeIdData, String nameData) throws Exception {
        verifyValueInResponse(response, "", "definition", definitionData);
        verifyValueInResponse(response, "", "changeRequestTypeId", changeReasonTypeIdData);
        verifyValueInResponse(response, "", "name", nameData);
    }

}
