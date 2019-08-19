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

	@Feature("Login without USERNAME & PASSWORD")
	@Story("PLH-447")
	@Test

	public void testUserIsNotAbleToLoginWithoutUsernameAndPassword() {

		LoginPage loginPage = openLoginPage().testLoginCredentials("", "");

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

	}

}
