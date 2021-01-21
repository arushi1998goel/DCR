package com.framework.utilities;

import java.io.IOException;
import java.util.*;

import io.restassured.path.json.JsonPath;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.apitest.model.PetsDataModel;
import com.aventstack.extentreports.Status;
import com.framework.report.ReportTestManager;
import com.framework.selenium.core.Configuration;
import com.sample.apiconstant.GlobalConstant;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;

abstract public class BaseAPI implements RestApi  {
	public static Response Resultrespoence ;

	protected static String endPointUrl;

	@BeforeSuite
	public void beforeAPI() throws Exception {
		endPointUrl = Configuration.readApplicationFile("APIURL");
	}
	
	public void reportLog(String message) {		
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.PASS, message);
		}
		Reporter.log(message);
	}


	public void reportResponseLog(String message) {
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.INFO, "Below are response ");
			ReportTestManager.getTest().log(Status.INFO, message);
		}	
		Reporter.log(message);
	}
	
	public void logRquestUrl(String url) {	
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.INFO, endPointUrl + "/"+ url);
		}
		Reporter.log(url);
	}

	public void logMethodType(String method) {
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.INFO, "Request method :"+ method);
		}
	}
	

	public void logPostBody(String body) {	
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.INFO, "Post method Request body :");
			ReportTestManager.getTest().log(Status.INFO, body);
		}
	}	

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = endPointUrl;
		RestUtil.setBaseURI(endPointUrl);
	}


	/**
	 * Convert JSON Object or JSON Array into String type
	 * 
	 * @param jsonObject
	 * @return
	 */
	public String jsonTOString(Object jsonObject) {
		String jsonString = null;
		if (jsonObject instanceof JSONArray) {
			jsonString = ((JSONArray) jsonObject).toJSONString();
		} else if (jsonObject instanceof JSONObject) {
			jsonString = ((JSONObject) jsonObject).toJSONString();
		}
		return jsonString;
	}

	/**
	 * Get Headers
	 * 
	 * @param ssid
	 * @param beToken
	 * @param httpReferer
	 * @return
	 */
	public Headers getAllHeaders() {
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("accept", "application/json");
		List<Header> list = new LinkedList<Header>();
		list.add(header1);
		list.add(header2);
		Headers headers = new Headers(list);
		return headers;
	}

	/**
	 * Get Headers
	 * 
	 * @param ssid
	 * @param beToken
	 * @param httpReferer
	 * @return
	 */
	public Headers getAllXMLHeaders() {
		Header header1 = new Header("Content-Type", "application/xml");
		Header header2 = new Header("accept", "application/xml");
		List<Header> list = new LinkedList<Header>();
		list.add(header1);
		list.add(header2);
		Headers headers = new Headers(list);
		return headers;
	}
	public Header getContentTypeJsonHeader() {
		return new Header("Content-Type", GlobalConstant.Application_JSON);
	}

	public Header getAcceptJsonHeader() {
		return new Header("accept", GlobalConstant.Application_JSON);
	}

	public void verifyResponseCodeAndContentType(Response response, int code, String contentType) {
		reportLog("Verified response code " + code);
		RestUtil.verifyResponseCode(response, code);

		reportLog("Verified content type " + contentType);
		RestUtil.verifyResponseContentType(response, contentType);
	}
		
	public String getPetsXml(PetsDataModel petsModel){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Pet>	<id>0</id>	"
				+ "<Category><id>"+petsModel.getCategoryName()+"</id>"
				+ "<name>"+petsModel.getCategoryName()+"</name>	"
				+ "</Category>	"
				+ "<name>"+petsModel.getName()+"</name>	"
				+ "<photoUrl><photoUrl>string</photoUrl>	</photoUrl>	"
				+ "<tag>"
				+ "<Tag><id>0</id>	"
				+ "<name>"+petsModel.getTagName()+"</name>		"
				+ "</Tag>	"
				+ "</tag>	"
				+ "<status>"+petsModel.getStatus()+"</status></Pet>";
	}

	public void assertResponceBodyAttribute(String Node, String Expectedvalue) throws SAXException, IOException, ParserConfigurationException, DocumentException {
		System.out.println("Respoence body is "+Resultrespoence.getBody().asString());
		//ExtentTestManager.getTest().log(LogStatus.INFO, "Respoence body is "+Resultrespoence.getBody().asString());
		if(Resultrespoence.getHeader("content-type").contains("json")) {
			JsonPath jsonPathValue = Resultrespoence.jsonPath();
			//ExtentTestManager.getTest().log(LogStatus.INFO, "JsoneBody as String String"+jsonPathValue);
			String Nodevalue = jsonPathValue.getString(Node);
			System.out.println("The value of "+Node+" is: "+ Nodevalue);
			//ExtentTestManager.getTest().log(LogStatus.INFO, "The value of "+Node+" is: "+ Nodevalue);

			System.out.println("Expected Value is : "+ Expectedvalue);
			//ExtentTestManager.getTest().log(LogStatus.INFO, "Expected Value is : "+ Expectedvalue);

			System.out.println("Condition Value is "+ Nodevalue.contains(Expectedvalue));
			//Assert.assertTrue();
			//ExtentTestManager.getTest().log(LogStatus.INFO, "Condition Value is "+ Nodevalue.contains(Expectedvalue));

			Assert.assertTrue(Nodevalue.contains(Expectedvalue), "Expected the Value of <b>"+Node+"</b> Attribute value contains <b>"+Expectedvalue+"</b> but  Actual returned was <b>"+Nodevalue+"</b>");
		}
		else if(Resultrespoence.getHeader("content-type").contains("xml"))
		{

			SAXReader xmlreader=new SAXReader();
			Document doc=xmlreader.read(Resultrespoence.asInputStream());
			Assert.assertTrue(doc.selectSingleNode(Node).getText().equals(Expectedvalue),"Expected the Value of <b>"+Node+"</b> Attribute value contains <b>"+Expectedvalue+"</b> but  Actual returned was <b>"+doc.selectSingleNode(Node).getText()+"</b>");
		}else
		{
			Assert.fail("Response Content-Type is not matched.Please check the Assertion");
		}

	}

	public void Stringcomparator(String actual, String expected) {
		System.out.println("Actual String : " + actual);
		System.out.println("Expected String : " + expected);
		if(expected==null)
		{
			expected="";
		}
		if(actual==null)
		{
			actual="";
		}

		Assert.assertTrue(actual.equals(expected));


	}

}
