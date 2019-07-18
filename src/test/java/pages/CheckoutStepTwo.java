package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwo {
	
private WebDriver pageDriver;
	
	public CheckoutStepTwo (WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//a[contains(text (), 'FINISH')]")	
private WebElement finishButton;

	public CheckoutComplete checkoutComplete() {
	
	finishButton.click();
	
	return  new CheckoutComplete(pageDriver);
}

}
