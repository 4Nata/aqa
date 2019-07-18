package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver pageDriver;

	public CartPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;

	public CheckoutStepOne startCheckout() {

		checkoutButton.click();

		return new CheckoutStepOne(pageDriver);

	}

}
