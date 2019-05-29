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

public class LoginPOM {
	private WebDriver driver; 

	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}


	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement link; 

	@FindBy(xpath="//*[@id='header']/div[2]/div/div/div")
	private WebElement link1; 

	@FindBy(linkText="Real Estate")
	private WebElement homeScreen; 

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

	public void linkMouseHover() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(link1).build().perform();
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		builder.moveToElement(logOut).build().perform();
		builder.moveToElement(logOut).click().build().perform();

		

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

	public void selectHomeTab() {
		this.homeScreen.click();

	}

	
	
}
