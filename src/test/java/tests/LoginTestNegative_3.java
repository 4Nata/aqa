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

public class LoginTestNegative_3 extends GenericTest {

//	private WebDriver driver = null;

	@Test
	public void testUserIsNotAbleToLoginWithoutUsername() {

//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		this.driver = new ChromeDriver();
//
//		driver.get("https://www.saucedemo.com");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//
//		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
//
//		
//
//		Assert.assertTrue(error.isDisplayed());
//		Assert.assertEquals(error.getText(), "Epic sadface: Username is required");
//		
//		driver.close();

		

		LoginPage loginWithoutUsername = openLoginPage().testLoginCredentials("" , "secret_sauce");

		Assert.assertTrue(loginWithoutUsername.errorMessageWithoutLoginAndPassword.isDisplayed());
		Assert.assertEquals(loginWithoutUsername.errorMessageWithoutLoginAndPassword.getText(),
				"Epic sadface: Username is required");

	}

}
