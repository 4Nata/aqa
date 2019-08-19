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

public class LoginTestNegative_5 extends GenericTest {

	@Feature("Login with WRONG CREDENTIALS")
	@Story("PLH-449")
	@Test

	public void testUserIsNotAbleToLoginIntoAppWithWrongCredentials() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("test_user", "test_password");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");

	}

}
