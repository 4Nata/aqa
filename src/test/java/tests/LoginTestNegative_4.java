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

	@Feature("Login as LOCKED user")
	@Story("PLH-447")
	@Test
	public void testLockedUserIsNotAbleToLogin() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("locked_out_user", "secret_sauce");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
	}

}
