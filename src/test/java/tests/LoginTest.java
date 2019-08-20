package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.ProductsPage;

public class LoginTest extends GenericTest { 

	@Feature("Login")
	@Story("PLH-444")

	@Test

	public void testUserIsAbleToLoginIntoApp() {

		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce");

		Assert.assertTrue(productsPage.isUserLoggedIn(), "User should be logged into app after entering valid creds");

	}

}
