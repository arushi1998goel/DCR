/*
package com.opencart.demo.scripts;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.selenium.core.BaseTest;
import com.framework.utilities.HttpStatusCode;
import com.framework.utilities.JsonFileUtil;
import com.framework.utilities.MethodType;
import com.framework.utilities.MySqlUtils;
*/
/*import com.opencart_demo.pages.CheckOutPage;
import com.opencart_demo.pages.LoginPage;
import com.opencart_demo.pages.ProductDisplayPage;
import com.opencart_demo.pages.ProductListingPage;*//*

import com.sample.apiconstant.GlobalConstant;
import com.sample.apiconstant.GlobalConstant.FileName;
import com.test.jira.JiraTestCase;

import io.restassured.response.Response;


public class OpenCartScenario01 extends BaseTest {
	
	*/
/**
	 * This Test case will login with already registered user, will add items
	 * into cart and will verify till Checkout
	 * 
	 * @throws Exception
	 *//*

	@Test
	@JiraTestCase(testCaseId = { "10060" })
	public void verifySearchAndCheckoutWithRegisteredUser() throws Exception {
		
		String productName = "MacBook Air";
		reportLog("Launch OpenCart Portal and verify Home Page");
		homePage.verifyHomePage();
		attachScreenShot("10060", "HomePage");
		
		reportLog("Select login user from the Login Menu option");
		LoginPage loginPage = homePage.goToLoginPage();
		attachScreenShot("10060", "LoginPage");
		
		reportLog("Verify if the login page is displayed");
		loginPage.verifyLoginPage();

		reportLog("Input user credentials to login");
		loginPage.loginUser();
				
		reportLog("Verify if the user is logged in or not");
		homePage.verifyLoggedIn();
		attachScreenShot("10060", "Dashboard");

		reportLog("Reset if the already selected items are in cart");
		homePage.resetOrder();

		reportLog("Verifying cart quatiy value 0 in data base for current user "+email+" and product "+productName);
		MySqlUtils sql = new MySqlUtils();
		int quantity = sql.getCartProductQuantity(email, productName);
		Assert.assertEquals(quantity, 0, "Product "+productName+" quantiy is more than zero on data base cart table");
		
		reportLog("search and select a product from the list");
		ProductListingPage productListingPage = homePage.searchProduct(productName);
		attachScreenShot("10060", "SearchProduct");
		
		reportLog("Verify the Product listing page is displaying the product on title");
		productListingPage.verifyProductListingPageTitle("Search - " + productName + "");

		reportLog("search the filterd item and go to the Product Display Page");
		ProductDisplayPage productDisplayPage = productListingPage.selectFirstProduct(productName);

		reportLog("Verify the contents available in the Product display page for the selected item");
		String productAmount = productDisplayPage.verifyProductDisplayContents();

		reportLog("Clicks on Add to Cart button");
		productDisplayPage.clickOnAddToCart();
				
		reportLog("Veify notification message after adding an item into cart");
		productDisplayPage.verifyProductAddedNotification();
		
		reportLog("Veify Cart item numbers");
		productDisplayPage.verifyCartItems();
		attachScreenShot("10060", "CartPage");
		
		reportLog("Verifying cart quatiy value 1 in data base for current user "+email+" and product "+productName);
		quantity = sql.getCartProductQuantity(email, productName);
		Assert.assertEquals(quantity, 1, "Product "+productName+" quantity not added in database cart table");
				
		reportLog("Clicks on Item button to check its details before checkout");
		productDisplayPage.clickOnItems();

		reportLog("Verify bucket pop up contents related to item details");
		productDisplayPage.verifyPopUpContents(productName, productAmount);

		reportLog("Clicks on CheckOut button to chhck into payment page");
		CheckOutPage checkOutPage = productDisplayPage.clickOnCheckOut();

		reportLog("Verify payment address is checked");
		checkOutPage.verifyRadioButtonSelected("Payment Address");

		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Payment Address");

		reportLog("Verify shipping address is checked");
		checkOutPage.verifyRadioButtonSelected("Shipping Address");

		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Shipping Address");

		reportLog("Verify shipping method is checked");
		checkOutPage.verifyRadioButtonSelected("Shipping Method");

		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Shipping Method");

		reportLog("Verify shipping method is checked");
		checkOutPage.verifyRadioButtonSelected("Payment Method");

		reportLog("Click On Terms and Conditions");
		checkOutPage.clickOnTC();

		reportLog("Click On Continue button");
		checkOutPage.clickOnContinue("Payment Method");

		reportLog("Verify the order details on Confirm Section");
		checkOutPage.verifyConfirmOrder(productName);
		attachScreenShot("10060", "ConfirmOrder");
		
		reportLog("Log Out from the existing user");
		homePage.logOut();
		
		JSONObject jsonData = JsonFileUtil.readJsonData(GlobalConstant.inputFile, FileName.Pets.toString());
		reportLog("Started execution of test user Post pets");
		String requestUrl = GlobalConstant.Root_URI;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_POST);
		logPostBody(jsonData.toString());
		
		Response response = given().headers(getAllHeaders()).body(jsonData).when().post(requestUrl);
		reportResponseLog(response.asString());
		
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
		int id = ((Long) jsonData.get("id")).intValue();

		response.then().body("category.id", equalTo(0)).body("id", equalTo(id));
		int petsId = response.then().extract().path("id");
		reportLog("Created pets id "+petsId);

		reportLog("Verify post response json schema");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/PostsShema.json"));
		
		reportLog("Started execution of test get pets");
		requestUrl = GlobalConstant.Root_URI + petsId;
		
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_GET);
		response = given().header(getAcceptJsonHeader()).when().get(requestUrl);
		reportResponseLog(response.asString());

		id = ((Long) jsonData.get("id")).intValue();
		response.then().body("category.id", equalTo(0)).body("category.name", equalTo("string")).body("id", equalTo(id)).body("status", equalTo(jsonData.get("status"))).body("name",
				equalTo(jsonData.get("name")));

		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
		reportLog("Verify get pets by id response json schema");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schema/GetPetSchema.json"));
		
		reportLog("Started execution of test delete pets");

		requestUrl = GlobalConstant.Root_URI + petsId;
		logRquestUrl(requestUrl);
		logMethodType(MethodType.HTTP_DELETE);
		response = given().header(getAcceptJsonHeader()).when().delete(requestUrl);
		reportResponseLog(response.asString());
		
		verifyResponseCodeAndContentType(response, HttpStatusCode.HTTP_OK, GlobalConstant.Application_JSON);
	}

}
*/
