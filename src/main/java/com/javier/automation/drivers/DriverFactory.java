package com.javier.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private WebDriver driver;
	
	public void initializeDriver(String browser) {
		 switch (browser.toLowerCase()) {

	        case "chrome":
	        	ChromeOptions options = new ChromeOptions();
	        	if (System.getenv("CI") != null) {
	                options.addArguments("--headless=new");
	                options.addArguments("--no-sandbox");
	                options.addArguments("--disable-dev-shm-usage");
	                options.addArguments("--window-size=1920,1080");
	            }
	            driver = new ChromeDriver();
	            break;
	    
	        case "firefox":
	            driver = new FirefoxDriver();
	            break;
	   
	        case "edge":
	            driver = new EdgeDriver();
	            break;
	   
	        default:
	        throw new IllegalArgumentException("Unsupported browser: " + browser);
		 
	}
}
	
	public WebDriver getDriver() {
	    return driver;
	}
	
	public void quitDriver() {//this method destroys the browser
	    if (driver != null) {
	        driver.quit(); // Closes all windows and kills the driver process
	        driver = null; // Resets the variable for the next test run
	    }
	}
}