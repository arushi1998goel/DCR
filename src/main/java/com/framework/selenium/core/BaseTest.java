/*
  Class to initialize all application page objects and manage WebDriver browser
  object. Each and every test script class must extend this. This class does
  not use any of the Selenium APIs directly, and adds support to make this
  framework tool independent.

  @author 360Logica
 * @since 1.0
 *
 * @version 1.0
 */
package com.framework.selenium.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.ui.dcr.pages.HomePage;
import com.ui.dcr.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.framework.enums.DriverType;
import com.framework.report.ReportTestManager;
import com.framework.utilities.BaseAPI;
import com.framework.utilities.Utilities;
/*import com.opencart_demo.pages.CheckOutPage;
import com.opencart_demo.pages.HomePage;
import com.opencart_demo.pages.LoginPage;
import com.opencart_demo.pages.ProductDisplayPage;
import com.opencart_demo.pages.ProductListingPage;*/
import com.test.jira.ZephyrUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.sridharbandi.AccessibilityRunner;
import io.github.sridharbandi.util.Standard;

public abstract class BaseTest extends BaseAPI{

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static AccessibilityRunner accessibilityRunner;

	// pages object initialization
/*	protected ProductListingPage productListingPage;
	protected ProductDisplayPage productDisplayPage;
	protected HomePage homePage;
	protected CheckOutPage checkOutPage;
	protected LoginPage loginPage;*/
	protected HomePage homePage;
	protected LoginPage loginPage;

	private String browserType;
	private static WebDriver driver;
	private String applicationUrl;
	static String screenshotFolder =  "/screenshot";
	protected String email;
	static String reportSwitch = "";
	static String isSreenShotEveryStep;

	@BeforeSuite
	public void before() throws Exception {
		// Create Result repository for report.
		// String timeStamp = getFormattedTimeStamp().replace("-", "").replace(":",
		// "").replace(".", "");	
		reportSwitch = Configuration.readApplicationFile("reportSwitch");
		isSreenShotEveryStep = Configuration.readApplicationFile("screenShotEveryStep");

	}

	@BeforeClass
	public void setUp() throws Exception {

		browserType = Configuration.readApplicationFile("Browser");
		System.out.println(browserType);
		applicationUrl = Configuration.readApplicationFile("stgURL");
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
			ChromeDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		} else {
			throw new Exception("Please pass a valid browser type value");
		}

		accessibilityRunner = new AccessibilityRunner(getWebDriver());
		String accStand = browserType = Configuration.readApplicationFile("AccessibilityStandard");
		this.setAccessibilityStandard(accStand);
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		driver = eventDriver;

		// Maximize window/
		driver.manage().window().maximize();
		// Delete cookies and set timeout/
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open application URL
		getWebDriver().navigate().to(applicationUrl);
		// Initialize the reporting object
		// setReportTest(method);
		// this.initializeHelpers();
		homePage = PageFactory.initElements(getWebDriver(), HomePage.class);

