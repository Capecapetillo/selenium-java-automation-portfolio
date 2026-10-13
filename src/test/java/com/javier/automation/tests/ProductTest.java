package com.javier.automation.tests;

import org.testng.annotations.Test;

import com.javier.automation.base.BaseTest;
import org.testng.Assert;

public class ProductTest extends BaseTest {

    @Test
    public void addBlueTopProductToCart() {
    	navigateTo(baseUrl + "/products");
    	pomManager.getProductsPage().addBlueTopToCart();
    	String actualConfirmation = pomManager.getProductsPage().getAddedConfirmation();
    	String expectedConfirmation = "Added!";
    	Assert.assertEquals(actualConfirmation, expectedConfirmation);
    	pomManager.getProductsPage().clickViewCart();
    	String actualDescription = pomManager.getCartPage().getBlueTopProductName();
    	String expectedDescription = "Blue Top";
    	Assert.assertEquals(actualDescription, expectedDescription);
    	
    	String actualPrice = pomManager.getCartPage().getPrice();
    	String expectedPrice = "Rs. 500";
    	Assert.assertEquals(actualPrice, expectedPrice);
    	
    	String actualQuantity = pomManager.getCartPage().getQuantity();
    	String expectedQuantity = "1";
    	Assert.assertEquals(actualQuantity, expectedQuantity);
    	
    	String actualTotal = pomManager.getCartPage().getTotal();
    	String expectedTotal = "Rs. 500";
    	Assert.assertEquals(actualTotal, expectedTotal);
    	
    	
    }
    
   
}