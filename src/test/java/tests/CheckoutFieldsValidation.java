package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutComplete;
import pages.CheckoutStepOne;

public class CheckoutFieldsValidation extends GenericTest {

	@Test
	public void testUserIsNotAbleToCompleteCheckoutWithEmptyFields() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart()
				.startCheckout().emptyCheckoutFields();

		Assert.assertEquals(CheckoutStepOne.getErrorMessageText(), "Error: First Name is required");
	}

	public void testUserIsNotToCompleteCheckoutWithoutFirstName() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart()
				.startCheckout().CheckoutFieldsWithoutFirstName("Lucky", "44441");

		Assert.assertEquals(CheckoutStepOne.getErrorMessageText(), "Error: First Name is required");

	}

	public void testUserIsNotAbleToCompleteCheckoutWithoutLastName() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart()
				.startCheckout().CheckoutFieldsWithoutLastName("Nata", "44441");

		Assert.assertEquals(CheckoutStepOne.getErrorMessageText(), "Error: Last Name is required");

	}

	public void testUserIsNotAbleToCompleteCheckoutWithoutPostalCode() {

		CheckoutStepOne checkout = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart()
				.startCheckout().CheckoutFieldsWithoutPostalCode("Nata", "Lucky");

		Assert.assertEquals(CheckoutStepOne.getErrorMessageText(), "Error: Postal Code is required");

	}

}
