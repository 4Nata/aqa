package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.WebApp;
import io.qameta.allure.Step;

public class Header extends AbstractBasePage {

	// private WebDriver pageDriver;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartIcon;
	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(), '1')]")
	private WebElement cartBadge;
	@FindBy(css = "div.bm-burger-button button")
	private WebElement menuButton;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutButton;

	public Header() {
		super();
//		this.pageDriver = WebApp.getBrowser();
//		PageFactory.initElements(pageDriver, this);
	}

	public boolean isMiniCartIconDisplayed() {

		shoppingCartIcon.isDisplayed();

		return true;
	}

	@Step("Click [Logout] button to logout from the app")
	public LoginPage logout() {

		menuButton.click();

		WebDriverWait waiter = new WebDriverWait(getWebdriver(), 20); // wait 10 seconds
		waiter.until(ExpectedConditions.elementToBeClickable(logoutButton));

		logoutButton.click();

		return new LoginPage();

	}

	@Step("Open Cart")
	public CartPage openCart() {

		shoppingCartIcon.click();

		return new CartPage();
	}

	public boolean cartBadgeisDisplayed() {

		cartBadge.isDisplayed();
		return true;
	}

	public CartPage clickMiniCart() {
		shoppingCartIcon.click();
		// waitForAppear(checkoutButton);
		return new CartPage();
	}

}
