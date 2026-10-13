package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {//means LoginPage inherits the common behavior from BasePage.
	public LoginPage(WebDriver driver) {
        super(driver);//calls the BasePage constructor
    }
	
	@FindBy(css = "[data-qa='login-email']")
	private WebElement emailInput;

	@FindBy(css = "[data-qa='login-password']")
	private WebElement passwordInput;

	@FindBy(css = "[data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement errorMessageText;
	
	public void login(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		waitUtils.waitForElementToBeClickable(loginButton).click();
	}
	
	public String  getErrorMessage() {
		return waitUtils
	            .waitForElementToBeVisible(errorMessageText).getText();
	}
}
