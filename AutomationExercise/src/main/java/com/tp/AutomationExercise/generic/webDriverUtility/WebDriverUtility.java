package com.tp.AutomationExercise.generic.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> i = windowIds.iterator();
		while(i.hasNext()) {
			String winId = i.next();
			driver.switchTo().window(winId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTiltle) {
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> i = windowIds.iterator();
		while(i.hasNext()) {
			String winId = i.next();
			driver.switchTo().window(winId);
			String actUrl=driver.getTitle();
			if(actUrl.contains(partialTiltle)) {
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String switchToAlertAndGetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	public void select(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void pageRefersh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public List<WebElement> getAllDropDownOption(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> allOption = sel.getOptions();
		return allOption;
	}

}
