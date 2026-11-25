package com.tp.automationExercise.partice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tp.AutomationExercise.generic.basetest.BaseClass;
import com.tp.AutomationExercise.generic.listenerUtility.LinstenerImplementation;
import com.tp.AutomationExercise.objectRepository.ContactPage;
import com.tp.AutomationExercise.objectRepository.HomePage;

@Listeners(LinstenerImplementation.class)
public class ContatucUsTest extends BaseClass {

	@Test
	public void ContactUsForm() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactUsIcon().click();
		ContactPage cp = new ContactPage(driver);
		boolean getInTouchDisplayed = cp.getGetInTouch().isDisplayed();
		Assert.assertTrue(getInTouchDisplayed);
		cp.getName().sendKeys(elib.getDataFromExcel("Sheet1", 1, 2));
		cp.getEmail().sendKeys(elib.getDataFromExcel("Sheet1", 1, 3));
		cp.getSubject().sendKeys(elib.getDataFromExcel("Sheet1", 1, 4));
		cp.getMessage().sendKeys(elib.getDataFromExcel("Sheet1", 1, 5));
		cp.getUploadFile().sendKeys(jlib.getFilePath(elib.getDataFromExcel("Sheet1", 1, 6)));
		cp.getSubmit().submit();
		wlib.switchToAlertAndAccept(driver);
		Assert.assertTrue(cp.getSuccessMessage().isDisplayed());
		cp.getHomeIcon().click();
		wlib.waitForPageToLoad(driver);
		//Assert.assertTrue(hp.getCategoryTxt().isDisplayed());
		
	}
	
	
}
