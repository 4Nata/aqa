package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.WebApp;

public class WebElementUtils {
	
	public void waitAndClick(WebElement el) {
		
//		WebDriverWait wait = new WebDriverWait(WebApp.getBrowser(), 18); // Times Out after 18 Seconds
//	    PageUtil.refreshObject(WebApp.getBrowser(), By.linkText("Element")); // refresh the Element
//	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Element"))); // wait till  Element is Enabled and Visible before Clicking on that Element
//
//	    /**
//	    *Pass the Control to that Element and Click on that Element (preferred in IE)
//	    *
//	    */
//	    WebElement element = WebApp.getBrowser().findElement(By.linkText("Element"));
//	    element.sendKeys(org.openqa.selenium.Keys.CONTROL);
//	    element.click();
		
	
	
//	public static final long TIME_SECONDS_LIMIT = 30;
//	public static final long SLEEP_IN_MILLIS = 2000;
//
//
//	protected void clickAndWaitForAppear(WebElement currentElement WebElement expectedElement) {
//	   getDriverWait().until(ExpectedConditions.elementToBeClickable(currentElement));
//	   currentElement.click();
//	   getDriverWait().until(ExpectedConditions.visibilityOf(expectedElement);
//	}
//
//	private WebDriverWait getDriverWait() {
//	   return new WebDriverWait(getDriver(), TIME_SECONDS_LIMIT, SLEEP_IN_MILLIS);
//	}------------------------------------------------------------------------------------------------------------- (edited) 
//	
//	@Step(“Click [Logout] button to logout from the app”)
//	   public LoginPage logout() {
//
//	      clickAndWaitForAppear(menuButton,logoutButton);
//	      clickAndWaitForAppear(logoutButton,LoginPageLocator);
//	       return new LoginPage();
//
//	   }
//
//}
		
	}
}
