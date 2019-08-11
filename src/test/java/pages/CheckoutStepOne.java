package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class CheckoutStepOne extends AbstractBasePage {

//	private WebDriver pageDriver;
//
//	public CheckoutStepOne() {
//		this.pageDriver = WebApp.getBrowser();
//		PageFactory.initElements(pageDriver, this);
//	}

	@FindBy(id = "first-name")
	private WebElement firstNameInput;
	@FindBy(id = "last-name")
	private WebElement lastNameInput;
	@FindBy(id = "postal-code")
	private WebElement postalCodeInput;
	@FindBy(xpath = "//input[@value ='CONTINUE']")
	private WebElement continueButton;
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	public Header header = new Header();
	
	public CheckoutStepOne() {
		super();
	}

	@Step("Fill in Customer Information & click [Continue] button")
	public CheckoutStepTwo continueCheckout(String firstName, String lastName, String postalCode) {

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();

		return new CheckoutStepTwo();

	}

	@Step("Fill in the Checkout fields & click [Continue] button")
	public CheckoutStepOne checkoutFieldsValidation(String firstName, String lastName, String postalCode) {

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();

		return this;

	}

	public String getErrorMessageText() {

		String errorMessageText = errorMessage.getText();

		return errorMessageText;
	}
}
