package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsForm {
	private WebDriver driver; 

	public ContactUsForm(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}


	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement link; 

	@FindBy(xpath="//div[@class='menu-footer-menu-container']/ul/li[2]/a")
	private WebElement contactUsLink; 

	@FindBy(xpath="//*[@name='name' and @class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")
	private WebElement yourName; 

	@FindBy(xpath="//*[@name='email' and @class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")
	private WebElement yourEmail; 
	
	@FindBy(xpath="//*[@name='subject' and @class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")
	private WebElement yourSubject; 
	
	@FindBy(xpath="//*[@name='id:comments' and @class='wpcf7-form-control wpcf7-textarea wpcf7-validates-as-required']")
	private WebElement yourMessage; 
	
	@FindBy(xpath="//*[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement sendButton; 
	
	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(linkText="Log Out")
	private WebElement logOut; 
	
	@FindBy(id="user_pass")
	private WebElement password;



	@FindBy(name="login")
	private WebElement loginBtn; 

	public void linkSelect() {

		this.link.click();
		
	}

	public void yourNameTextBOx(String yourName) throws AWTException, InterruptedException 
	{
		Robot robot = new Robot(); 
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		this.yourName.clear();
		this.yourName.sendKeys(yourName);

	}

	public void yourEmailTextBOx(String yourEmail) 
	{

		this.yourEmail.clear();
		this.yourEmail.sendKeys(yourEmail);

	}
	
	public void yourSubjectTextBox(String yourSubject) 
	{

		this.yourSubject.clear();
		this.yourSubject.sendKeys(yourSubject);

	}
	
	public void yourMessageTextBox(String yourMessage) 
	{

		this.yourMessage.clear();
		this.yourMessage.sendKeys(yourMessage);

	}
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	
	}

	public void contactUsButtonSelect() throws AWTException, InterruptedException {
		
		this.contactUsLink.click();

	}

	public void SendBtn() {
		this.sendButton.click(); 
	
	}
	
}




