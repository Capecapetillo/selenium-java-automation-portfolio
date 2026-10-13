package com.javier.automation.base;

import org.openqa.selenium.WebDriver;
import com.javier.automation.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.javier.automation.drivers.DriverFactory;
import com.javier.automation.managers.POMManager;

public class BaseTest {
	
	protected DriverFactory driverFactory;//declares the variable
	protected WebDriver driver;
	protected POMManager pomManager;
	
	protected ConfigReader configReader;
	protected String browser;
	protected String baseUrl;
	protected String loginEmail;
	protected String loginPassword;
	
	@BeforeMethod
	public void setUp() {
		
		configReader = new ConfigReader();

        browser = configReader.getProperty("browser");
        baseUrl = configReader.getProperty("baseUrl");
        loginEmail = System.getenv("AE_LOGIN_EMAIL");
        loginPassword = System.getenv("AE_LOGIN_PASSWORD");
		
		driverFactory = new DriverFactory();//we're assigning an object to the same variable that was already declared above.

        driverFactory.initializeDriver(browser);

        driver = driverFactory.getDriver();
        
        pomManager = new POMManager(driver);
		
	}
	
	 protected void navigateTo(String url) {
	        driver.get(url);
	    }

	
	@AfterMethod
    public void tearDown() {
		driverFactory.quitDriver();
	}
	
}
