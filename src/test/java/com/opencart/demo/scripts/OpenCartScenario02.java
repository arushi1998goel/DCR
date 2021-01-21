/*
package com.opencart.demo.scripts;

import org.testng.annotations.Test;

import com.framework.selenium.core.BaseTest;
import com.opencart_demo.pages.CheckOutPage;
import com.opencart_demo.pages.ProductDisplayPage;
import com.opencart_demo.pages.ProductListingPage;
import com.test.jira.JiraTestCase;

public class OpenCartScenario02 extends BaseTest{
		
	@JiraTestCase(testCaseId = { "10025" })
	@Test
	public void verifySearchAndCheckoutWithGuestUser(){
		String productName = "MacBook Air";
		reportLog("Launch Saksoft Portal and verify portal launch successfully");		
		homePage.verifyHomePage();
		
		reportLog("Reset if the already selected items are in cart");
		homePage.resetOrder();
		
		reportLog("search and select a product from the list");
		ProductListingPage productListingPage = homePage.searchProduct(productName);
		
		reportLog("Verify the Product listing page is displaying the product on title");
		productListingPage.verifyProductListingPageTitle("Search - "+productName+"");
		
		reportLog("search the filterd item and go to the Product Display Page");
		ProductDisplayPage productDisplayPage = productListingPage.selectFirstProduct(productName);
		
		reportLog("Verify the contents available in the Product display page for the selected item");
		String procustAmount = productDisplayPage.verifyProductDisplayContents();
		
		reportLog("Clicks on Add to Cart button");
		productDisplayPage.clickOnAddToCart();
		
		reportLog("Veify notification message after adding an item into cart");
		productDisplayPage.verifyProductAddedNotification();
		
		reportLog("Veify Cart item numbers");
		productDisplayPage.verifyCartItems();
		
		reportLog("Clicks on Item button to check its details before checkout");
		productDisplayPage.clickOnItems();
		
		reportLog("Verify bucket pop up contents related to item details");
		productDisplayPage.verifyPopUpContents(productName, procustAmount);
		
		reportLog("Clicks on CheckOut button to chhck into payment page");
		CheckOutPage checkOutPage = productDisplayPage.clickOnCheckOut();
		
		reportLog("Select Guest User check box");
		checkOutPage.selectGuestUserCheckOut();
		
		reportLog("Input Guest User's personal details");
		checkOutPage.inputGuestUserDetail("firstname", "Guest", false);
		checkOutPage.inputGuestUserDetail("lastname", "User", false);
		checkOutPage.inputGuestUserDetail("email", "guest.user@gmail.com", true);
		checkOutPage.inputGuestUserDetail("telephone", "0987654321", false);
		checkOutPage.inputGuestUserDetail("address-1", "123", false);
		checkOutPage.inputGuestUserDetail("city", "Delhi", true);
		checkOutPage.inputGuestUserDetail("postcode", "100101", true);
		checkOutPage.selectPaymentCountry();
		checkOutPage.selectPaymentZone();
		
		reportLog("Click On Continue Button");
		checkOutPage.clickOnContinue("Payment Address");
		
		reportLog("Verify shipping method is checked");
		checkOutPage.verifyRadioButtonSelected("Shipping Method");
		
		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Shipping Method");
		
		reportLog("Click On Terms and Conditions");
		checkOutPage.clickOnTC();
		
		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Payment Method");
		
		reportLog("Verify the order details on Confirm Section");
		checkOutPage.verifyConfirmOrder(productName);
		
		reportLog("Go to Home Page after confirming Order details");
		checkOutPage.goToHomePage(true);
		
	}

}
*/
