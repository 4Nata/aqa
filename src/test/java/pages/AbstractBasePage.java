package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;

public abstract class AbstractBasePage {
	
	private WebDriver pageDriver;
	
	
	
	public AbstractBasePage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}
	
	
//	public GenericPage(WebDriver driver) {
//		this.pageDriver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	
	private Header getHeader() {
		return new Header();
		//return new Header();
	}
	
	protected WebDriver getWebdriver() {
		return pageDriver;
	}
	
    public CartPage clickMiniCart() {
    	return getHeader().clickMiniCart();
    }
	
}
