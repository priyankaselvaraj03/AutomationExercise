package com.tp.automationExercise.partice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void method1() {
		WebDriver driver = null;
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(url);
	}

}
