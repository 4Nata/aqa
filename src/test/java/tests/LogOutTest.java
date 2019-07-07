package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogOutTest {

	private WebDriver driver = null;

	@Test // annotation which shows TestNG that this is a test described below

	public void testUserIsAbleToLogOutFromTheApp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		this.driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		driver.findElement(By.cssSelector("div.bm-burger-button button")).click();
		
		WebElement element = driver.findElement(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 


		driver.findElement(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]")).click();

//				driver.findElement(By.cssSelector("a[id='logout_sidebar_link']")).click();
//              driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
//				driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

//		driver.findElement(By.xpath("//a[@href='./index.html']")).click();

		WebElement loginButton = driver.findElement(By.cssSelector("input[value='LOGIN'"));

		SoftAssert soft = new SoftAssert();

		soft.assertTrue(loginButton.isDisplayed());
		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/index.html"), "Current URL is - "
				+ driver.getCurrentUrl() + ". But the expected URL should be - https://www.saucedemo.com/index.html");

		soft.assertAll();

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
