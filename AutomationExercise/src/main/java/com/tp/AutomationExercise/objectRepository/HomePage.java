package com.tp.AutomationExercise.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@href='/contact_us']")
	private WebElement contactUsIcon;
	
	@FindBy(xpath = "//h2[text()='Category']")
	private WebElement categoryTxt;

	public WebElement getContactUsIcon() {
		return contactUsIcon;
	}

	public WebElement getCategoryTxt() {
		return categoryTxt;
	}
	
	

}
