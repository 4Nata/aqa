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

public class LoginTestNegative_1 extends GenericTest {

//	private WebDriver driver = null;

	
	@Feature("Login without USERNAME & PASSWORD")
	@Story("PLH-447")
	@Test
	
	public void testUserIsNotAbleToLoginWithoutUsernameAndPassword() {

//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		driver = new ChromeDriver();
//
//		driver.get("https://www.saucedemo.com");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
//
//
//		Assert.assertTrue(error.isDisplayed());
//
//		Assert.assertEquals(error.getText(), "Epic sadface: Username is required");
//		
//		driver.close();

		LoginPage loginPage = openLoginPage().testLoginCredentials("","");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Username is required");

	}

//	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
//	// (doesn't matter if they are failed or passed)
//	public void closeBrowser() {
//
//		driver.quit();
//	}

}
