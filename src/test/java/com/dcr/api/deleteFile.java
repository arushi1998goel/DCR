package com.dcr.api;

import com.framework.utilities.*;
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
import com.dcr.api.UploadFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteFile extends BaseAPI {
    String requestUrl ;
    public JSONObject jsonData ;
    Response response ;

    @Given("^Request URL to delete a file$")
    public void requestURLToDeleteAFile() throws Exception {
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/DeleteFile";
        logRquestUrl(requestUrl);
    }

    @When("^User wants to delete a file request with required data passed in body$")
    public void userWantsToDeleteAFileRequestWithRequiredDataPassedInBody() {
        UploadFile uf= new UploadFile();
        System.out.println(uf.guid);
        JSONObject requestParams = new JSONObject();
        requestParams.put("blobContainer", "49D85F71-C187-4A25-B492-610EE5389659");
        requestParams.put("blobFileName", uf.guid+".pdf");
        requestParams.put("deletedById",  "680A3B25-EE02-46F6-92B5-D7BA8C249FCF");

        response = given().headers(getAllHeaders()).body(requestParams).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hits the delete file post request$")
    public void userHitsTheDeleteFilePostRequest() {

        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^Verify the response body messages$")
    public void verifyTheResponseBodyMessages() throws Exception {
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
