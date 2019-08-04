package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import app.WebApp;
import pages.CheckoutComplete;

public class CheckoutWithThreeProducts extends GenericTest {

	@Test
	public void testUserIsAbleToPlaceOrderWithThreeProducts() {

		CheckoutComplete checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addThreeProductsToCart()
				.startCheckout().continueCheckout("Natalie", "Lucky", "44444").checkoutComplete();

		Assert.assertEquals(WebApp.getBrowser().getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html",
				"The expected url should be the following "
						+ "https://www.saucedemo.com/checkout-complete.html - but actula url is - "
						+ WebApp.getBrowser().getCurrentUrl());

	}

}
