package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.WebApp;
import io.qameta.allure.Step;

public class ProductsPage extends AbstractBasePage {

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartIcon;
	@FindBy(css = "div.inventory_item_price")
	private List<WebElement> productPrices;
	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> productNames;
	@FindBy(css = ".product_sort_container")
	private WebElement sortDropdown;
	@FindBy(xpath = "//button[contains(text(), 'ADD TO CART')]")
	private WebElement addToCartButton;
	@FindBy(id = "#shopping_cart_container")
	private WebElement shoppingCartContainer;
	@FindBy(css = "div.bm-burger-button button")
	private WebElement menuButton;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutButton;

	public ProductsPage() {
		super();
	}

	public boolean isUserLoggedIn() {
		try {
			return shoppingCartIcon.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public List<String> getProductsNames() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			names.add(productName);
		}

		return names;

	}

	@Step("Sort Products By Names Asc")
	public ProductsPage sortByNamesAsc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("az");
		return this;
	}

	@Step("Sort Products By Names Desc")
	public ProductsPage sortByNamesDesc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("za");
		return this;
	}

	public List<Double> getProductsPrices() {
		List<Double> prices = new ArrayList<>();
		for (int i = 0; i < productPrices.size(); i++) {
			String productPrice = productPrices.get(i).getText();
			double price = Double.parseDouble(productPrice.replace("$", ""));
			prices.add(price);
		}

		return prices;

	}

	@Step("Sort Products By Prices Asc")
	public ProductsPage sortByPriceAsc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("lohi");
		return this;
	}

	@Step("Sort Products By Prices Desc")
	public ProductsPage sortByPriceDesc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("hilo");
		return this;
	}

	// (List<String> productNames)

	@Step("Add Product To The Cart")
	public ProductsPage addProductToCart(String... productNames) {

//		for (int i=0; i < productNames.size(); i++ ) {
//
//		pageDriver.findElement(By.xpath("//div[@class='inventory_item']//div[contains(text(), '" + productNames.get(i)
//				+ "')]//ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']")).click();

		for (int i = 0; i < productNames.length; i++) {

			getWebdriver().findElement(By.xpath("//div[@class='inventory_item']//div[contains(text(), '"
					+ productNames[i]
					+ "')]//ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']"))
					.click();

		}
		return this;
	}

	@Step("Open Cart")
	public CartPage openCart() {

		shoppingCartIcon.click();

		return new CartPage();
	}

//	public CartPage addThreeProductsToCart() {
//
//		addToCartButton.click();
//		addToCartButton.click();
//		addToCartButton.click();
//
//		shoppingCartIcon.click();
//
//		return new CartPage();
//	}
@Step("Click [Logout] button to logout from the app")
	public LoginPage logout() {

		menuButton.click();

		WebDriverWait waiter = new WebDriverWait(getWebdriver(), 20); // wait 10 seconds
		waiter.until(ExpectedConditions.elementToBeClickable(logoutButton));

		logoutButton.click();

		return new LoginPage();

	}

}

//public ProductsPage addToCart(String productName) {   залишаємося на цій самій сторінці - метод повертає сам себе
//	
//	
//	
//	return this;
//}