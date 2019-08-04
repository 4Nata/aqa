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

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LoginTestNegative_4 extends GenericTest {

//	private WebDriver driver = null;

	

	@Feature("Login as LOCKED user")
	@Story("PLH-447")
	@Test
	public void testLockedUserIsNotAbleToLogin() {

//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		this.driver = new ChromeDriver();
//
//		driver.get("https://www.saucedemo.com");
//		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//
//		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
//
//		
//		Assert.assertTrue(error.isDisplayed());
//		Assert.assertEquals(error.getText(), "Epic sadface: Sorry, this user has been locked out.");
//		
//		driver.close();

		

		LoginPage loginWithLockedUser = openLoginPage().testLoginCredentials("locked_out_user", "secret_sauce");

		Assert.assertTrue(loginWithLockedUser.errorMessageWithoutLoginAndPassword.isDisplayed());
		Assert.assertEquals(loginWithLockedUser.errorMessageWithoutLoginAndPassword.getText(),
				"Epic sadface: Sorry, this user has been locked out.");
	}

}
