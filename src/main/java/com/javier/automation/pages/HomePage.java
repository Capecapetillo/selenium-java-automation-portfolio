package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
        super(driver);//calls the BasePage constructor
    }
	
	@FindBy(xpath = "//a[contains(.,'Logged in as')]")
	private WebElement loggedInUser;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement productsLink;
	
	public String getLoggedInUserText() {
	    return waitUtils
	            .waitForElementToBeVisible(loggedInUser)
	            .getText();
	}
	
	public void clickProducts() {
		waitUtils.waitForElementToBeClickable(productsLink).click();
	}
	
}
