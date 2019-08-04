package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;

public class CartPage extends GenericPage {

	private WebDriver pageDriver;

	public CartPage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}

	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(), '1')]")
	public WebElement cartBadge;

	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//button[@class='btn_secondary cart_button' and contains(text(), 'REMOVE')]")
	public WebElement removeButton;

	public CheckoutStepOne startCheckout() {

		checkoutButton.click();

		return new CheckoutStepOne();

	}

	public CartPage removeProductFromCart(String... productNames) {

		for (int i = 0; i < productNames.length; i++) {

			pageDriver.findElement(By.xpath("//div[@class='cart_item_label']//div[contains(text(), '" + productNames[i]
					+ "')]//ancestor::div[@class='cart_item_label']/descendant::button[@class='btn_secondary cart_button']"))
					.click();

		}

//		//div[@class='cart_item_label']//div[contains(text(), '" + productNames[i]
//		+ "')]//ancestor::div[@class='cart_item_label']/descendant::button[@class='btn_secondary cart_button']
//		
		return this;
	}

}
