package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.WebApp;
import io.qameta.allure.Step;

public class LoginPage extends AbstractBasePage {

	@FindBy(id = "user-name")
	private WebElement usernameInput;
	@FindBy(id = "password")
	private WebElement passwordInput;
	@FindBy(css = "input[value='LOGIN']")
	protected WebElement loginButton;
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMessageWithoutLoginAndPassword;

	public LoginPage() {
		super();
	}

	@Step("Check that [Login] button is displayed")
	public boolean isLoginButtonDisplayed() {
		try {
			loginButton.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@Step("Login as with username [{0}] and password [{1}]")
	public ProductsPage loginAs(String usermame, String password) {

		testLoginCredentials(usermame, password);

		return new ProductsPage();

	}

	@Step("Enter {username} and {password}")
	public LoginPage testLoginCredentials(String usermame, String password) {

		WebDriverWait waiter1 = new WebDriverWait(WebApp.getBrowser(), 20);
		waiter1.until(ExpectedConditions.elementToBeClickable(usernameInput));

		WebDriverWait waiter2 = new WebDriverWait(WebApp.getBrowser(), 20);
		waiter2.until(ExpectedConditions.elementToBeClickable(passwordInput));

		WebDriverWait waiter3 = new WebDriverWait(WebApp.getBrowser(), 20);
		waiter3.until(ExpectedConditions.elementToBeClickable(loginButton));

		usernameInput.sendKeys(usermame);
		passwordInput.sendKeys(password);
		loginButton.click();

		return new LoginPage();

	}

	@Step("Check that Error message is displayed")
	public boolean isErrorMessageDisplayed() {
		try {
			errorMessageWithoutLoginAndPassword.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}

	@Step("Observe error message text")
	public String getErrorMessage() {
		return errorMessageWithoutLoginAndPassword.getText();
	}

}
