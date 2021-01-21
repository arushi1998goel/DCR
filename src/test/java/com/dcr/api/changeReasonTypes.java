package com.dcr.api;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import core.apiHelper;
import core.baseDriverHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import io.restassured.response.Response;
import utils.PropertyReader;
import utils.bddDriver;

public class changeReasonTypes extends BaseAPI {
    String baseUrl;
    Response response ;


    @Given("^A request url has been set for getting Change Reason Type$")
    public void aRequestUrlHasBeenSetForGettingChangeReasonType() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/changeReasonTypes";
        logRquestUrl(baseUrl);
    }
    @When("^User hit the get api request$")
    public void userHitTheApiRequest() {

        logMethodType(MethodType.HTTP_GET);
    }

    @Then("^Success response has been returned with Status code$")
    public void successResponseHasBeenReturnedWithStatusCode() {

        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);

    }
    @And("^Validate the data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheData(String changeActionIdData, boolean isStudySpecificData, String changeReasonTypeIdData, String englishNameData) throws Throwable {
        verifyValueInResponse(response,"","changeActionId",changeActionIdData);
        verifyValueInResponse(response,"","changeReasonTypeId",changeReasonTypeIdData);
        verifyValueInResponse(response,"","englishName" ,englishNameData);
        verifyValueInResponse(response,"","isStudySpecific" ,isStudySpecificData);
    }


}




