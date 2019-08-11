package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import Tools.AllureReporter;
import app.WebApp;
import io.qameta.allure.Step;
import pages.LoginPage;

public class GenericTest {

//	public WebDriver driver = null;
//
//	public static final String BROWSER = "Chrome";

	// method which check that if we have variable in Maven - take this variable

//	public String getBrowserType() {
//		String browser = System.getProperty("browser");
//
//		if (browser == null) {
//
//			return BROWSER;
//
//		} else {
//
//			return browser;
//		}
//
//	}

//	public WebDriver getBrowser() {
//
//		String browserType = getBrowserType().toLowerCase();
//
//		switch (browserType) {
//
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
//					+ File.separator + getOsName() + File.separator + browserType + File.separator + "chromedriver");
//
//			return new ChromeDriver();
//
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
//					+ File.separator + getOsName() + File.separator + browserType + File.separator + "geckodriver");
//			return new FirefoxDriver();
//
//		case "safari":
//			if (getOsName().contains("windows") || getOsName().contains("linux")) {
//
//				throw new IllegalStateException("You cannot  start the site on " + getOsName());
//			}
////			System.setProperty("webdriver.safari.driver",
//					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOsName()
//							+ File.separator + BROWSER.toLowerCase() + File.separator + "Safari");
//			return new SafariDriver();
//
//		case "edge":
//
//			if (getOsName().contains("macOS")) {
//
//				throw new IllegalStateException("You cannot  start the site on " + getOsName());
//			}
//			System.setProperty("webdriver.msedgedriver.driver",
//					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOsName()
//							+ File.separator + browserType + File.separator + "msedgedriver");
//
//			return new EdgeDriver();
//
//		default:
//			throw new IllegalStateException("Unsupported browser");
//
//		}
//
//	}
//
//	public String getOsName() {
//
//		String osName = System.getProperty("os.name");
//
//		if (osName.contains("Mac OS")) {
//
//			return "macOS";
//		} else if (osName.contains("Windows")) {
//
//			return "windows";
//		} else if (osName.contains("Linux")) {
//
//			return "linux";
//		} else {
//
//			throw new IllegalStateException("Unknown OS name, please fix it");
//		}
//	}

//	@Step("Get Driver")
//	@BeforeClass
//	public void getDriver() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

//		this.driver = new ChromeDriver();

//		this.driver = getBrowser();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("https://www.saucedemo.com");
//	}

	@Step("Open Login page")
	public LoginPage openLoginPage() {

		WebDriver driver  = WebApp.getBrowser();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com");

		return new LoginPage();
	}
	
	

	@Step 
	@AfterClass(alwaysRun = true) // AlwaysRun annotation occurs after all tests are finished in this class
	// (doesn't matter if they are failed or passed)
	public void closeApp() {

		WebApp.closeBrowser();
		

	}

//	public static void main(String[] args) {
//		System.out.println(System.getProperty("os.name"));
//	}

	@AfterMethod
	public void attachScreenshot() {
		
		AllureReporter.makeScreenshot("Screen");
	}
}
