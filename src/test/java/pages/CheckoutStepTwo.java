package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class CheckoutStepTwo extends GenericPage  {
	
private WebDriver pageDriver;
	
	public CheckoutStepTwo () {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}
	
@FindBy(xpath = "//a[contains(text (), 'FINISH')]")	
private WebElement finishButton;

@Step("Complete the Checkout")	
public CheckoutComplete checkoutComplete() {
	
	finishButton.click();
	
	return  new CheckoutComplete();
}

}
