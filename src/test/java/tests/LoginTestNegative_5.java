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

public class LoginTestNegative_5 {

	private WebDriver driver = null;

	@Test

	public void testUserIsNotAbleToLoginIntoAppWithWrongCredentials() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("test_user");

		driver.findElement(By.id("password")).sendKeys("test_password");

		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

		

		Assert.assertTrue(error.isDisplayed());
		Assert.assertEquals(error.getText(), "Epic sadface: Username and password do not match any user in this service");
		

	}

	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
	// (doesn't matter if they are failed or passed)
	public void closeBrowser() {

		driver.quit();

	}

}
