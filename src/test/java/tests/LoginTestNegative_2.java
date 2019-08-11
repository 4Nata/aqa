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

public class LoginTestNegative_2 extends GenericTest {

//	private WebDriver driver = null;

	

	@Feature("Login without PASSWORD")
	@Story("PLH-449")
	@Test
	public void testUserIsNotAbleToLoginWithoutPassword() {

//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		this.driver = new ChromeDriver();
//
//		driver.get("https://www.saucedemo.com");
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//
//		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
//
//		
//
//		Assert.assertTrue(error.isDisplayed());
//		Assert.assertEquals(error.getText(), "Epic sadface: Password is required");
//		
//		driver.close();
		
		
		
		LoginPage loginPage = openLoginPage().testLoginCredentials("standard_user", "");
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Password is required");

	}
	
	

}
