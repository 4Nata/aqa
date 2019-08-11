package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.LoginPage;

public class LogOutTest extends GenericTest {

@Feature("Is user able to LOGOUT from the app")
@Story("787")
	@Test // annotation which shows TestNG that this is a test described below

	// throws InterruptedException

	public void testUserIsAbleToLogOutFromTheApp() {

		LoginPage loginPage = openLoginPage().loginAs("standard_user", "secret_sauce").logout();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed());

	}

}

//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//
//		this.driver = new ChromeDriver();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("https://www.saucedemo.com");
//
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
//
//		driver.findElement(By.cssSelector("div.bm-burger-button button")).click();
//		
//		try {
//			Thread.sleep(1000);  // wait 1 sec before do smth
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

// ExplicityWait wait 10 sec until it is clickable and then click

//		WebDriverWait waiter = new WebDriverWait(driver, 10); // wait 10 seconds    
//		waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]")));

//		WebElement element = driver.findElement(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500); 

//		driver.findElement(By.xpath("//nav[@class='bm-item-list']//a[contains(text(), 'Logout')]")).click();

//				driver.findElement(By.cssSelector("a[id='logout_sidebar_link']")).click();
//              driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
//				driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

//		driver.findElement(By.xpath("//a[@href='./index.html']")).click();

//		//WebElement loginButton = driver.findElement(By.cssSelector("input[value='LOGIN'"));
//
//		//SoftAssert soft = new SoftAssert();
//
//		soft.assertTrue(loginButton.isDisplayed());
//		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/index.html"), "Current URL is - "
//				+ driver.getCurrentUrl() + ". But the expected URL should be - https://www.saucedemo.com/index.html");
//
//		soft.assertAll();
//
//	}
