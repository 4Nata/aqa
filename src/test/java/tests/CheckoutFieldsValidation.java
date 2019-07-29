package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutComplete;
import pages.CheckoutStepOne;

public class CheckoutFieldsValidation extends GenericTest {

	@Test
	public void testUserIsNotAbleToCompleteCheckoutWithEmptyFields() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart("Test.allTheThings() T-Shirt (Red)")
				.openCart().startCheckout().checkoutFieldsValidation("", "", "");

		Assert.assertEquals(checkout.getErrorMessageText(), "Error: First Name is required");
	}

	public void testUserIsNotToCompleteCheckoutWithoutFirstName() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart("Sauce Labs Fleece Jacket")
				.openCart().startCheckout().checkoutFieldsValidation("", "Lucky", "44441");

		Assert.assertEquals(checkout.getErrorMessageText(), "Error: First Name is required");

	}

	public void testUserIsNotAbleToCompleteCheckoutWithoutLastName() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart("Sauce Labs Onesie")
				.openCart().startCheckout().checkoutFieldsValidation("Nata", "", "44441");

		Assert.assertEquals(checkout.getErrorMessageText(), "Error: Last Name is required");

	}

	public void testUserIsNotAbleToCompleteCheckoutWithoutPostalCode() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart("Sauce Labs Bike Light")
				.openCart().startCheckout().checkoutFieldsValidation("Nata", "Lucky", "");

		Assert.assertEquals(checkout.getErrorMessageText(), "Error: Postal Code is required");

	}

}
