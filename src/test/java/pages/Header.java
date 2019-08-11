package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;

public class Header extends AbstractBasePage {
	
	//private WebDriver pageDriver;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartIcon;
	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	private WebElement checkoutButton;
	
	public Header() {
		super();
//		this.pageDriver = WebApp.getBrowser();
//		PageFactory.initElements(pageDriver, this);
	}
		
 public CartPage clickMiniCart() {
	 shoppingCartIcon.click();
	//waitForAppear(checkoutButton);
	 return new CartPage();	
	}

}
