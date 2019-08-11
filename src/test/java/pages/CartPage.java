package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class CartPage extends AbstractBasePage {

//	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(), '1')]")
//	private WebElement cartBadge;
	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;
	@FindBy(xpath = "//button[@class='btn_secondary cart_button' and contains(text(), 'REMOVE')]")
	private WebElement removeButton;

	public CartPage() {
		super();
	}

	@Step("Click [Checkout]")
	public CheckoutStepOne startCheckout() {

		checkoutButton.click();

		return new CheckoutStepOne();

	}

	@Step("Click [Remove] button to delete product from Cart")
	public CartPage removeProductFromCart(String... productNames) {

		for (int i = 0; i < productNames.length; i++) {

			getWebdriver().findElement(By.xpath("//div[@class='cart_item_label']//div[contains(text(), '"
					+ productNames[i]
					+ "')]//ancestor::div[@class='cart_item_label']/descendant::button[@class='btn_secondary cart_button']"))
					.click();

		}

//		//div[@class='cart_item_label']//div[contains(text(), '" + productNames[i]
//		+ "')]//ancestor::div[@class='cart_item_label']/descendant::button[@class='btn_secondary cart_button']
//		
		return this;
	}

	public boolean isRemoveButtonDisplayed() {

		removeButton.isDisplayed();
		return true;
	}

}
