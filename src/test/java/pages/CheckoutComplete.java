package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;

public class CheckoutComplete extends GenericPage  {

	private WebDriver pageDriver;

	public CheckoutComplete() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}

}
