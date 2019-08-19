package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LogOutTest extends GenericTest {

	@Feature("User is able to LOGOUT from the app")
	@Story("787")
	@Test

	public void testUserIsAbleToLogOutFromTheApp() {

		LoginPage loginPage = openLoginPage().loginAs("standard_user", "secret_sauce").header.logout();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login page should be opened");

	}

}
