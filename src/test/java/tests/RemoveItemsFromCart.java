package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;

public class RemoveItemsFromCart extends GenericTest {

	@Test
	public void testUserIsAbleToRemoveProductsFromToCart() {

		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)").openCart()
				.removeProductFromCart("Sauce Labs Onesie");

		Assert.assertTrue(cartPage.cartBadge.isDisplayed());

		cartPage.removeProductFromCart("Test.allTheThings() T-Shirt (Red)");

		Assert.assertFalse(cartPage.removeButton.isDisplayed(),
				"The Cart badge should not be displayed when all products are removed");
		
//		Assert.assertNull(cartPage.removeButton);
	}

}
