package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    // locators
    @FindBy(css = "[data-qa='order-placed']")
    private WebElement orderPlacedMessage;

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement confirmationMessage;
    // methods
    
    public String getOrderPlacedMessage() {
    	// wait until orderPlacedMessage is visible
    	return waitUtils.waitForElementToBeVisible(orderPlacedMessage).getText();
       }

    public String getConfirmationMessage() {
    	return waitUtils.waitForElementToBeVisible(confirmationMessage).getText();
    	}
    
    
}