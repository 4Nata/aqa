package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

	private WebDriver pageDriver;

	public CheckoutComplete(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}

}
