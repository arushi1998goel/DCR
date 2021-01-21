package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class getDCRAzureConnection extends BaseAPI {
    String baseUrl;
    Response response ;

    @Given("^A request url has been set for getting DCR Azure Scorm Connection String$")
    public void aRequestUrlHasBeenSetForGettingDCRAzureScormConnectionString() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/DCRAzureScormConnectionString";
        logRquestUrl(baseUrl);
    }

    @Then("^Success response should return with Status code and content$")
    public void successResponseShouldReturnWithStatusCodeAndContent() {
        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }


    @And("^Validate the data \"([^\"]*)\" in the response$")
    public void validateTheDataInTheResponse(String contentVal) throws Throwable {
        verifyValueInResponse(response, "", "content", contentVal);
    }
}
