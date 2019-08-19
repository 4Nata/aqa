package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import app.WebApp;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CartPage;

public class AddProductToTheCart extends GenericTest {

//	private WebDriver driver = null;

	@Feature("Adding Products To The Cart")
	@Story("PLH-441")
	@Test
	public void testUserIsAbleToAddProductToCart() {

		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)").header.openCart();

		Assert.assertEquals(WebApp.getBrowser().getCurrentUrl(), "https://www.saucedemo.com/cart.html",
				"Url should be the following - 'https://www.saucedemo.com/cart.html', but current URL is - "
						+ WebApp.getBrowser().getCurrentUrl());

	}

}
