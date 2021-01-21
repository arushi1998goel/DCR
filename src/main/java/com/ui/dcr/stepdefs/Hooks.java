package com.ui.dcr.stepdefs;
import java.util.concurrent.TimeUnit;

import com.ui.dcr.pages.HomePage;
import com.ui.dcr.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import com.framework.enums.DriverType;
import com.framework.selenium.core.Configuration;
import com.framework.utilities.Utilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver Driver;
	protected HomePage homePage;
	protected LoginPage loginPage;
	private String browserType;
	private static WebDriver driver;
	private String applicationUrl;
	static String resultPath;

	
	public void testStart() throws Throwable {
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--start-maximized");

		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\webdriver\\chromedriver.exe");

		Driver = new ChromeDriver(chromeOptions);
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Before()
	public void setUp() throws Exception {
		if (browserType == null) {
			browserType = Configuration.readApplicationFile("Browser");
		}

		applicationUrl = Configuration.readApplicationFile("MappURL");
		if (DriverType.Firefox.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.gecko.driver",
					Utilities.getPath() + "//src//test//resources//webdriver/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		} else if (DriverType.IE.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.ie.driver",
					Utilities.getPath() + "//src//test//resources//webdriver/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("nativeEvents", false);
			driver = new InternetExplorerDriver(capabilities);
		} else if (DriverType.Chrome.toString().toLowerCase().equals(browserType.toLowerCase())) {
			//System.setProperty("webdriver.chrome.driver", ".//src//test//resources//webdriver/chromedriver.exe"); // Utilities.getPath()
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		} else {
			throw new Exception("Please pass a valid browser type value");
		}

		/**
		 * Maximize window
		 */
		driver.manage().window().maximize();

		/**
		 * Delete cookies and set timeout
		 */
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * Open application URL
		 */

		getDriver().navigate().to(applicationUrl);
		

		/**
		 * Initialize the reporting object
		 */
		homePage = PageFactory.initElements(getDriver(), HomePage.class);		 
	}
	
	@After()
	public void endTest() throws Throwable {
		getDriver().close();
		getDriver().quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	
}
