package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.WebApp;
import io.qameta.allure.Step;

public abstract class AbstractBasePage {

	private WebDriver pageDriver;

	public AbstractBasePage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}

	public WebDriver getWebdriver() {
		return pageDriver;

	}

	public static final long TIME_SECONDS_LIMIT = 30;
	public static final long SLEEP_IN_MILLIS = 2000;

	protected void clickAndWaitForAppear(WebElement currentElement, WebElement expectedElement) {
		getDriverWait().until(ExpectedConditions.elementToBeClickable(currentElement));
		currentElement.click();
		getDriverWait().until(ExpectedConditions.visibilityOf(expectedElement));
	}

	private WebDriverWait getDriverWait() {
		return new WebDriverWait(getWebdriver(), TIME_SECONDS_LIMIT, SLEEP_IN_MILLIS);
	}

	public Header header() {

		return new Header();
	}

	@Step("Click Cart icon")
	public CartPage clickMiniCart() {
		return clickMiniCart();
	}

}
