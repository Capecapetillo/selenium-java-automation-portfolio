package com.javier.automation.tests;

import com.javier.automation.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test
	public void loginWithInvalidCredentials() {
		navigateTo(baseUrl + "/login");
		pomManager.getLoginPage().login("invalidUser@email.com", "wrongPassword");
		
		String actualError = pomManager.getLoginPage().getErrorMessage();

        String expectedError = "Your email or password is incorrect!";
		//assertion
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void loginWithValidCredentials() {
		navigateTo(baseUrl + "/login");
		pomManager.getLoginPage().login(loginEmail, loginPassword);
		String actualLoggedInUser =
		        pomManager.getHomePage().getLoggedInUserText();
		String expectedLoggedInUser = "Logged in as Eduardo";
		Assert.assertEquals(actualLoggedInUser, expectedLoggedInUser);
	}
}
