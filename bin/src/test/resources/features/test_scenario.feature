Feature: Verify Add to cart 
	As a user, I want able to see the product added in the cart

@all 
Scenario: Verify Search And Checkout With Registered User
	Given launch open cart portal and verify 
	Then select login user from the Login Menu option 
	And verify login page is displayed
	Given input user credentials
	Then verify user is logged in
	Then reset if any already selected items are in cart
	Given search "MacBook Air" and select a product from the list
	Then verify the "MacBook Air" listing page is displaying the product on title
	Given search the filterd item and go to the "MacBook Air" Display Page
	Then verify the contents available in the Product display page for the selected item
	Given select Add to Cart button
	Then verify notification message after adding an item into cart
	And verify Cart item numbers
	Given select Item button to check its details before checkout
	Then verify bucket pop up contents related to "MacBook Air" item details
	Given select CheckOut link to check into payment page
	Then verify payment address is checked
	Given click On Continue button of "Billing"
	Then verify shipping address is checked
	Given click On Continue button of "Shipping"
	Then verify shipping method is checked
	Given click On Continue button of "Shipping Method"
	Then verify payment method is checked
	Given Click On Terms and Conditions
	Given click On Continue button of "Payment"
	Then verify the order details on Confirm Section of "MacBook Air"
	Given log Out from the existing user

	

