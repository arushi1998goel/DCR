package com.ui.dcr.pages;

import com.framework.selenium.core.BasePage;
import com.framework.selenium.core.Configuration;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;

public class HomePage extends BasePage {
	private String username;
	private String password;
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'NAVIGATE')]")
	private WebElement navigate;

	@FindBy(css = "a[title='Refresh']")
	private  WebElement refreshIcon;

	@FindBy(xpath="//a[contains(text(),'Change Request')]")
	private WebElement changeRequest;
	
	@FindBy(css="mat-dialog-container.mat-dialog-container")
	private WebElement studyAndSiteSelector;
	
	/*@FindBy(css="mat-dialog-container.mat-dialog-container div.list div")
	private List<WebElement> selectStudyPR2AndSiteSelector;*/

	@FindBy(xpath="//div[@title='QC  Sponsor Org 05 - QC Study 05']")
	private WebElement selectStudyPR2AndSiteSelector1;
	@FindBy(xpath="//div[@title='1 - QCSiteTwelve UserL']")
	private WebElement selectStudyPR2AndSiteSelector2;
	
	@FindBy(css = "mat-dialog-container.mat-dialog-container button")
	private WebElement selectButton;

/*	public void verifyHomePage() {
		_waitForJStoLoad();
		Assert.assertTrue(getPageTitle().contains("Your Store"), "Home Page is not visible");
		reportInfo();
	}*/

	public LoginPage navigateToChangeRequest(){

		clickOn(navigate);
		hoverOverElementAndClick(changeRequest, changeRequest);
		return PageFactory.initElements(getDriver(), LoginPage.class);
	}
	public void verifyStudyAndSiteSelector(){
		assertEquals(true, studyAndSiteSelector.isDisplayed());
		String Dialog =studyAndSiteSelector.getText();
		Assert.assertThat(Dialog, StringContains.containsString("Select study & site"));
		Assert.assertThat(Dialog, StringContains.containsString("Study:"));
		Assert.assertThat(Dialog, StringContains.containsString("Site:"));
	}
    public void selectStudyPR2AndSite(){
		//WebElement study = selectStudyPR2AndSiteSelector.get(2);
		WebElement study = selectStudyPR2AndSiteSelector1;
		clickOn(study);
		_waitForJStoLoad();
		//WebElement site = selectStudyPR2AndSiteSelector.get(4);
		WebElement site = selectStudyPR2AndSiteSelector2;
		clickOn(site);
		clickOn(selectButton);
	}

}
