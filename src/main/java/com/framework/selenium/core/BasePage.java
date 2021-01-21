/*
  Class to initialize all page methods for the actions available
  under that page. All scripts must call the respective methods from the respective
  pages to achieve any action.

  @author 360Logica
 * @since 1.0
 *
 * @version 1.0
 */
package com.framework.selenium.core;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.framework.utilities.DateCalendar;
import com.framework.utilities.Utilities;
import com.google.common.base.Function;

public abstract class BasePage{

	protected static final int DEFAULT_WAIT_4_ELEMENT = 30;
	protected static final int DEFAULT_WAIT_4_PAGE = 30;
	protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected static WebDriverWait ajaxWait;
	protected WebDriver driver;
	protected String title;
	protected long timeout = 30;
	static String resultPath;
	public static BaseTest baseTest;
	protected DateCalendar dateCalendarRef = new DateCalendar();
	protected String locator;

	/** @Inject @Named("framework.implicitTimeout") protected long timeout; */

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

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

	/** Click action performed and then wait */

	public void waitAndClick(WebElement element) {
		waitForWebElementEnable(element, 10);
		waitForElement(element);
		javascripctHilightingElement(element);
		reportInfo();
		unhighLightElement();
		element.click();

	}

	/**
	 * Move to Particular Element
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions actn = new Actions(driver);
		actn.moveToElement(element).build().perform();
		javascripctHilightingElement(element);
		reportInfo();
	}

	public void clickOn(WebElement element) {
		waitForElement(element);
		javascripctHilightingElement(element);
		reportInfo();
		unhighLightElement();
		element.click();
	}

	public void reportInfo() {		
	}

	/**
	 * Function: Highlight the WebElement and capture screenshot of the event
	 * 
	 * @param WebElement
	 * 
	 */

