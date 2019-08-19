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
		
	}

}
