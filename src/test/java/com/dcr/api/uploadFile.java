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
import org.apache.poi.hpsf.GUID;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;
import org.testng.Assert;
import java.util.UUID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class UploadFile extends BaseAPI {
    String requestUrl ;
    Response response ;
    Utilities utilities;
    UUID GUID= utilities.randomGui();
    Object Id;
    Object guid;

    @Given("^Request URL to upload a file$")
    public void requestURLToUploadAFile() throws Exception {
        reportLog("Started execution of test user document");
        requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/File";
        logRquestUrl(requestUrl);
    }

    @When("^User wants to upload a file request with required data passed in body$")
    public void userWantsToUploadAFileRequestWithRequiredDataPassedInBody() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("blobContainer", "49D85F71-C187-4A25-B492-610EE5389659");
        requestParams.put("fileName", "Sample Pdf File.pdf");
        requestParams.put("blobFileName", GUID);
        requestParams.put("extension", "pdf");
        requestParams.put("uploadedById",  "680A3B25-EE02-46F6-92B5-D7BA8C249FCF");
        requestParams.put("changeRequestStatusId", "4DEE0A41-6EA3-4B34-9942-DB02F5DE7F91");

        Id = requestParams.get("blobFileName");
        guid = Id.toString();
        response = given().headers(getAllHeaders()).body(requestParams).when().post(requestUrl).then().log().body().extract().response();
        reportResponseLog(response.asString());
    }

    @And("^User hits the upload file post request$")
    public void userHitsTheUploadFilePostRequest() {
        logMethodType(MethodType.HTTP_POST);
    }

    @Then("^Verify the response body message$")
    public void verifyTheResponseBodyMessage() throws Exception {
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String error = jsonPathEvaluator.get("error");
        System.out.println("Error received from Response: " + error);
        Assert.assertEquals(error, null, "Correct error message is received in the response");
        response.then().body("hasError", equalTo(false));

    }

    public UUID getGUID() {
        return GUID;
    }

    public void setGUID(UUID GUID) {
        this.GUID = GUID;
    }
}
