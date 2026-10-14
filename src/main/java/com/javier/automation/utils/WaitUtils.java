package com.javier.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	//private WebDriver driver;
	private WebDriverWait wait;//declare the variable

    public WaitUtils(WebDriver driver) {
        //this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));//initialize it in the constructor
    }
    
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    //wait until an element disappears
    public boolean waitForElementToDisappear(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
    
    public boolean waitForUrlToContain(String text) {
        return wait.until(
            ExpectedConditions.urlContains(text)
        );
    }
    
}
