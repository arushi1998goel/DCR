package com.ui.dcr.stepdefs;
import com.ui.dcr.pages.HomePage;
import com.ui.dcr.pages.LoginPage;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageStepDefs {
    public HomePage homePage;
    public LoginPage loginPage ;
    public static WebDriver driver;
    public int requestId;

    public LoginPageStepDefs(){
        driver = Hooks.getDriver();
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.loginPage = new LoginPage(driver);
    }

    @Given("^Log in to the Virgil MA-PP portal with PR(\\d+) user\\.$")
    public void log_in_to_the_Virgil_MA_PP_portal_with_PR_user(int arg1) throws Throwable {
        loginPage.userLogin();
    }

    }
