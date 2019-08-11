package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class LoginPage extends AbstractBasePage {

	@FindBy(id = "user-name")
	private WebElement usernameInput;
	@FindBy(id = "password")
	private WebElement passwordInput;
	@FindBy(css = "input[value='LOGIN']")
	private WebElement loginButton;
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMessageWithoutLoginAndPassword;

	public LoginPage() {
		super();
	}

//	public void loginAs(String username, String password) {
//		
//		usernameInput.sendKeys(username);
//		passwordInput.sendKeys(password);
//		loginButton.click();
//		

	public boolean isLoginButtonDisplayed() {
		loginButton.isDisplayed();

		return true;
	}

	@Step("Login as with username [{0}] and password [{1}]")
	public ProductsPage loginAs(String usermame, String password) {

		testLoginCredentials(usermame, password);

		return new ProductsPage();

	}

	public LoginPage testLoginCredentials(String usermame, String password) {

		WebDriverWait waiter1 = new WebDriverWait(getWebdriver(), 20);
		waiter1.until(ExpectedConditions.elementToBeClickable(usernameInput));

		WebDriverWait waiter2 = new WebDriverWait(getWebdriver(), 20);
		waiter2.until(ExpectedConditions.elementToBeClickable(passwordInput));

		WebDriverWait waiter3 = new WebDriverWait(getWebdriver(), 20);
		waiter3.until(ExpectedConditions.elementToBeClickable(loginButton));

		usernameInput.sendKeys(usermame);
		passwordInput.sendKeys(password);
		loginButton.click();

		return new LoginPage();
//			return new LoginPage(errorMessageWithoutLoginAndPassword);

	}

	public boolean isErrorMessageDisplayed() {
		return errorMessageWithoutLoginAndPassword.isDisplayed();
	}

	public String getErrorMessage() {
		return errorMessageWithoutLoginAndPassword.getText();
	}

//	public static void UserIsNotAbleToLoginWithoutUsername(String password) {
//
//		passwordInput.sendKeys(password);
//		loginButton.click();

//	}

//	public static void lockedAndNonExistedUserLoginIn(String username, String password) {
//		usernameInput.sendKeys(username);
//		passwordInput.sendKeys(password);
//		loginButton.click();
//		
//	}

}
