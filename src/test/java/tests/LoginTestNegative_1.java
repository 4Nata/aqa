package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestNegative_1 {

	private WebDriver driver = null;

	@Test
	public void testUserIsNotAbleToLoginWithoutUsernameAndPassword() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

		SoftAssert soft = new SoftAssert();

		soft.assertTrue(error.isDisplayed());
		soft.assertEquals(error.getText(), "Epic sadface: Username is required");
		soft.assertAll();
//		driver.close();

	}

	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
	// (doesn't matter if they are failed or passed)
	public void closeBrowser() {

		driver.quit();
	}

}
