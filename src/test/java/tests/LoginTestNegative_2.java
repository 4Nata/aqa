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

	@Feature("Login without PASSWORD")
	@Story("PLH-449")
	@Test
	public void testUserIsNotAbleToLoginWithoutPassword() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("standard_user", "");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

	}

}
