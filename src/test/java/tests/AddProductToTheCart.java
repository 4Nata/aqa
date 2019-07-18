package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddProductToTheCart extends GenericTest{
	
//	private WebDriver driver = null;

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
		
		//ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce");
		
		
		CartPage cartPage = openLoginPage().loginAs("standard_user", "secret_sauce").addProductToCart();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
		
		

	
	
	
	
	}
	
}
