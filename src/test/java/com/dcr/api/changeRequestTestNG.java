package com.dcr.api;
import com.framework.utilities.BaseAPI;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.MethodType;
import com.sample.apiconstant.GlobalConstant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class changeRequestTestNG extends BaseAPI  {

    public void testGetRequestById() throws Exception {

        reportLog("Started execution of test user document");

        String requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/137C9A7B-315D-4DCA-A8D8-D29D86495224";
        logRquestUrl(requestUrl);
        logMethodType(MethodType.HTTP_GET);
        Response response = given().header(getAcceptJsonHeader()).when().get(requestUrl).then().log().body().extract().response();
        response.then().assertThat().body("parts.changeRequestType.changeRequestTypeId[0]" ,equalTo("9cae0534-19aa-454f-ae29-3ab062665932"));

    }
    public void contextDataInput ( ) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("ChangeRequestbyID.json"));
            jsonObject = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        System.out.println(obj.toString());

        JSONArray jsonArray = (JSONArray) jsonObject.get("parts");
        JSONArray json = (JSONArray) ((JSONObject) jsonArray.get(0)).get("context");

        System.out.println(json.size());
        json.forEach(a -> {
            JSONObject partsObject = (JSONObject) a;
            System.out.println(partsObject.get("label"));
            System.out.println(partsObject.get("key"));
            System.out.println(partsObject.get("order"));
            System.out.println(partsObject.get("contentType"));
        });
    }
    public void testGetChangeReasonTypes() throws Exception {

        reportLog("Started execution of test user document");

        String requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/details/137C9A7B-315D-4DCA-A8D8-D29D86495224";
        logRquestUrl(requestUrl);
        logMethodType(MethodType.HTTP_GET);
        String key="changeRequestDetails";
       Response response = given().header(getAcceptJsonHeader()).when().get(requestUrl).then().log().body().extract().response();
        List<HashMap<String,Object>> requestList=response.jsonPath().getList(key);
        HashMap<String,Object> Details=requestList.get(0);
        String idValue=(String)Details.get("id");
        String typeValue=(String)Details.get("type");
        String desc=(String)Details.get("description");
        String def=(String)Details.get("definition");
        String reasonDesc=(String)Details.get("reasonDescription");
        String changeReason=(String)Details.get("changeReasonType");
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
        Assert.assertEquals(idValue,"111ad346-7fdc-4b88-8c05-b72cbf81433c");
        Assert.assertEquals(typeValue,"Add Assessment to Visit");
        Assert.assertEquals(desc,"Add assessment to visit description");
        Assert.assertEquals(def,"Add assessment to visit Visit 155 for subject 777");
        Assert.assertEquals(reasonDesc,"Data protection and privacy is needed for the site work");
        Assert.assertEquals(changeReason,"Privacy and Data Protection");

    }
    @Test

    public void testCreateChangeRequestTypes() throws Exception{

        reportLog("Started execution of test user document");

        String requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/create";
        logRquestUrl(requestUrl);
        logMethodType(MethodType.HTTP_POST);


        JSONObject request = new JSONObject();
        request.put("studyId", "9A11E558-436B-492A-8D03-0D8D3A1A9C68");
        request.put("siteId", "Edwards");
        request.put("createdBy", "680A3B25-EE02-46F6-92B5-D7BA8C249FCF");
        request.put("parts[0].changeRequestPartId", "null");
        request.put("parts[0].changeRequestTypeId", "9cae0534-19aa-454f-ae29-3ab062665932");
        request.put("parts[0].description", "Add assessment to visit description");
        request.put("parts[0].context[0].label", "Subject #");
        request.put("parts[0].context[0].key", "source_subject");
        request.put("parts[0].context[0].value", "777");
        request.put("parts[0].context[1].label", "Visit Name");
        request.put("parts[0].context[1].key", "source_visit_name");
        request.put("parts[0].context[1].value", "Visit 155");
        request.put("parts[0].context[2].label", "Assessment Name");
        request.put("parts[0].context[2].key", "source_assessment_name");
        request.put("parts[0].context[2].value", "Assessment 155");
        request.put("parts[0].context[3].label", "SVID");
        request.put("parts[0].context[3].key"  ,"source_site");
        request.put("parts[0].context[3].value"  ,"999");
        request.put("parts[0].definition", "Add assessment to visit Visit 155 for subject 777");
        request.put("changeReasonTypeId", "bb794ca2-4905-483c-a96c-ed7080bf4c58");
        request.put("parts[0].reasonDescription", "Data protection and privacy is needed for the site work");
        request.put("priority", "1");
        request.put("priorityDescription"  ,"Low priority");
        request.put("IsDraft"  ,"false");



        Response response =given().
                header("Content-Type" , "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString(request)).when().post(requestUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
            verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);

//        given().
//                header("Content-Type" , "application/json").
//                contentType(ContentType.JSON).accept(ContentType.JSON).
//                body(request.toJSONString(request)).
//                when().
//                post(requestUrl).
//                then().
//                statusCode(200).log().all();

    }
    public void testGetChangeRequestTypes() {





















































































        reportLog("Started execution of test user document");

        String requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/ChangeRequestTypes";
        logRquestUrl(requestUrl);
        logMethodType(MethodType.HTTP_POST);

         Response response =given().
                header("Content-Type" , "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body("[1]").when().post(requestUrl).then().log().body().extract().response();
        String responseData = response.asString();
        System.out.println(responseData);
        reportResponseLog(responseData);
        verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);

    }
}
