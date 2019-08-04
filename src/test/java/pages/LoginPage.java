package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class LoginPage  extends GenericPage {
	private WebDriver pageDriver;

	public LoginPage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}

	@FindBy(id = "user-name")
	public  WebElement usernameInput;

	@FindBy(id = "password")
	public  WebElement passwordInput;

	@FindBy(css = "input[value='LOGIN']")
	public  WebElement loginButton;

	@FindBy(css = "h3[data-test='error']")
	public WebElement errorMessageWithoutLoginAndPassword;

//	public void loginAs(String username, String password) {
//		
//		usernameInput.sendKeys(username);
//		passwordInput.sendKeys(password);
//		loginButton.click();
//		

	
	@Step("Login as with username {0} and password{1}")
	public ProductsPage loginAs(String usermame, String password) {

		testLoginCredentials(usermame, password);

		return new ProductsPage();

	}

	public LoginPage testLoginCredentials(String usermame, String password) {

		usernameInput.sendKeys(usermame);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return new LoginPage();
//			return new LoginPage(errorMessageWithoutLoginAndPassword);

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
