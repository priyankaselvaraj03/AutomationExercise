package com.tp.AutomationExercise.generic.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tp.AutomationExercise.generic.fileUtility.ExcelUtility;
import com.tp.AutomationExercise.generic.fileUtility.FileUtility;
import com.tp.AutomationExercise.generic.webDriverUtility.JavaUtility;
import com.tp.AutomationExercise.generic.webDriverUtility.WebDriverUtility;


public class BaseClass {
	
	public WebDriver driver = null;
	public  static WebDriver sdriver=null;
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		System.out.println("----------Connect to DB-----------");
		
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configBC(@Optional("chrome") String browser) throws IOException {
		System.out.println("----------Lanuch Browser-------------");
		 browser = flib.getDataFromPropertiesFile("browser");
		
		//String broswer="chrome";
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		sdriver=driver;
		wlib.maximizeBrowser(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("-----------Login-----------");
		String url =flib.getDataFromPropertiesFile("url");
		String username=flib.getDataFromPropertiesFile("username");
		String password=flib.getDataFromPropertiesFile("password");
		driver.get(url);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() throws InterruptedException {
		System.out.println("---------Logout---------");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("------close the browser-------");
		driver.quit();
	}
	

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("--------close DB-----");
	}

	

}
