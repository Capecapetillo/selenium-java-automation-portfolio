package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends BasePage {
	
	public ProductsPage(WebDriver driver) {
        super(driver);//calls the BasePage constructor
    }
	
	@FindBy(xpath = "//p[text()='Blue Top']/ancestor::div[contains(@class,'product-overlay')]//a[contains(@class,'add-to-cart')]")
	private WebElement blueTopAddToCartButton;
	
	@FindBy(xpath = "//p[text()='Blue Top']/ancestor::div[contains(@class,'product-image-wrapper')]")
	private WebElement blueTopProductCard;
	
	@FindBy(xpath = "//h4[text()='Added!']")
	private WebElement addedConfirmation;
	
	@FindBy(css = "#cartModal a[href='/view_cart']") //parent descendent
	private WebElement viewCartLink;
	
	
	public void addBlueTopToCart() {
	Actions actions = new Actions(driver);
	actions.scrollToElement(blueTopProductCard).perform();
	actions.moveToElement(blueTopProductCard).perform();
	waitUtils.waitForElementToBeClickable(blueTopAddToCartButton).click();
	}
	
	public String  getAddedConfirmation() {
		return waitUtils
	            .waitForElementToBeVisible(addedConfirmation).getText();
	}
	
	public void clickViewCart() {
	   waitUtils.waitForElementToBeClickable(viewCartLink).click();
	}
	

}
