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

import pages.LoginPage;

public class LoginTestNegative_5 extends GenericTest{

//	private WebDriver driver = null;

	@Test

	public void testUserIsNotAbleToLoginIntoAppWithWrongCredentials() {
//
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		driver = new ChromeDriver();
//
//		driver.get("https://www.saucedemo.com");
//
//		driver.findElement(By.id("user-name")).sendKeys("test_user");
//
//		driver.findElement(By.id("password")).sendKeys("test_password");
//
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//
//		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
//
//		
//
//		Assert.assertTrue(error.isDisplayed());
//		Assert.assertEquals(error.getText(), "Epic sadface: Username and password do not match any user in this service");
//		
		openLoginPage();
		
		LoginPage.lockedAndNonExistedUserLoginIn("test_user", "test_password");
		
		Assert.assertTrue(LoginPage.errorMessageWithoutLoginAndPassword.isDisplayed());
		Assert.assertEquals(LoginPage.errorMessageWithoutLoginAndPassword.getText(), "Epic sadface: Username and password do not match any user in this service");

	}

	
}
