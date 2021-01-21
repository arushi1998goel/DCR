package com.dcr.api;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.json.simple.JSONObject;
        import com.framework.utilities.BaseAPI;
        import com.framework.utilities.HttpStatusCode;
        import com.framework.utilities.JsonFileUtil;
        import com.framework.utilities.MethodType;
        import com.sample.apiconstant.GlobalConstant;
        import io.restassured.response.Response;

        public class updateChangeRequest extends BaseAPI { String requestUrl ;
        private int requestId;
        private JSONObject jsonData;
        Response response ;

            @Given("^Request URL to update a change request$")
            public void requestURLToUpdateAChangeRequest() throws Exception {
                jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, GlobalConstant.FileName3.UpdateRequest.toString());
                reportLog("Started execution of test user document");
                requestUrl = "https://sfinternalqa2.medavante.net/medavante.changerequest/api/ChangeRequest/update";
                logRquestUrl(requestUrl);
            }
            @When("^User wants to update a change request with required data passed in body$")
            public void userWantsToUpdateAChangeRequestWithRequiredDataPassedInBody() {
                logPostBody(jsonData.toString());
                response = given().headers(getAllHeaders()).body(jsonData).when().put(requestUrl).then().log().body().extract().response();
                reportResponseLog(response.asString());
            }
            @And("^User hit the update request$")
            public void userHitTheUpdateRequest() {
                logMethodType(MethodType.HTTP_PUT);
            }


            @Then("^verify the response code and message after updating the request$")
            public void verifyTheResponseCodeAndMessageAfterUpdatingTheRequest() {
                verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
                response.then().body("error", equalTo(null)).body("hasError", equalTo(false));
            }


        }

