package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import app.WebApp;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CartPage;

public class AddProductToTheCart extends GenericTest {

//	private WebDriver driver = null;
	
	
@Feature("Adding Products To The Cart")
@Story("PLH-441")
	@Test // annotation which shows TestNG that this is a test described below

	public void testUserIsAbleToAddProductToCart() {
////
////		System.setProperty("webdriver.chrome.driver",
////				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
////
////		this.driver = new ChromeDriver();
////		
////		driver.get("https://www.saucedemo.com/inventory.html");
////		driver.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]")).click();
////		
////		WebElement productOnCartIcon = driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(), '1')]"));
////		
////        
////        
////        Assert.assertTrue(productOnCartIcon.isDisplayed());
//

		// ProductsPage productsPage = openLoginPage().loginAs("standard_user",
		// "secret_sauce");

//		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart();

		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)").header.openCart();

		Assert.assertEquals(WebApp.getBrowser().getCurrentUrl(), "https://www.saucedemo.com/cart.html");

	}

}
