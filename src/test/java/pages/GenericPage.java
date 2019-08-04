package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GenericPage {
	
	private WebDriver pageDriver;
	
	public GenericPage () {
	
	}

	public GenericPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}

}
