package com.ui.dcr.stepdefs;

import com.ui.dcr.pages.HomePage;
import com.ui.dcr.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageStepDefs {

    public HomePage homePage;
    public LoginPage loginPage ;
    public static WebDriver driver;

    public HomePageStepDefs(){
        driver = Hooks.getDriver();
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.loginPage = new LoginPage(driver);
    }
    @Then("^Go to Navigate and Change Requests\\.$")
    public void go_to_Navigate_and_Change_Requests(){
        homePage.navigateToChangeRequest();
    }

    @Then("^verify Study and Site selector shows\\.$")
    public void verify_Study_and_Site_selector_shows(){
        homePage.verifyStudyAndSiteSelector();
    }

    @Given("^select the Study and Site\\.$")
    public void select_the_Study_and_Site(){
        homePage.selectStudyPR2AndSite();
    }
}
