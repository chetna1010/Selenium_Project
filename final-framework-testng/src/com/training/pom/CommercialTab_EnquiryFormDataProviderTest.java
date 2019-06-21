package com.training.pom;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CommercialTab_EnquiryFormDataProviderTest {
	private WebDriver driver; 
	public CommercialTab_EnquiryFormDataProviderTest(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@name='your-name' and @class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")
	private WebElement yourName; 

	@FindBy(xpath="//*[@name='your-email' and @class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")
	private WebElement yourEmail; 

	@FindBy(xpath="//*[@name='your-subject' and @class='wpcf7-form-control wpcf7-text']")
	private WebElement yourSubject; 

	@FindBy(xpath="//textarea[@name='your-message' and @class='wpcf7-form-control wpcf7-textarea']")
	private WebElement yourMessage; 

	public void your_Name(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);           
	}
	
	public String getYour_Name()
	{
		return this.yourName.getAttribute("value");
	}

	public void your_Email(String yourEmail) {
		this.yourEmail.clear();
		this.yourEmail.sendKeys(yourEmail);
	}
	
	public String getYour_Email()
	{
		return this.yourEmail.getAttribute("value");
	}
	
	public void your_Subject(String yourSubject) {
		this.yourSubject.clear(); 
		this.yourSubject.sendKeys(yourSubject);
	}
	
	public String getYour_Subject()
	{
		return this.yourSubject.getAttribute("value");
	}

	public void sendMessage(String yourMessage) {
		this.yourMessage.clear();
		this.yourMessage.sendKeys(yourMessage);
	}

	public String getYour_Message()
	{
		return this.yourMessage.getAttribute("value");
	}
		
}



