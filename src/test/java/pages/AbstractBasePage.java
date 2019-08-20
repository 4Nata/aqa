package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public abstract class AbstractBasePage {

	private WebDriver pageDriver;

	public AbstractBasePage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}

//	public WebDriver getWebdriver() {
//		return pageDriver;
//
//	}
	
	public Header header() {
		
		return new Header();
	}

	@Step("Click Cart icon")
	public CartPage clickMiniCart() {
		return clickMiniCart();
	}

}
