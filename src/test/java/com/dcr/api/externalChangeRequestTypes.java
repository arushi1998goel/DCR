package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class externalChangeRequestTypes extends BaseAPI {
    String baseUrl;
    Response response;

    @Given("^User enters the api request url for external change request$")
    public void userEntersTheApiRequestUrlForExternalChangeRequest() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/ChangeRequestTypes";
        logRquestUrl(baseUrl);
    }

    @When("^User hit the external post request api$")
    public void userHitTheExternalPostRequestApi() {
        response =given().
                header("Content-Type" , "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body("[2]").when().post(baseUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^Success response should return with valid Status code$")
    public void successResponseShouldReturnWithValidStatusCode() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }

    @And("^Validate the fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in the response$")
    public void validateTheFieldsInTheResponse(String definitionData, String changeReasonTypeIdData, String nameData) throws Throwable {
        verifyValueInResponse(response, "", "definition", definitionData);
        verifyValueInResponse(response, "", "changeRequestTypeId", changeReasonTypeIdData);
        verifyValueInResponse(response, "", "name", nameData);
    }
}
