package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class CartPage extends AbstractBasePage {

	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;
	@FindBy(xpath = "//button[@class='btn_secondary cart_button' and contains(text(), 'REMOVE')]")
	private WebElement removeButton;
	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> productNames;
	@FindBy(css = "div.inventory_item_price")
	private List<WebElement> productPrices;

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

		return this;
	}

	@Step("Check that [Remove] button is displayed")
	public boolean isRemoveButtonDisplayed() {

		try {

			removeButton.isDisplayed();

			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@Step("Observe all the products names")
	public List<String> getProductsNames() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			names.add(productName);
		}

		return names;

	}
	
	@Step("Observe all the products prices")
	public List<Double> getProductsPrices() {
		List<Double> prices = new ArrayList<>();
		for (int i = 0; i < productPrices.size(); i++) {
			String productPrice = productPrices.get(i).getText();
			double price = Double.parseDouble(productPrice.replace("$", ""));
			prices.add(price);
		}

		return prices;

	}

}
