package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CheckoutStepOne;

public class CheckoutFieldsValidation extends GenericTest {

	@Feature("Checkout Fields Validation")
	@Story("PLH-442")
	@Test

	public void validationEmptyFields() {
		CheckoutStepOne checkout1 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Test.allTheThings() T-Shirt (Red)").header.openCart().startCheckout()
						.checkoutFieldsValidation("", "", "");

		Assert.assertEquals(checkout1.getErrorMessageText(), "Error: First Name is required");

	}

	@Feature("Checkout Fields Validation")
	@Story("PLH-442")
	@Test
	public void validationWithoutUsername() {

		CheckoutStepOne checkout2 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Fleece Jacket").header.openCart().startCheckout()
						.checkoutFieldsValidation("", "Lucky", "44441");

		Assert.assertEquals(checkout2.getErrorMessageText(), "Error: First Name is required");

	}

	@Feature("Checkout Fields Validation")
	@Story("PLH-442")
	@Test
	public void validationWithoutLastName() {

		CheckoutStepOne checkout3 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie").header.openCart().startCheckout()
						.checkoutFieldsValidation("Nata", "", "44441");

		Assert.assertEquals(checkout3.getErrorMessageText(), "Error: Last Name is required");

	}

	@Feature("Checkout Fields Validation")
	@Story("PLH-442")
	@Test
	public void validationWithoutPostalCode() {

		CheckoutStepOne checkout4 = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Bike Light").header.openCart().startCheckout()
						.checkoutFieldsValidation("Nata", "Lucky", "");

		Assert.assertEquals(checkout4.getErrorMessageText(), "Error: Postal Code is required");

	}

}
