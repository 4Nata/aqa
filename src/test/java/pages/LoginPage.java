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
	public static WebElement usernameInput;

	@FindBy(id = "password")
	public static WebElement passwordInput;

	@FindBy(css = "input[value='LOGIN']")
	public static WebElement loginButton;

	@FindBy(css = "h3[data-test='error']")
	public static WebElement errorMessageWithoutLoginAndPassword;

//	public void loginAs(String username, String password) {
//		
//		usernameInput.sendKeys(username);
//		passwordInput.sendKeys(password);
//		loginButton.click();
//		

	public ProductsPage loginAs(String username, String password) {

		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new ProductsPage(pageDriver);

	}

	public static void UserIsNotAbleToLoginWithoutPassword(String usermame) {

		usernameInput.sendKeys(usermame);
		loginButton.click();
//			return new LoginPage(errorMessageWithoutLoginAndPassword);

	}

	public static void UserIsNotAbleToLoginWithoutUsername(String password) {

		passwordInput.sendKeys(password);
		loginButton.click();

	}
	
	public static void lockedAndNonExistedUserLoginIn(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		
	}

}
