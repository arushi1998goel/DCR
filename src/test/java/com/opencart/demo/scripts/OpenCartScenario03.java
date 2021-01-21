/*
package com.opencart.demo.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.selenium.core.BaseTest;
import com.framework.utilities.MySqlUtils;
import com.opencart_demo.pages.LoginPage;
import com.opencart_demo.pages.ProductDisplayPage;
import com.opencart_demo.pages.ProductListingPage;
import com.test.jira.JiraTestCase;

public class OpenCartScenario03 extends BaseTest{

	@JiraTestCase(testCaseId = { "10079" })
	@Test
	public void addProductToWishList() throws Exception{
		String productName = "MacBook Air";
		reportLog("Launch Saksoft Portal and verify portal launch successfully");		
		homePage.verifyHomePage();
		
		reportLog("Select login user from the Login Menu option");
		LoginPage loginPage = homePage.goToLoginPage();
		
		reportLog("Verify if the login page is displayed");
		loginPage.verifyLoginPage();
		
		reportLog("Input user credentials to login");
		loginPage.loginUser();
		
		reportLog("Verify if the user is logged in or not");
		homePage.verifyLoggedIn();
		
		reportLog("Reset Wish List Items");
		homePage.resetWishList();
		
		MySqlUtils sql = new MySqlUtils();
		reportLog("Verify product "+productName+" removed from whishlist for user "+email);		
		boolean status = sql.getStatusProductAddedWishListForUser(email, productName);
		Assert.assertFalse(status, "Product "+productName + " still added in whishlist for user "+email);
		
		reportLog("search and select a product from the list");
		ProductListingPage productListingPage = homePage.searchProduct(productName);
		
		reportLog("Verify the Product listing page is displaying the product on title");
		productListingPage.verifyProductListingPageTitle("Search - "+productName+"");
		
		reportLog("search the filterd item and go to the Product Display Page");
		ProductDisplayPage productDisplayPage = productListingPage.selectFirstProduct(productName);
		
		reportLog("Verify the contents available in the Product display page for the selected item");
		productDisplayPage.verifyProductDisplayContents();
		
		reportLog("Add items into Wish List");
		productDisplayPage.clickOnAddToWishList();
		
		reportLog("Verify Wish List Items");
		homePage.verifyWishListTotalItems();
		
		reportLog("Verify product "+productName+" added in whishlist for user "+email);		
		status = sql.getStatusProductAddedWishListForUser(email, productName);
		Assert.assertTrue(status, "Product "+productName + " not added in whishlist for user "+email);
				
		reportLog("Choose Menu option by giving Manu Name");
		homePage.clickOnMenuOption("Wish List");
		
		reportLog("Verify Wish List Item details");
		homePage.verifyWishListItemDetails();
		
		reportLog("Verify Account Page after deleting orders");
		homePage.verifyMyAccountPage();
		
	}

}
*/
