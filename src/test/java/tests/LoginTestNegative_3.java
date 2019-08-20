package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LoginTestNegative_3 extends GenericTest {

	@Feature("Login without USERNAME")
	@Story("PLH-449")
	@Test
	public void testUserIsNotAbleToLoginWithoutUsername() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("", "secret_sauce");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

	}

}
