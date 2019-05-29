package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;


import com.training.pom.ApartmentTab_SearchButton;
import com.training.pom.ContactUsForm;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_010_ContactUsForm {

	private WebDriver driver;
	private String baseUrl;
	private ContactUsForm loginPOM1;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM1 = new ContactUsForm(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validSearchButtonTest() throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 180); 
		loginPOM1.linkSelect();
		screenShot.captureScreenShot("one");
		loginPOM1.sendUserName("chetna");
		loginPOM1.sendPassword("hello@4321");
		loginPOM1.clickLoginBtn(); 
		screenShot.captureScreenShot("two");
		Thread.sleep(1000);
		Robot robot = new Robot(); 
		Thread.sleep(4000); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000); 
		loginPOM1.contactUsButtonSelect();
		loginPOM1.yourNameTextBOx("chetna");
		loginPOM1.yourEmailTextBOx("chetna.gupta@in.ibm.com");
		loginPOM1.yourSubjectTextBox("apartments");
		loginPOM1.yourMessageTextBox("looking for an apartments");
		
		Thread.sleep(1000);
		
		screenShot.captureScreenShot("three");
		
		loginPOM1.SendBtn();
		Thread.sleep(1000);
		String result=driver.findElement(By.xpath("//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		String Expected ="Thank you for your message. It has been sent.";
		String Actual =  result;		
		assertEquals(Actual, Expected);	
		screenShot.captureScreenShot("Fifth");
		
		
		
	}
	
	
	 
} 














