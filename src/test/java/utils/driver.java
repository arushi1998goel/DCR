package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import core.apiDriver;
import core.baseDriver;
import core.webDriver;
import cucumber.api.java.Before;

public class driver extends pageController
{
	public static int  itr;
	public static ThreadLocal<String> TestName= new InheritableThreadLocal<>();
	public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	public static final ThreadLocal<RequestSpecification> API_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	public static final ThreadLocal<Response> API_RESPONCE_THREAD_LOCAL = new InheritableThreadLocal<>();
	
	@BeforeMethod(groups = { "api" })
	@Before
	public void APIsetup(Method method,ITestContext ctx ,Object[] data){
	
		Object[][] st1 = null;
		try 
		{
	 	st1=(Object[][]) data[0];
	 	System.out.println("Lenghth of Complete Data provided by DP"+st1.length);
		}
		catch(Exception e)
		{
			st1=new Object[][] {{""}};
		}
		Object[] st = null;
		try 
		
		{
	 	st=(Object[]) st1[0];
	 	System.out.println("Length of First Data provided by DP"+st.length);
		}
		catch(Exception e)
		{
			st=new Object[][] {{""}};
			System.out.println(e.getMessage());
		}
		
			try {
		    Log.info(st[st.length-2].toString());
		    TestName.set(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				TestName.set("Default");
			    ctx.setAttribute("testName", "Default");
			
	      }
		
		apiDriver ApiDriver=new baseDriver();
		
		API_DRIVER_THREAD_LOCAL.set(ApiDriver.apiinit("https://google.com"));
		API_RESPONCE_THREAD_LOCAL.set(null);
		
		this.initPage(API_DRIVER_THREAD_LOCAL.get(),API_RESPONCE_THREAD_LOCAL.get());
	}
	
	@BeforeMethod(groups = { "web" })
	@Before
	public void Websetup(Method method,ITestContext ctx ,Object[] data) throws Exception{
	
		System.out.println("Wen Before method");
		Object[][] st1 = null;
		try 
		{
	 	st1=(Object[][]) data[0];
	 	System.out.println("Lenghth of Complete Data provided by DP"+st1.length);
		}
		catch(Exception e)
		{
			st1=new Object[][] {{""}};
		}
		Object[] st = null;
		try 
		
		{
	 	st=(Object[]) st1[0];
	 	System.out.println("Length of First Data provided by DP"+st.length);
		}
		catch(Exception e)
		{
			st=new Object[][] {{""}};
			System.out.println(e.getMessage());
		}
		try {
		
		    TestName.set(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	     
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		TestName.set("Default");
	    ctx.setAttribute("testName", "Default");
	}
		webDriver webDriver=new baseDriver();
		WEB_DRIVER_THREAD_LOCAL.set(webDriver.webinit("chrome", "https://google.com", false));
		
		this.initPage(WEB_DRIVER_THREAD_LOCAL.get());
		
	}
	@Before
	@BeforeMethod(groups = { "All" })
	public void AllSetup(Method method,ITestContext ctx ,Object[] data) throws Exception{
	
		Object[][] st1 = null;
		try 
		{
	 	st1=(Object[][]) data[0];
	 	System.out.println("Lenghth of Complete Data provided by DP"+st1.length);
		}
		catch(Exception e)
		{
			st1=new Object[][] {{""}};
		}
		Object[] st = null;
		try 
		
		{
	 	st=(Object[]) st1[0];
	 	System.out.println("Length of First Data provided by DP"+st.length);
		}
		catch(Exception e)
		{
			st=new Object[][] {{""}};
			System.out.println(e.getMessage());
		}
		try {
		
		    Log.info(st[st.length-2].toString());
		    TestName.set(st[st.length-2].toString());
		    ctx.setAttribute("testName", st[st.length-2].toString());
	      }
	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			TestName.set("Default");
		    ctx.setAttribute("testName", "Default");
		}
		apiDriver ApiDriver=new baseDriver();
		webDriver webDriver=new baseDriver();
		WEB_DRIVER_THREAD_LOCAL.set(webDriver.webinit("chrome", "https://google.com", false));
		API_DRIVER_THREAD_LOCAL.set(ApiDriver.apiinit("https://google.com"));
		API_RESPONCE_THREAD_LOCAL.set(null);
		this.initPage(WEB_DRIVER_THREAD_LOCAL.get());
		this.initPage(API_DRIVER_THREAD_LOCAL.get(),API_RESPONCE_THREAD_LOCAL.get());
	}
	
	@BeforeSuite
	public void BeforeSuite(){
	itr=0;
	DOMConfigurator.configure("log4j.xml");
	}
	@AfterSuite(alwaysRun = true)
	public void AfterSuite() throws IOException{
		System.out.println("In the end");
		String message="<p>Hi All,</p><p>A Test Execution build was triggered and the execution has been completed.</p><p>For the detailed Information’s, please refer the attached html report.</p><p>Thanks,<br/>QA Team</p>";
		 maiUtility ml=new maiUtility();
	     ml.SendEmail(message,"ExtentReports//ExtentReportResults.html");
	}
	
	public static WebDriver getWebDriver(){
		return WEB_DRIVER_THREAD_LOCAL.get();
	}
	public RequestSpecification getApiDriver(){
		return API_DRIVER_THREAD_LOCAL.get();
	}
}