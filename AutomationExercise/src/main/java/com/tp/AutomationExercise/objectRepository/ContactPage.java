package com.tp.AutomationExercise.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement getInTouch;
	
	@FindBy(name = "name")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="message")
	private WebElement message;
	
	@FindBy(name="upload_file")
	private WebElement uploadFile;
	
	@FindBy(name="submit")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='status alert alert-success']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement homeIcon;
	

	public WebElement getGetInTouch() {
		return getInTouch;
	}


	public WebElement getName() {
		return name;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getSubject() {
		return subject;
	}


	public WebElement getMessage() {
		return message;
	}


	public WebElement getUploadFile() {
		return uploadFile;
	}


	public WebElement getSubmit() {
		return submit;
	}


	public WebElement getSuccessMessage() {
		return successMessage;
	}


	public WebElement getHomeIcon() {
		return homeIcon;
	}
	
	
	
	
	
}
