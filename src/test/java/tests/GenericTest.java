package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import app.WebApp;
import io.qameta.allure.Step;
import pages.LoginPage;
import tools.AllureReporter;

public class GenericTest {

	@Step("Open Login page")
	public LoginPage openLoginPage() {

		WebDriver driver = WebApp.getBrowser();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com");

		return new LoginPage();
	}

	@Step
	@AfterClass(alwaysRun = true)
	public void closeApp() {

		WebApp.closeBrowser();

	}

	@AfterMethod
	public void attachScreenshot() {

		AllureReporter.makeScreenshot("Screen");
	}
}
