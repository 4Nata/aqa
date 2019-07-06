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
import org.testng.reporters.jq.Main;

public class LoginTest {

	private WebDriver driver = null;

	@Test // annotation which shows TestNG that this is a test described below

	public void testUserIsAbleToLoginIntoApp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		this.driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		WebElement el = driver.findElement(By.id("shopping_cart_container"));

//		String currentURL = driver.getCurrentUrl();
//
//		if (currentURL.equals("https://www.saucedemo.com/inventory.html")) {
//			System.out.println(currentURL + " - " + "User is successfully logged in");
//
//		}

		SoftAssert soft = new SoftAssert();

//		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
//		Assert.assertTrue(el.isDisplayed()); checked 1 by 1, if 1st assert is failed - the 2nd one won't be checked at all

//		soft.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html"); 1st method and below 2nd method:
		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
				"Current URL after login should be 'https://www.saucedemo.com/inventory.html', " + "but fould ["
						+ driver.getCurrentUrl() + "]");
		soft.assertTrue(el.isDisplayed());
		soft.assertAll(); // checked all asserts even when 1st one is failed, the next one still will be
							// checked

//		driver.close();
	}

	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
	// (doesn't matter if they are failed or passed)
	public void closeBrowser() {

		driver.quit();

	}

}
