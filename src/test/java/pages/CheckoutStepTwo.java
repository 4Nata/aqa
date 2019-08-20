package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutStepTwo extends AbstractBasePage {

	private WebDriver pageDriver;

	@FindBy(xpath = "//a[contains(text (), 'FINISH')]")
	private WebElement finishButton;

	public CheckoutStepTwo() {
		super();
	}

	@Step("Complete the Checkout")
	public CheckoutComplete checkoutComplete() {

		finishButton.click();

		return new CheckoutComplete();
	}

}
