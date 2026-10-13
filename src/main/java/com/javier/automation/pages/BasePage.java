package com.javier.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.javier.automation.utils.WaitUtils;



public class BasePage {
	protected WebDriver driver;//that only declares the reference.
	protected WaitUtils waitUtils;
	
	public BasePage(WebDriver driver) {//constructor
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    waitUtils = new WaitUtils(driver);
	}
}
