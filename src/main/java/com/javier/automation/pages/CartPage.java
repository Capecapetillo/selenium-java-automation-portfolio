package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
        super(driver);//calls the BasePage constructor
    }
	
	@FindBy(xpath = "//a[text()='Blue Top']")
	private WebElement blueTopProductName;
	
	@FindBy(css = "#product-1 .cart_price > p")
	private WebElement price;
	
	@FindBy(css = "#product-1 .cart_quantity > button")
	private WebElement quantity;
	
	@FindBy(css = "#product-1 .cart_total > p")
	private WebElement total;
	
	@FindBy(css = "#do_action .col-sm-6 > a")
	private WebElement checkoutButton;
	
	private By removeBlueTopLocator =
	        By.cssSelector("#product-1 .cart_quantity_delete");
	
	public String getBlueTopProductName() {
		return waitUtils.waitForElementToBeVisible(blueTopProductName).getText();
	}
	
	public String getPrice() {
		return waitUtils.waitForElementToBeVisible(price).getText();
	}
	
	public String getQuantity() {
		return waitUtils.waitForElementToBeVisible(quantity).getText();

	}
	
	public String getTotal() {
		return waitUtils.waitForElementToBeVisible(total).getText();
	}
	
	
	public void clickProceedToCheckout() {
	waitUtils.waitForElementToBeClickable(checkoutButton).click();
	}
	
	public boolean isBlueTopInCart() {
	  return !driver.findElements(removeBlueTopLocator).isEmpty();
		}
	
	public void removeBlueTopIfPresent() {

	    if (isBlueTopInCart()) {

	        // click the remove button here
	    	waitUtils.waitForElementToBeClickable(removeBlueTopLocator).click();
	    	waitUtils.waitForElementToDisappear(removeBlueTopLocator);
	    	}
	}
	
}

