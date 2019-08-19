package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends AbstractBasePage {

	public CheckoutComplete() {
		super();
	}

	@FindBy(xpath = "//h2[contains(text(), 'THANK YOU FOR YOUR ORDER')]")
	private WebElement successMessage;

	public boolean isSuccessMessageDisplayed() {

		try {
			successMessage.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}

	}

	public String getSuccessMessageText() {

		return successMessage.getText();

	}
}
