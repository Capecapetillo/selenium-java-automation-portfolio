package com.javier.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.javier.automation.base.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeOrderSuccessfully() {
    	navigateTo(baseUrl + "/login");
    	pomManager.getLoginPage().login(loginEmail, loginPassword);
    	String actualLoggedInUser = pomManager.getHomePage().getLoggedInUserText();
		String expectedLoggedInUser = "Logged in as Eduardo";
		Assert.assertEquals(actualLoggedInUser, expectedLoggedInUser);
		navigateTo(baseUrl + "/view_cart");
		pomManager.getCartPage().removeBlueTopIfPresent();
		navigateTo(baseUrl + "/products");
		
    	pomManager.getProductsPage().addBlueTopToCart();
    	String actualConfirmation = pomManager.getProductsPage().getAddedConfirmation();
    	String expectedConfirmation = "Added!";
    	Assert.assertEquals(actualConfirmation, expectedConfirmation);
    	pomManager.getProductsPage().clickViewCart();
    	String actualDescription = pomManager.getCartPage().getBlueTopProductName();
    	String expectedDescription = "Blue Top";
    	Assert.assertEquals(actualDescription, expectedDescription);
    	pomManager.getCartPage().clickProceedToCheckout();
    	
    	//pomManager.getCheckoutPage().getTotalAmount();
    	String actualTotalAmount = pomManager.getCheckoutPage().getTotalAmount();
    	String expectedTotalAmount = "Rs. 500";
    	Assert.assertEquals(actualTotalAmount, expectedTotalAmount);
    	pomManager.getCheckoutPage().clickPlaceOrder();
    	
    	
    	
    	pomManager.getPaymentPage().enterPaymentDetails(
    			"Test User", 
    			"4111111111111111", 
    			"123", 
    			"12", 
    			"2030");
    	pomManager.getPaymentPage().clickPayAndConfirmOrder();
    	
    	String actualOrderPlaced = pomManager.getOrderConfirmationPage().getOrderPlacedMessage();
        String expectedOrderPlaced = "ORDER PLACED!";
    	Assert.assertEquals(actualOrderPlaced, expectedOrderPlaced);
    		
    	
    	String actualConfirmationMessage = pomManager.getOrderConfirmationPage().getConfirmationMessage();
    	String expectedConfirmationMessage = "Congratulations! Your order has been confirmed!";  
    	Assert.assertEquals(actualConfirmationMessage, expectedConfirmationMessage);
    }
}