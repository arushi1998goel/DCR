package com.ui.dcr.pages;

import com.framework.selenium.core.BasePage;
import com.framework.selenium.core.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private String username;
    private String password;

   // public LoginPage(WebDriver driver) {super(driver);}
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='WebLogin_UserName']")
    WebElement userNameTextbox;

    @FindBy(xpath="//input[@id='Password']")
    WebElement passwordTextbox;

    @FindBy(xpath="//input[@id='WebLogin_Login']")
    WebElement signInButton;

/*    public void verifyLoginPage(){
        _waitForJStoLoad();
        assertElementIsVisibile(signInButton, "Sign in");
        reportInfo();
    }*/

    public LoginPage userLogin() throws Exception {
        username= Configuration.readApplicationFile("Username");
        password = Configuration.readApplicationFile("Password");
        inputText(userNameTextbox, username);
        inputText(passwordTextbox, password);
        clickOn(signInButton);
        _waitForJStoLoad();
        return PageFactory.initElements(getDriver(),LoginPage.class);
    }
}
