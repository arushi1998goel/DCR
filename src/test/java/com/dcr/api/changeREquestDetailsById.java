package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class changeREquestDetailsById extends BaseAPI {
    String baseUrl;
    Response response;
    @Given("^A request url has been set for getting Change Request Details By Id$")
    public void aRequestUrlHasBeenSetForGettingChangeRequestDetailsById() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/details/17C73129-8931-4EF3-8EE0-77632C472B58/680A3B25-EE02-46F6-92B5-D7BA8C249FCF";
        logRquestUrl(baseUrl);
    }

    @Then("^Validate the success response with valid Status code$")
    public void validateTheSuccessResponseWithValidStatusCode() {
        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }

    @And("^Validate the response data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheResponseData(String id, String status, String requestedBy, String priority, String changeRequestNumberDescription, String createdById, String studyId, String siteId , String issueKey) throws Throwable {
        verifyValueInResponse(response, "", "id", id);
        verifyValueInResponse(response, "", "status", status);
        verifyValueInResponse(response, "", "requestedBy", requestedBy);
        verifyValueInResponse(response, "", "priority", priority);
        verifyValueInResponse(response, "", "changeRequestNumberDescription", changeRequestNumberDescription);
        verifyValueInResponse(response, "", "createdById", createdById);
        verifyValueInResponse(response, "", "studyId", studyId);
        verifyValueInResponse(response, "", "siteId", siteId);
        verifyValueInResponse(response, "", "issueKey", issueKey);
    }

    @And("^Validate changeRequestDetails fields value \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateChangeRequestDetailsFieldsValue(String idValue, String type, String description, String definition, String reasonDescription, String changeReasonType) throws Throwable {
        String key="changeRequestDetails";
        List<HashMap<String,Object>> requestList=response.jsonPath().getList(key);
        HashMap<String,Object> Details=requestList.get(0);
        String idData=(String)Details.get("id");
        String typeValue=(String)Details.get("type");
        String desc=(String)Details.get("description");
        String def=(String)Details.get("definition");
        String reasonDesc=(String)Details.get("reasonDescription");
        String changeReason=(String)Details.get("changeReasonType");
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        Assert.assertEquals(idData,idValue);
        Assert.assertEquals(typeValue,type);
        Assert.assertEquals(desc,description);
        Assert.assertEquals(def,definition);
        Assert.assertEquals(reasonDesc,reasonDescription);
        Assert.assertEquals(changeReason,changeReasonType   );

    }
}
