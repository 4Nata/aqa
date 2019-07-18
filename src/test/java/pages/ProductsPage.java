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
	
	@FindBy(id = "#shopping_cart_container")
	private WebElement shoppingCartContainer;
	
    @FindBy(css = "div.bm-burger-button button")
    private WebElement menuButton;
    
    @FindBy(xpath = "//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;
    
    
	
	
	public CartPage addProductToCart() {
		
		addToCartButton.click();
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