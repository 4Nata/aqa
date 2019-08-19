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

import com.google.common.collect.Ordering;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends GenericTest { 

	@Feature("Login")
	@Story("PLH-444")

	@Test

	public void testUserIsAbleToLoginIntoApp() {

		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce");

		Assert.assertTrue(productsPage.isUserLoggedIn(), "User should be logged into app after entering valid creds");

	}

}
