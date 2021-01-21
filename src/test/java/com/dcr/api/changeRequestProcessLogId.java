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

public class changeRequestProcessLogId extends BaseAPI {
    String baseUrl;
    Response response ;
    @Given("^A request url has been set for getting Change Request Process Log by Id$")
    public void aRequestUrlHasBeenSetForGettingChangeRequestProcessLogById() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequestProcessLog/60B2424D-C1E6-45BE-B441-2B3EA70A724A";
        logRquestUrl(baseUrl);
    }

    @Then("^Success response should be returned with Status code$")
    public void successResponseShouldBeReturnedWithStatusCode() {

        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);

    }

    @And("^Validate the response fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheResponseFields(String changeRequestProcessLogId, String changeRequestId, int statusId, String createdById, String lastModifiedById) throws Throwable {
        verifyValueInResponse(response,"","changeRequestProcessLogId" ,changeRequestProcessLogId);
        verifyValueInResponse(response,"","changeRequestId" ,changeRequestId);
        verifyValueInResponse(response,"","statusId" ,statusId);
        verifyValueInResponse(response,"","createdById" ,createdById);
        verifyValueInResponse(response,"","lastModifiedById" ,lastModifiedById);
    }


}
