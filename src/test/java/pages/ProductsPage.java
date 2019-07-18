package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	@FindBy(xpath = "//button[contains(text(), 'ADD TO CART')]")
	private WebElement addToCartButton;
	
	public CartPage addProductToCart() {
		
		addToCartButton.click();
		return new CartPage(pageDriver);
	}
	
	

}



//public ProductsPage addToCart(String productName) {   залишаємося на цій самій сторінці - метод повертає сам себе
//	
//	
//	
//	return this;
//}