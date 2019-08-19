package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LogoutFromCheckoutPage extends GenericTest {

	@Feature("User is able to logout from Checkout page")
	@Story("324")
	@Test
	public void testUserIsAbleToLogOutFromCheckoutPage() {

		LoginPage loginPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie").header.openCart().startCheckout().header.logout();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login page should be opened");

	}

}
