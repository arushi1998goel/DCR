package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

import java.util.logging.Level;

import org.apache.http.params.CoreConnectionPNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class baseDriver implements apiDriver, webDriver
{

	public WebDriver webinit(String browser, String BaseURL, Boolean Grid) throws Exception {
		WebDriver dr = null;
		System.out.println("In Web Initiator");
		if(!Grid==true) {
		if(browser.equalsIgnoreCase("chrome"))
		{ 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("profile.default_content_setting_values.popups", 1);
			prefs.put("download.default_directory", System.getProperty("user.dir")+"/src/Data/Downloads");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-popup-blocking");
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			LoggingPreferences logs = new LoggingPreferences(); 
		    logs.enable(LogType.DRIVER, Level.ALL); 
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
			dr= new ChromeDriver(capabilities);
			
			dr.manage().deleteAllCookies();
			dr.get(BaseURL);
		}
		else if (browser.equals("ie"))
		{
			System.out.println("For IE Browser");
		}
		
		else
		{
			System.out.println("For FF Browser");
		}

		}
		
	  return dr;
	}

	public RequestSpecification apiinit(String baseurl) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest;
//		System.out.println("In API Initiator");
		RestAssured.baseURI = baseurl;
		@SuppressWarnings("deprecation")
		RestAssuredConfig config = RestAssured.config()
		        .httpClient(HttpClientConfig.httpClientConfig()
		                .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 100000)
		                .setParam(CoreConnectionPNames.SO_TIMEOUT, 100000));
		//System.out.println(RestAssured.baseURI);
		httpRequest = RestAssured.given().config(config);
		return httpRequest;
	}

}