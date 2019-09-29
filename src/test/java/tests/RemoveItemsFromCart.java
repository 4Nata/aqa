package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CartPage;
import pages.ProductsPage;

public class RemoveItemsFromCart extends GenericTest {

	@Feature("Removing Products From Cart")
	@Story("122")
	@Test
	public void testUserIsAbleToRemoveProductsFromToCart() {

		
		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)").header.openCart()
						.removeProductFromCart("Sauce Labs Onesie");

	

		Assert.assertFalse(cartPage.getProductsNames().contains("Sauce Labs Onesie"),
				"The 'Sauce Labs Onesie' products is not removed from the Cart");

		cartPage.removeProductFromCart("Test.allTheThings() T-Shirt (Red)");

		Assert.assertFalse(cartPage.getProductsNames().contains("Test.allTheThings() T-Shirt (Red)"),
				"The 'Sauce Labs Onesie' products is not removed from the Cart");

	}

}
