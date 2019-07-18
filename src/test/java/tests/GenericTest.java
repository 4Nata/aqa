package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;

public class GenericTest {

	public WebDriver driver = null;

//	@BeforeClass
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com");
	}

	public LoginPage openLoginPage() {

		getDriver();

		return new LoginPage(driver);
	}

	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
	// (doesn't matter if they are failed or passed)
	public void closeBrowser() {

		driver.quit();

	}

}
