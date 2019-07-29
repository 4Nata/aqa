package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.GenericTest;

public class LoginPage {
	private WebDriver pageDriver;

	public LoginPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
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

	public ProductsPage loginAs(String usermame, String password) {

		testLoginCredentials(usermame, password);

		return new ProductsPage(pageDriver);

	}

	public LoginPage testLoginCredentials(String usermame, String password) {

		usernameInput.sendKeys(usermame);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return new LoginPage(pageDriver);
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
