package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // locators
    @FindBy(css = "[data-qa='name-on-card']")
    private WebElement nameOnCard;
    
    @FindBy(css = "[data-qa='card-number']")
    private WebElement cardNumberInput;
    
    @FindBy(css = "[data-qa='cvc']")
    private WebElement cvcInput;
    
    @FindBy(css = "[data-qa='expiry-month']")
    private WebElement expirationMonth;
    
    @FindBy(css = "[data-qa='expiry-year']")
    private WebElement expiryYearInput;
    
    @FindBy(css = "[data-qa='pay-button']")
    private WebElement payButton;

    // methods
    public void enterPaymentDetails(
            String name,
            String cardNumber,
            String cvc,
            String month,
            String year) {

        // send
    	waitUtils.waitForElementToBeVisible(nameOnCard).sendKeys(name);
    	cardNumberInput.sendKeys(cardNumber);
    	cvcInput.sendKeys(cvc);
    	expirationMonth.sendKeys(month);
    	expiryYearInput.sendKeys(year);
    	
    }
    
    public void clickPayAndConfirmOrder() {
        // wait for button + click
    	waitUtils.waitForElementToBeClickable(payButton).click();
    	
    }
    
}