package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // locators
    @FindBy(xpath = "//tr[@id='product-1']/following-sibling::tr//p[contains(@class,'cart_total_price')]")
    private WebElement totalAmount;
    
    @FindBy(css = "a[href='/payment']")
	private WebElement placeOrderButton;

    // methods
    public String getTotalAmount() {
		return waitUtils.waitForElementToBeVisible(totalAmount).getText();
	}
    
    public void clickPlaceOrder() {
        waitUtils.waitForElementToBeClickable(placeOrderButton).click();
        waitUtils.waitForUrlToContain("/payment");
    }
}