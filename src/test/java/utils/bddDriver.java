package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.xml.sax.SAXException;
import utils.PropertyReader;
import utils.JIRA_Updator;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import core.apiDriver;
import core.baseDriver;
import core.webDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


public class bddDriver
{
	public static int  itr;
	public static ThreadLocal<String> TestName= new InheritableThreadLocal<>();
	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	public static final ThreadLocal<RequestSpecification> API_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	public static final ThreadLocal<Response> API_RESPONCE_THREAD_LOCAL = new InheritableThreadLocal<>();
	public static final ThreadLocal<String> Message = new InheritableThreadLocal<>();
	public static ThreadLocal<String> order_id=new InheritableThreadLocal<>();
	public static ThreadLocal<String> dateprovided=new InheritableThreadLocal<>();
	public static ThreadLocal<String> timestamp=new InheritableThreadLocal<>();
	public static ThreadLocal<String> OrderLatestTransactionID=new InheritableThreadLocal<>();

	@Before("@API")
	public void APIsetup(Scenario s){
		apiDriver ApiDriver=new baseDriver();
		API_DRIVER_THREAD_LOCAL.set(ApiDriver.apiinit(""));
		API_RESPONCE_THREAD_LOCAL.set(null);
		
	}
	
	@Before("@WEB")
	public void Websetup(Scenario s) throws Exception{
	
		webDriver webDriver=new baseDriver();
		WEB_DRIVER_THREAD_LOCAL.set(webDriver.webinit("chrome", "https://google.com", false));	
		
	}
	@After("@WEB")
	public void TearDown(Scenario s) throws IOException{

		String TestCaseID=s.getSourceTagNames().iterator().next();
		//s.
		System.out.println("TestCaseID is"+s.getId());
		 if (s.isFailed()) {
			 String sourcePath = "data:image/png;base64,"+((TakesScreenshot)WEB_DRIVER_THREAD_LOCAL.get()).
		                getScreenshotAs(OutputType.BASE64);;
		                Reporter.addScreenCaptureFromPath(sourcePath);
			 JIRA_Updator rlu=new JIRA_Updator();
		     rlu.Create("QABuild", "413450412168", "Fail");
		 }

		 else
		 {
			 JIRA_Updator rlu=new JIRA_Updator();
				rlu.Create("QABuild", "413450412168", "Pass");
		 }
		 WEB_DRIVER_THREAD_LOCAL.get().quit();
	}

	@After("@API")
	public void APITearDown(Scenario s) throws IOException{
		PropertyReader prpertyreader = new PropertyReader();
		if(!prpertyreader.readproperty("ENV").trim().equalsIgnoreCase("LOCAL"))
		{
			try {
				String TestCaseID=s.getId();
				System.out.println("TestCaseID is"+TestCaseID);
				TestCaseID=TestCaseID.split(";")[1];
				System.out.println("TestCaseID is"+TestCaseID);
				String[] TestSrings=TestCaseID.split("-");
				TestCaseID=TestSrings[TestSrings.length-1];
				System.out.println("TestCaseID is"+TestCaseID);
				 if (s.isFailed()) {

				     JIRA_Updator rlu=new JIRA_Updator();
//				     rlu.Create("QABuild", TestCaseID, "Fail"); // UnComment when use in BT rally after configure
				 }
				 else
				 {
					 JIRA_Updator rlu=new JIRA_Updator();
// 						rlu.Create("QABuild", TestCaseID, "Pass"); // UnComment when use in BT rally after configure
				 }

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("=> Test Result is not updated in the rally "+e.getMessage());
			}
		}
	}


	@org.testng.annotations.BeforeSuite
	public void BeforeSuite(){
	itr=0;
	DOMConfigurator.configure("log4j.xml");
	}
	
	public static WebDriver getWebDriver(){
		return WEB_DRIVER_THREAD_LOCAL.get();
	}
	public RequestSpecification getApiDriver(){
		return API_DRIVER_THREAD_LOCAL.get();
	}
	public void setOrderid(String orderid){
		order_id.set(orderid);
	}
	public String getOrderid(){
		return order_id.get();
	}
	public String getcurrenttimestamp(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		timestamp.set(formatter.format(date));
		return timestamp.get();

	}
	public String getBeforetimestamp(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		System.out.println("Date = " + cal.getTime());
		timestamp.set(formatter.format(cal.getTime()));
		return timestamp.get();


	}
	public String getcurrentdate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		dateprovided.set(formatter.format(date));
		return dateprovided.get();

	}
	public String getbackdate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		System.out.println("Date = " + cal.getTime());
		dateprovided.set(formatter.format(cal.getTime()));
		return dateprovided.get();

	}

	public String RetuninspecifiedFormate(String datetobefomated, String formate) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date DateintoDB=formatter.parse(datetobefomated);
		DateFormat dDate=new SimpleDateFormat(formate);
		//formatter.format(datetobefomated.toString());
		return dDate.format(DateintoDB);

	}
	public String returnDate(){

		return dateprovided.get();

	}
	public String returnDatetimestamp(){

		return timestamp.get();

	}
	public void settransaction_id(String trid){
		OrderLatestTransactionID.set(trid);
     }
	public String gettransaction_id(){
		return OrderLatestTransactionID.get();
	}

	public String VerifyHtmlContent(String data,String tag) throws DocumentException {

	org.jsoup.nodes.Document doc = Jsoup.parse(data);

		String link = doc.select("body").toString().replaceAll("  ","").replaceAll("&lt;","<").replaceAll("&gt;",">").replaceAll("<br>","").replaceAll("<body class=\"test\">","").replaceAll("<.body>","").trim();;

//		String strLineApp = link.text().replaceAll("&"+"nbsp;", " ");
//		strLineApp = strLineApp.replaceAll(String.valueOf((char) 160), " ");
		System.out.println("Value for the tage in response is"+link);
		SAXReader xmlreader=new SAXReader();
		Document doc1=xmlreader.read(new StringReader(link));


		doc1.selectSingleNode(tag).getText();
		System.out.println("Value for the tage in response is"+doc1.selectSingleNode(tag).getText());
		//Assert.assertTrue(doc.selectSingleNode(Node).getText().equals(Expectedvalue),"Expected the Value of <b>"+Node+"</b> Attribute value contains <b>"+Expectedvalue+"</b> but  Actual returned was <b>"+doc.selectSingleNode(Node).getText()+"</b>");


       return doc1.selectSingleNode(tag).getText();

	}
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
		String updatedpath = System.getProperty("user.dir")+ "/src/test/resources/apiResourceTemplate/";
		try {
			SchemaFactory factory =
					SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(updatedpath+xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(updatedpath+xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: "+e.getMessage());
			return false;
		}
		return true;
	}
	
}