package com.dcr.api;

import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.JsonFileUtil;
import com.sample.apiconstant.GlobalConstant;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class changeRequestById extends BaseAPI {
    String baseUrl;
    Response response;
    JsonFileUtil json ;


    @Given("^A request url has been set for getting Change Reason Type by id$")
    public void aRequestUrlHasBeenSetForGettingChangeReasonTypeById() {
        reportLog("Started execution of test user document");
        baseUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/17C73129-8931-4EF3-8EE0-77632C472B58/680A3B25-EE02-46F6-92B5-D7BA8C249FCF";
        logRquestUrl(baseUrl);
    }

    @And("^Validate the response of the parts fields \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheResponseOfThePartsFields(String changeRequestId, String parts_id, String changeRequestPartDefinition, String description, int priority, String priorityDescription, String studyId, String siteId, String siteName, String studyName, String status , String statusId) throws Throwable {
        response.then().assertThat().body("changeRequestId" ,equalTo(changeRequestId));
        response.then().assertThat().body("parts.id[0]" ,equalTo(parts_id));
        response.then().assertThat().body("parts.changeRequestPartDefinition[0]" ,equalTo(changeRequestPartDefinition));
        response.then().assertThat().body("parts.description[0]" ,equalTo(description));
        response.then().assertThat().body("priority" ,equalTo(priority));
        response.then().assertThat().body("priorityDescription" ,equalTo(priorityDescription));
        response.then().assertThat().body("studyId" ,equalTo(studyId));
        response.then().assertThat().body("siteId" ,equalTo(siteId));
        response.then().assertThat().body("siteName" ,equalTo(siteName));
        response.then().assertThat().body("studyName" ,equalTo(studyName));
        response.then().assertThat().body("status" ,equalTo(status));
        response.then().assertThat().body("statusId" ,equalTo(statusId));

    }


    @And("^Validate the changeRequestType fields \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheChangeRequestTypeFields(String changeRequestTypeId, String name) throws Throwable {
        response.then().assertThat().body("parts.changeRequestType.changeRequestTypeId[0]" ,equalTo(changeRequestTypeId));
        response.then().assertThat().body("parts.changeRequestType.name[0]" ,equalTo(name));


    }

    @And("^Validate the changeReasonType fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validateTheChangeReasonTypeFields(String changeReasonTypeId, String englishName, String reasonDescription) throws Throwable {
        response.then().assertThat().body("parts.changeReasonType.changeReasonTypeId[0]", equalTo(changeReasonTypeId));
        response.then().assertThat().body("parts.changeReasonType.englishName[0]", equalTo(englishName));
        response.then().assertThat().body("parts.reasonDescription[0]", equalTo(reasonDescription));
    }

    @And("^Validate the context fields")
    public void validateTheContextFields(DataTable table) throws Throwable {
        List<Map<String,String>> mapTable = table.asMaps(String.class,String.class);
        System.out.println(mapTable.size());
        for (int i=0 ;i<mapTable.size() ;i++){
            System.out.println("Key is "+ mapTable.get(i).get("key")) ;
            Object keyExp = mapTable.get(i).get("key");
            System.out.println("Label is " +mapTable.get(i).get("label") );
            System.out.println(" Value is " +mapTable.get(i).get("value") );

            JSONObject jsonObject = null;
            try {
                jsonObject = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName2.CreateRequest.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
            System.out.println(jsonObject.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("parts");
            JSONArray json = (JSONArray) ((JSONObject) jsonArray.get(0)).get("context");
            System.out.println(json.size());
            json.forEach(a -> {
                JSONObject partsObject = (JSONObject)a;
                System.out.println(partsObject.get("label"));
                Object keyActual = partsObject.get("key").toString();
                System.out.println(partsObject.get("actual key is : " + keyActual));
                System.out.println(partsObject.get("value"));
                Assert.assertEquals(keyExp, keyActual);

            }
            );

        }

    }

    @Then("^Success response has been returned with valid Status code$")
    public void successResponseHasBeenReturnedWithValidStatusCode() {
        response = given().header(getAcceptJsonHeader()).when().get(baseUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
    }



}