		email = Configuration.readApplicationFile("emailId");
	}

	@AfterMethod
	public void afterMainMethod(ITestResult result) throws IOException, InterruptedException {
		if (reportSwitch.equals("1") || reportSwitch.equals("2")) {
			if (result.getStatus() == ITestResult.FAILURE) {
				try {
					// captureScreenshot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void setReportTest(Method method) {
		System.setProperty("testcaseName", method.getName().toString());

	}
	
	protected static String screenshotFolder(){
		String path = Utilities.getPath() + screenshotFolder;
		File file = new File(path);
		if(! file.isDirectory()) {
			new File(path).mkdirs();
		}
		return path;
	}
	
	public void initializeHelpers() {
		homePage = new HomePage(getWebDriver());
/*		productListingPage = new ProductListingPage(getWebDriver());
		checkOutPage = new CheckOutPage(getWebDriver());
		productDisplayPage = new ProductDisplayPage(getWebDriver());*/
		loginPage = new LoginPage(getWebDriver());

	}

	@AfterSuite
	public void tearDownSuite1() throws IOException {
		accessibilityRunner.generateHtmlReport();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * Handle child windows
	 *
	 * @return: Parent window name
	 */
	public String switchPreviewWindow() {
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		getWebDriver().switchTo().window(iterator.next());
		return parent;
	}

	/**
	 * Get absolute path
	 *
	 * @return: Absolute path
	 */
	public String getPathUpload() {
		String path;
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");
		return path;
	}

	/**
	 * Capturing screenshot once script is failed
	 * 
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws BadElementException
	 */
	public static void captureScreenshot() throws MalformedURLException, IOException {		
		String screen = "";
		try {
	
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

					
			screen = screenshotFolder() + "/" + "Failed_.png";
			File screenshotLocation = new File(screen);
			FileUtils.copyFile(screenshot, screenshotLocation);
			Thread.sleep(1500);
			InputStream is = new FileInputStream(screenshotLocation);
			byte[] imageBytes = IOUtils.toByteArray(is);
			Thread.sleep(2000);
			Reporter.log(
					"<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>FailedTest</a>");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	/**
	 * Capturing screenshot after every step.
	 * 
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws BadElementException
	 */
	public static void captureScreenshots(String screenshotName) throws MalformedURLException, IOException {
		String screen = "";
		try {			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screen = screenshotFolder() + "/" + screenshotName + ".png";
			File screenshotLocation = new File(screen);
			FileUtils.copyFile(screenshot, screenshotLocation);				
			Reporter.log(
					"<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName + "</a>");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	static String message = "";

	public static String getMessage() {
		return message;
	}

	public void reportLog(String msg) {
		if(ReportTestManager.getTest() != null ){
			ReportTestManager.getTest().log(Status.PASS, msg);
		}
		logger.info(msg);
		Reporter.log(msg);
	}

	/**
	 * function : Fetch the System's current date with time
	 * 
	 */
	public String getTimeStamp() {
		Date date = new Date();
		return new Timestamp(date.getTime()).toString().replace(" ", "");
	}

	/**
	 * @return
	 * @function: Get formatted Time stamp
	 * 
	 */
	public String getFormattedTimeStamp() {

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu HH:mm:ss");
		String formatDateTime = currentTime.format(formatter);
		return formatDateTime;

	}

	/**
	 * Function: Get current date.
	 * 
	 * @return
	 */
	public String currentDate() {
		final DateFormat format = new SimpleDateFormat("dd-MMM-YYYY");
		Date date = new Date();
		final String currentDate = format.format(date);
		return currentDate;
	}

	/**
	 * Function: Get random string
	 * 
	 * @param lettersNum
	 * @return
	 */
	public static String generateRandomString(int lettersNum) {
		StringBuilder finalString = new StringBuilder();

		int numberOfLetters = 25;
		long randomNumber;
		for (int i = 0; i < lettersNum; i++) {
			char letter = 97;
			randomNumber = Math.round(Math.random() * numberOfLetters);
			letter += randomNumber;
			finalString.append(String.valueOf(letter));
		}
		return finalString.toString();
	}

	/**
	 * Functin: Get random integer
	 * 
	 * @param aStart
	 * @param aEnd
	 * @return
	 */

	public int getRandomInteger(final long aStart, final long aEnd) {
		final Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		final long range = aEnd - aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		final long fraction = (long) (range * aRandom.nextDouble());
		final int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	/**
	 * Compressing Reports folder in a compressed Zip file for archiving reports
	 * 
	 */

	public void zipDir(String dirName, String nameZipFile) throws IOException {
		ZipOutputStream zip = null;
		FileOutputStream fW = null;
		fW = new FileOutputStream(nameZipFile);
		zip = new ZipOutputStream(fW);
		addFolderToZip("", dirName, zip);
		zip.close();
		fW.close();
	}

	public void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws IOException {
		File folder = new File(srcFolder);
		if (folder.list().length == 0) {
			addFileToZip(path, srcFolder, zip, true);
		} else {
			for (String fileName : folder.list()) {
				if (path.equals("")) {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
				} else {
					addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip, false);
				}
			}
		}
	}

	public void addFileToZip(String path, String srcFile, ZipOutputStream zip, boolean flag) throws IOException {
		File folder = new File(srcFile);
		if (flag) {
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName() + "/"));
		} else {
			if (folder.isDirectory()) {
				addFolderToZip(path, srcFile, zip);
			} else {
				byte[] buf = new byte[1024];
				int len;
				FileInputStream in = new FileInputStream(srcFile);
				zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
				while ((len = in.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
			}
		}
	}

	public void setAccessibilityStandard(String standard) throws Exception {
		switch (standard) {
		case "WCAG2AAA":
			accessibilityRunner.setStandard(Standard.WCAG2AAA);
			break;
		case "WCAG2AA":
			accessibilityRunner.setStandard(Standard.WCAG2AA);
			break;
		case "WCAG2A":
			accessibilityRunner.setStandard(Standard.WCAG2A);
			break;
		case "Section508":
			accessibilityRunner.setStandard(Standard.Section508);
			break;
		default:
			throw new Exception("Please provide correct accessability standard");

		}
	}
	
	public void attachScreenShot(String testCaseId, String screenshotName){
		ZephyrUtils cc = new ZephyrUtils();
		try {
			captureScreenshots(screenshotName);
			String path = screenshotFolder() + "/"+screenshotName+ ".png";
			cc.attachement(testCaseId, path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