	public void javascripctHilightingElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 3px solid red;')", webElement);
		lastElem = webElement;
	}

	/**
	 * Function: UnHighlight the WebElement and capture screenshot of the event
	 * 
	 * @param WebElement
	 * 
	 */
	private WebElement lastElem = null;

	public void unhighLightElement() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 0px;');", lastElem);

	}

	/** Click on WebElement by using java script */
	public void javascriptButtonClick(WebElement webElement) {
		waitForElement(webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	/** Click on element by string locator */
	public void waitAndClick(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}

	/** Click on element by string locator */
	public void clickOn(String locator) {
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}

	public String returnTitle() {
		return title;
	}

	/** Scroll page down 250 pixel */
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
	}

	/**
	 * Scroll page down pixel
	 *
	 * @param pixel
	 *            pixel to scroll down
	 */
	public void scrollDown(String pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	public void scrollToDocumentHeight() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToTopOfThePage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0 )");
	}

	/** Scroll page up 250 pixel */
	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(250, 0)", "");
	}

	/**
	 * Scroll page up pixel
	 *
	 * @param pixel
	 *            pixel to scroll down
	 */
	public void scrollUp(String pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + pixel + ", 0)", "");
	}

	/** Setting up implicit wait that will be used internally */
	private void setImplicitWait(int timeInSec) {
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}

	/** Reset implicit wait */
	private void resetImplicitWait() {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	/** Wait for element */
	public void waitFor(ExpectedCondition<Boolean> expectedCondition) {
		setImplicitWait(0);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(expectedCondition);
		resetImplicitWait();
	}

	/** Input text as string */
	public void inputText(WebElement element, String text) {
		waitForWebElementEnable(element, 10);
		element.clear();
		waitForElement(element);
		element.sendKeys(text);
	}
	
	/** Input text as string */
	public void inputText(String locator, String text) {
		WebElement el = getWhenVisible(locator, 10);
		el.clear();
		waitForElement(el);
		el.sendKeys(text);
	}

	/** Wait for element to be present */
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/** Wait for element by passing argument as string. */
	public void waitForElementToVisible(String locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
	}

	/** normal wait for thread. */
	public void _normalWait(long timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Wait for JSLoad to load */
	public boolean _waitForJStoLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> {
			try {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
			} catch (Exception e) {
				return true;
			}
		};

		/** wait for JavaScript to load */
		ExpectedCondition<Boolean> jsLoad = driver -> {
			Object rsltJs = ((JavascriptExecutor) driver).executeScript("return document.readyState");
			if (rsltJs == null) {
				rsltJs = "";
			}
			return rsltJs.toString().equals("complete") || rsltJs.toString().equals("loaded");
		};

		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	/** Handle locator type */
	public By ByLocator(String locator) {
		By result;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.className(locator);
		}
		return result;
	}

	/** Verify the URL */
	public boolean verifyURL(String url) {
		boolean value = false;
		String currentUrl = driver.getCurrentUrl();
		return currentUrl.contains(url) || value;
	}

	/** Return driver instance */
	public WebDriver getDriver() {
		return driver;
	}

	/** Find webelement */
	public WebElement findElement(By by) {
		WebElement foundElement;

		if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int millis = 0; millis < 3000; millis = millis + 200) {
			try {
				foundElement = driver.findElement(by);
				return foundElement;
			} catch (Exception e) {
				// Utils.hardWaitMilliSeconds(200);
			}
		}
		return null;
	}

	/** Use assert by page title */
	public void assertByPageTitle() {
		try {
			if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver
					|| driver instanceof FirefoxDriver) {
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Assert.assertTrue(returnTitle().equals(driver.getTitle()));
	}
	
	public String getPageTitle() {
		
		return title = this.getDriver().getTitle();
		
	}

	/** Find all links on current page */
	public List<String> findAllLinksOnPage() {
		List<String> links = new ArrayList<>();
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		for (WebElement each : linkElements) {
			String link = each.getAttribute("href");
			if (link == null || link.contains("mailto") || link.contains("javascript")) {
				continue;
			}
			links.add(link);
		}
		return links;
	}
	
	public void clickOnListElements(String locator) {
		List<WebElement> buttons = getDriver().findElements(ByLocator(locator));
		for (int i = 0; i < buttons.size(); i++) {
			buttons = getDriver().findElements(ByLocator(locator));
			if (isElementDisplayed(buttons.get(0))) {
				clickOn(buttons.get(0));
				_waitForJStoLoad();
			}
		}

	}

	public void clickOnListElements(List<WebElement> elements) {

		for (WebElement el : elements) {
			elements.get(0).click();}
	}
	
	/** Check the response of link */
	public boolean isResponseForLinkTwoHundredOrThreeOTwo(String link) {
		int code;
		Reporter.log("Link: " + link);
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			code = connection.getResponseCode();
			Reporter.log("Code: " + code);
		} catch (Exception e) {
			Reporter.log(e.toString());
			return false;
		}
		return link.contains("pager") || code == 403 || code == 200 || code == 302;
	}

	/** Set wait for driver */
	public void setWaitTime(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void setWaitTimeToZero(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	/** Condition to customize */
	public void customizableCondition(WebDriver driver, int waitTime, final Boolean condition) {
		// setWaitTimeToZero(driver);
		new WebDriverWait(driver, waitTime).until((ExpectedCondition<Boolean>) driver1 -> condition);
		// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
	}

	/** Wait for element to be clickable */

	public WebElement waitForElementClickable(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** Wait for element to be present */
	public WebElement waitForElementPresent(final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** Wait for element to be present by web element */
	public WebElement waitForElementPresent(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(webElement));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param webElement
	 * @param text
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForTextPresentInElement(WebElement webElement, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));

		return notVisible;
	}

	public boolean waitForTextPresentInElement(By by, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));

		return notVisible;
	}

	/** Verify that element is present */
	public Boolean isElementDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception ex) {
		}
		return false;
	}

	/** Verify that element is not Visible */

	public Boolean isElementNotVisible(WebElement element) {
		Boolean result = false;
		try {
			if (!(element.isDisplayed()))
				;
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Verify that element is present on web page */
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	/**
	 * Verify
	 * 
	 * 
	 * 
	 * /**
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public boolean WaitForElementNotPresent(WebElement locator) {
		boolean flag = false;
		int timeOut = 10;
		for (int i = 0; i < timeOut; i++) {
			if (!isElementDisplayed(locator)) {
				flag = true;
				break;

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * @param locator
	 * @param timeout
	 */
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param container
	 * @param element
	 * @return
	 */
	public int findNumberOfSpecificElementsInContainer(By container, By element) {
		WebElement mainDiv = driver.findElement(container);
		List<WebElement> divs = mainDiv.findElements(element);
		return divs.size();
	}

	/**
	 * @param toBeHovered
	 * @param toBeClicked
	 * @return
	 */
	public WebDriver hoverOverElementAndClick(WebElement toBeHovered, WebElement toBeClicked) {
		Actions builder = new Actions(driver);
		builder.moveToElement(toBeHovered).build().perform();
		waitForElementPresent(toBeClicked, DEFAULT_WAIT_4_ELEMENT);
		toBeClicked.click();
		waitForPageLoaded();
		return driver;
	}

	/**
	 * Select element by visible text
	 *
	 * @param targetValue:
	 *            visible text
	 */
	public void selectDropDownByText(WebElement element, String targetValue) {
		waitForElement(element);
		new Select(element).selectByVisibleText(targetValue);
	}

	/** Select element by Index */
	public void selectDropDownByIndex(WebElement element, int index) {
		waitForElement(element);
		new Select(element).selectByIndex(index);
	}

	/**
	 * Select element by value
	 *
	 * @param targetValue:
	 *            value
	 */
	public void selectDropDownByValue(WebElement element, String targetValue) {
		// waitForElement(element);
		new Select(element).selectByValue(targetValue);
	}

	/**
	 * @param by
	 * @param driver
	 */
	public void waitForElementToBecomeVisible(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * @param by
	 */
	public void waitForElementToBecomeInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 *
	 */
	public void waitForAjaxRequestsToComplete() {
		(new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE)).until((ExpectedCondition<Boolean>) d -> {
			JavascriptExecutor js = (JavascriptExecutor) d;
			return (Boolean) js.executeScript("return jQuery.active == 0");
		});
	}

	/**
	 * @param driver
	 */
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete");
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		wait.until(expectation);
	}

	/**
	 * @param by
	 * @return
	 */
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** Verify that text is present on the page. */
	public boolean isTextPresentOnPage(String text) {
		return driver.findElement(By.tagName("body")).getText().contains(text);
	}

	/**
	 * Verify selected element is mandatory
	 * 
	 * @param element
	 */
	public void verifyInputIsMandatory(WebElement element) {

		Assert.assertEquals(element.getCssValue("color"), "#cc472c");

		Assert.assertEquals(element.getCssValue("background-color"), "rgba(255, 217, 217, 1)");

	}

	/**
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public boolean isFileAvailableForDownload(WebElement webElement) throws Exception {
		int code;
		String downloadUrl = webElement.getAttribute("href");
		URL url = new URL(downloadUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		code = connection.getResponseCode();
		Reporter.log("The response code for download is " + code);
		return code == 200;
	}

	/** Store text from a locator */
	public String getText(WebElement element) {
		waitForElementPresent(element, DEFAULT_WAIT_4_ELEMENT);
		Assert.assertTrue(isElementDisplayed(element), "Element Locator :" + element + " Not found");
		return element.getText();
	}

	public void takeRemoteWebDriverScreenShot(String fileName) {
		File screenshot = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(fileName));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void waitForTextNotToBeVisible(String text, int timeoutInSeconds) {
		int startWait = 0;
		while (isTextPresentOnPage(text)) {
			// Utils.hardWaitSeconds(1);
			startWait++;
			if (startWait == timeoutInSeconds) {
				throw new TimeoutException();
			}
		}
	}

	/**
	 * @param element
	 */
	public void waitForWebElementPresent(WebElement element) {
		WebDriverWait ajaxWait = new WebDriverWait(driver, 30);
		ajaxWait.until(ExpectedConditions.visibilityOf(element));
	}

	/** Perform Drag and drop */
	public void dragAndDrop(WebElement drag, WebElement drop) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
		dragAndDrop.perform();
	}

	/** Switch to next tab */
	public void switchToTab() {
		// Switching between tabs using CTRL + tab keys.
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
		// Switch to current selected tab's content.
		driver.switchTo().defaultContent();
	}

	public void scrollPageThroughWebElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void scrollIntoView(String locator) {
		scrollIntoView(By.xpath(locator));
	}

	public void scrollIntoView(By by) {
		WebElement elem = getDriver().findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", new Object[] { elem });
	}

	/**
	 * To load all the records by scrolling down the page
	 * 
	 * @param WebElement
	 */
	public void loadCompleteList(WebElement totalPages) {
		_normalWait(3000);
		if (totalPages.isDisplayed()) {
			String[] totalPagesCount = totalPages.getText().split("\\ /");
			int intialPagePos = 1;
			while (intialPagePos <= Integer.valueOf(totalPagesCount[1].replaceAll(" ", ""))) {
				scrollToDocumentHeight();
				_normalWait(3000);
				intialPagePos++;
			}
		}
	}

	/** Capturing screenshot once script is failed */
	public void captureScreenshotOfPages(String result) {
		try {
			String screenshotName = Utilities.getFileName(result);
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = Utilities.getPath();
			String screen = path + "/test-output/screenshots/" + screenshotName + ".png";
			File screenshotLocation = new File(screen);
			FileUtils.copyFile(screenshot, screenshotLocation);
			Thread.sleep(2000);
			Reporter.log(
					"<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName + "</a>");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * Funtion: Select option from dropdown
	 * 
	 * @param options
	 * @param givenOption
	 */
	public void selectDropdownOption(List<WebElement> options, String givenOption) {
		for (WebElement e : options) {
			if (e.getText().equals(givenOption)) {
				waitAndClick(e);
				break;
			}
		}
	}

	/**
	 * Funtion: Select accept alert.
	 * 
	 * @param time
	 */
	public void selectAlertPresent(final int time) {

		for (int i = 0; i < time; i++) {
			if (isAlertPresent()) {

				final Alert alert = driver.switchTo().alert();

				alert.accept();

				break;
			}
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Funtion: Verify presence of alert popup
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			logger.debug("Check if alert present");
			return true;
		} catch (final NoAlertPresentException e) {
			return false;
		}
	}

	public String currentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	public WebElement waitForWebElementEnable(WebElement webElement, int timeOutInSeconds) {
		try {
			new FluentWait<WebElement>(webElement).withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
					.pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
					.ignoring(ElementNotVisibleException.class).ignoring(ElementNotInteractableException.class)
					//.ignoring(TimeoutException.class).ignoring(ElementNotFoundException.class)
					.until(new Function<WebElement, Boolean>() {
						@Override
						public Boolean apply(WebElement element) {
							return element.isDisplayed();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void waitForSpinner(int timeout) {
		waitForAjaxRequestsToComplete();
		String locator = "//div[@class='ng-isolate-scope ng-hide']";
		WebElement element = driver.findElement(By.xpath(locator));
		waitForWebElementEnable(element, timeout);
	}

	/** Select CheckBox From The List */
	public void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {
		List<WebElement> element = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < element.size(); i++) {
			List<WebElement> dr = element.get(i).findElements(By.tagName("input"));
			for (WebElement value : dr) {
				if (valueToSelect.equals(value.getText())) {
					value.click();
					break;
				}
			}
		}
	}

	/** CheckBox Checking **/
	public boolean checkboxStatus(WebElement checkbox) {
		boolean checkstatus = false;
		try {
			if (checkbox.isSelected())
				checkstatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkstatus;
	}

	/** Navigate to previous page **/

	public void navigateBack() {
		driver.navigate().back();
	}

	/** Navigate to forward **/
	public void navigateForward() {
		driver.navigate().forward();
	}

	public void waitSpinnerToBecomeInvisible() {
		waitForAjaxRequestsToComplete();
		waitForElementToBecomeInvisible(By.xpath("//div[@class='spinner']"));
	}

	public void spinnerBecomeInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ng-isolate-scope']")));
	}

	public void waitSpinnerToBecomeVisible() {
		waitForAjaxRequestsToComplete();
		waitForElementToBecomeVisible(By.xpath("//div[@class='spinner']"), driver);
	}

	public void waitForElement() throws InterruptedException {
		Thread.sleep(2000);
	}

	/**
	 * To Get The ToolTip Text
	 * 
	 * @param WebElement
	 */
	public String getToolTip(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		String tootipMsg = element.getAttribute("title");
		return tootipMsg;
	}

	public void doubleClickOnElement(WebElement element) {
		Actions actions = new Actions(driver).doubleClick(element);
		actions.build().perform();
	}

	public void switchToFrame(WebElement element) {

		driver.switchTo().frame(element);

	}

	/**
	 * Mousehover on any element
	 */

	public void mouseHoverOnAnElement(WebElement webElement) {

		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).build().perform();

	}

	/**
	 * Return the FIRST element to become visible from the element list..
	 * @param elements
	 * @return
	 */
	public WebElement getFirstVisible(List <WebElement> elements) {
		for (WebElement element : elements) {
			if (isElementDisplayed(element)) {
				return element;
			}
		}
		System.out.println("No visible elements found..");
		return null;
		
	}
	
	/**
	 * Wait for an element to be visible and then return the element. Timeout
	 * defaults to 10 seconds..
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement getWhenVisible(String locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		return element;
	}

	/**
	 * Assert if an element is displayed on the page
	 * @param element
	 * @param text
	 */
	public void assertElementIsVisibile(WebElement element, String text) {
		Boolean isVisible = this.isElementDisplayed(element);
		Assert.assertTrue(isVisible, "Expected that '" + text + "' should visible");
	}
	
	/**
	 * Assert if an element is not displayed on the page
	 * @param element
	 * @param text
	 */
	public void assertElemenentIsNotVisibile(WebElement element, String text) {
		Boolean isVisible = this.isElementDisplayed(element);
		Assert.assertFalse(isVisible, "Expected that '" + text + "' should visible");
	}

	/**
	 * Returns true if the element is present. Set the timeout to zero if you
	 * don't want to wait for the element to become present.
	 * 
	 * @param locator
	 *            - String
	 * @param timeOut
	 *            - Integer
	 * @return
	 */
	public boolean isElementPresent(String locator, Integer timeOut) {
		getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return getDriver().findElements(ByLocator(locator)).size() != 0;
	}
	
	public void assertElemenentIsVisibile(String locator, String text) {
		Boolean isVisible = this.isElementPresent(locator);
		Assert.assertTrue(isVisible, "Expected that '" + text + "' should visible");
	}

}

