package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class getDataChangebySpecificStudyId extends BaseAPI {
    String baseUrl;
    Response response ;

    @Given("^A request url has been set for getting the order of the approvers of a specific study$")
    public void aRequestUrlHasBeenSetForGettingTheOrderOfTheApproversOfASpecificStudy() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/9A11E558-436B-492A-8D03-0D8D3A1A9C68/DataChange";
        logRquestUrl(baseUrl);
    }

    @Then("^Success response should be returned for the study ID$")
    public void successResponseShouldBeReturnedForTheStudyID() {
        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }

    @And("^Validate the response fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheResponseFields(int siteVal, int mapppmval, int sponsorCROVal, int mappcdsVal) throws Throwable {
        verifyValueInResponse(response,"","site" ,siteVal);
        verifyValueInResponse(response,"","mapppm" ,mapppmval);
        verifyValueInResponse(response,"","sponsorCRO" ,sponsorCROVal);
        verifyValueInResponse(response,"","mappcds" ,mappcdsVal);
    }


}
