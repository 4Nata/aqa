package Tools;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

	private WebDriver driver;

	public static final String BROWSER = "Chrome";

	public String getBrowserType() {
		String browser = System.getProperty("browser");

		if (browser == null) {

			return BROWSER;

		} else {

			return browser;
		}

	}

	public WebDriver getWebDriver() {

		if (driver != null) {

			return driver;
		} else {

			this.driver = createDriver();

			return driver;

		}
	}
	
	public void closeDriver() {
		
		try {
			if(driver != null) {
				driver.quit();
			}
		} finally {
			driver = null;
		}
	}

	public WebDriver createDriver() {

		String browserType = getBrowserType().toLowerCase();

		switch (browserType) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + getOsName() + File.separator + browserType + File.separator + "chromedriver");

			return new ChromeDriver();

		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + getOsName() + File.separator + browserType + File.separator + "geckodriver");
			return new FirefoxDriver();

		case "safari":
			if (getOsName().contains("windows") || getOsName().contains("linux")) {

				throw new IllegalStateException("You cannot  start the site on " + getOsName());
			}
//			System.setProperty("webdriver.safari.driver",
//					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOsName()
//							+ File.separator + BROWSER.toLowerCase() + File.separator + "Safari");
			return new SafariDriver();

		case "edge":

			if (getOsName().contains("macOS")) {

				throw new IllegalStateException("You cannot  start the site on " + getOsName());
			}
			System.setProperty("webdriver.msedgedriver.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOsName()
							+ File.separator + browserType + File.separator + "msedgedriver");

			return new EdgeDriver();

		default:
			throw new IllegalStateException("Unsupported browser");

		}

	}

	public String getOsName() {

		String osName = System.getProperty("os.name");

		if (osName.contains("Mac OS")) {

			return "macOS";
		} else if (osName.contains("Windows")) {

			return "windows";
		} else if (osName.contains("Linux")) {

			return "linux";
		} else {

			throw new IllegalStateException("Unknown OS name, please fix it");
		}
	}

}
