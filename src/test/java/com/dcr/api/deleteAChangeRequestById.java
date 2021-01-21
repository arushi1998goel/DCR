package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteAChangeRequestById extends BaseAPI {

    String requestUrl ;
    Response response ;

    @Given("^Request URL to  Delete a Change Request by Id$")
    public void requestURLToDeleteChangeRequestById() throws Exception {
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/delete/C6D97DCE-E03A-4182-ADEE-054E8ECC37C5";
        logRquestUrl(requestUrl);
    }

    @When("^User enters the required data for Delete Request$")
    public void userEntersTheRequiredDataForDeleteRequest() {
        response = given().headers(getAllHeaders()).when().delete(requestUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
    }

    @And("^User hit the delete request for deleting a Change Request by Id$")
    public void userHitTheDeleteRequestForDeletingAChangeRequestById() {
        logMethodType(MethodType.HTTP_DELETE);
    }

    @Then("^Verify the response code and message for deleting a Change Request by Id$")
    public void verifyTheResponseCodeAndMessageForDeletingAChangeRequestById() {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        response.then().body("error", equalTo(7)).body("hasError", equalTo(true));
    }
}
