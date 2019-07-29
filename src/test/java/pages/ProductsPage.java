package pages;

import java.util.ArrayList;
import java.util.Collections;
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
import org.testng.Assert;

import com.google.common.collect.Ordering;

public class ProductsPage {

	private WebDriver pageDriver;

	public ProductsPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartIcon;

	public boolean isUserLoggedIn() {
		try {
			return shoppingCartIcon.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@FindBy(css = "div.inventory_item_price")
	private List<WebElement> productPrices;

	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> productNames;

	public List<String> getProductsNames() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			names.add(productName);
		}

		return names;

	}
	
	public ProductsPage sortByNamesAsc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("az");
		return this;
	}
	
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

	@FindBy(css = ".product_sort_container")
	private WebElement sortDropdown;

	public ProductsPage sortByPriceAsc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("lohi");
		return this;
	}
	
	public ProductsPage sortByPriceDesc() {
		Select select = new Select(sortDropdown);
		select.selectByValue("hilo");
		return this;
	}

	@FindBy(xpath = "//button[contains(text(), 'ADD TO CART')]")
	private WebElement addToCartButton;

	@FindBy(id = "#shopping_cart_container")
	private WebElement shoppingCartContainer;

	@FindBy(css = "div.bm-burger-button button")
	private WebElement menuButton;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logoutButton;

	// (List<String> productNames)
	public ProductsPage addProductToCart(String... productNames) {

//		for (int i=0; i < productNames.size(); i++ ) {
//
//		pageDriver.findElement(By.xpath("//div[@class='inventory_item']//div[contains(text(), '" + productNames.get(i)
//				+ "')]//ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']")).click();

		for (int i = 0; i < productNames.length; i++) {

			pageDriver.findElement(By.xpath("//div[@class='inventory_item']//div[contains(text(), '" + productNames[i]
					+ "')]//ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']"))
					.click();

		}
		return this;
	}

	public CartPage openCart() {

		shoppingCartIcon.click();

		return new CartPage(pageDriver);
	}

	public CartPage addThreeProductsToCart() {

		addToCartButton.click();
		addToCartButton.click();
		addToCartButton.click();

		shoppingCartIcon.click();

		return new CartPage(pageDriver);
	}

	public LoginPage logout() {

		menuButton.click();

		WebDriverWait waiter = new WebDriverWait(pageDriver, 20); // wait 10 seconds
		waiter.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]")));

		logoutButton.click();

		return new LoginPage(pageDriver);

	}

}

//public ProductsPage addToCart(String productName) {   залишаємося на цій самій сторінці - метод повертає сам себе
//	
//	
//	
//	return this;
//}