package com.javier.automation.managers;

import org.openqa.selenium.WebDriver;

import com.javier.automation.pages.LoginPage;
import com.javier.automation.pages.CartPage;
import com.javier.automation.pages.CheckoutPage;
import com.javier.automation.pages.HomePage;
import com.javier.automation.pages.ProductsPage;
import com.javier.automation.pages.PaymentPage;
import com.javier.automation.pages.OrderConfirmationPage;

public class POMManager {
	private WebDriver driver;
	private LoginPage loginPage;//This declares the reference, but no LoginPage object exists yet:
	private HomePage homePage;
	private ProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private PaymentPage paymentPage;
	private OrderConfirmationPage orderConfirmationPage;
	 
	public POMManager(WebDriver driver) {
	    this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		 if (loginPage == null) {
	            loginPage = new LoginPage(driver);
	        }
		return loginPage;
	    
	}
	
	public HomePage getHomePage() {
		 if (homePage == null) {
			 homePage = new HomePage(driver);
	        }
		return homePage;
	    
	}
	
	public ProductsPage getProductsPage() {
		if (productsPage == null) {
			productsPage = new ProductsPage(driver);
	        }
		return productsPage;
	}
	
	public CartPage getCartPage() {
		if (cartPage == null) {
			cartPage = new CartPage(driver);
	        }
		return cartPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		if (checkoutPage == null) {
			checkoutPage = new CheckoutPage(driver);
	        }
		return checkoutPage;
	}
	
	public PaymentPage getPaymentPage() {
		if (paymentPage == null) {
			paymentPage = new PaymentPage(driver);
	        }
		return paymentPage;
	}
	
	public OrderConfirmationPage getOrderConfirmationPage() {

	    if (orderConfirmationPage == null) {
	        orderConfirmationPage = new OrderConfirmationPage(driver);
	    }

	    return orderConfirmationPage;
	}
	
}
