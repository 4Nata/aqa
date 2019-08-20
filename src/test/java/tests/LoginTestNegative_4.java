package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LoginTestNegative_4 extends GenericTest {

	@Feature("Login as LOCKED user")
	@Story("PLH-447")
	@Test
	public void testLockedUserIsNotAbleToLogin() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("locked_out_user", "secret_sauce");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
	}

}
