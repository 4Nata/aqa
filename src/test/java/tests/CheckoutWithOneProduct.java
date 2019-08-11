package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import app.WebApp;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CartPage;
import pages.CheckoutComplete;
import pages.CheckoutStepOne;
import pages.CheckoutStepTwo;

public class CheckoutWithOneProduct extends GenericTest {

	
	@Feature("Place an Order")
	@Story("PLH-443")
	@Test
	public void testUserIsAbleToPlaceOrderWithOneProduct() {

		CheckoutComplete checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart("Sauce Labs Bike Light")
				.header.openCart().startCheckout().continueCheckout("Natalie", "Lucky", "44444").checkoutComplete();
		
		Assert.assertEquals(WebApp.getBrowser().getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "The expected url should be the following "
				+ "https://www.saucedemo.com/checkout-complete.html - but actula url is - " + WebApp.getBrowser().getCurrentUrl());

	}

}
