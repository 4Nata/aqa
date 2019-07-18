package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOne {

	private WebDriver pageDriver;

	public CheckoutStepOne(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement firstNameInput;

	@FindBy(id = "last-name")
	private WebElement lastNameInput;

	@FindBy(id = "postal-code")
	private WebElement postalCodeInput;

	@FindBy(xpath = "//input[@value ='CONTINUE']")
	private WebElement continueButton;

	@FindBy(xpath = "//h3[@data-test='error']")
	public static WebElement errorMessage;

	public CheckoutStepTwo continueCheckout(String firstName, String lastName, String postalCode) {

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();

		return new CheckoutStepTwo(pageDriver);

	}

	public CheckoutStepOne emptyCheckoutFields() {

		continueButton.click();
		return new CheckoutStepOne(pageDriver);

	}

	public CheckoutStepOne CheckoutFieldsWithoutFirstName(String lastName, String postalCode) {

		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();
		return new CheckoutStepOne(pageDriver);

	}

	public CheckoutStepOne CheckoutFieldsWithoutLastName(String firstName, String postalCode) {

		firstNameInput.sendKeys(firstName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();
		return new CheckoutStepOne(pageDriver);

	}

	public CheckoutStepOne CheckoutFieldsWithoutPostalCode(String firstName, String lastName) {

		firstNameInput.sendKeys(firstName);
		postalCodeInput.sendKeys(lastName);
		continueButton.click();
		return new CheckoutStepOne(pageDriver);

	}

	public static String getErrorMessageText() {

		String errorMessageText = errorMessage.getText();

		return errorMessageText;
	}
}
