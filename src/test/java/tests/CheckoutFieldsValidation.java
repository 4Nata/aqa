package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutComplete;
import pages.CheckoutStepOne;

public class CheckoutFieldsValidation extends GenericTest {

	@Test

	public void validationCheckoutFields() {
		CheckoutStepOne checkout1 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Test.allTheThings() T-Shirt (Red)").openCart().startCheckout()
				.checkoutFieldsValidation("", "", "");

		Assert.assertEquals(checkout1.getErrorMessageText(), "Error: First Name is required");

		CheckoutStepOne checkout2 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Fleece Jacket").openCart().startCheckout()
				.checkoutFieldsValidation("", "Lucky", "44441");

		Assert.assertEquals(checkout2.getErrorMessageText(), "Error: First Name is required");

		CheckoutStepOne checkout3 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie").openCart().startCheckout()
				.checkoutFieldsValidation("Nata", "", "44441");

		Assert.assertEquals(checkout3.getErrorMessageText(), "Error: Last Name is required");

		CheckoutStepOne checkout4 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Bike Light").openCart().startCheckout()
				.checkoutFieldsValidation("Nata", "Lucky", "");

		Assert.assertEquals(checkout4.getErrorMessageText(), "Error: Postal Code is required");

	}

}
