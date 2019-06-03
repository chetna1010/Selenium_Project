package com.training.sanity.tests;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_010_ContactUsForm {

	private WebDriver driver;
	private String baseUrl;
	private ContactUsForm contactPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private LoginPOM loginPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		contactPOM = new ContactUsForm(driver); 
		loginPOM = new LoginPOM(driver); 
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
	public void contactUsFormTest() throws AWTException, InterruptedException {
		
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); // launch the Application
		loginPOM.linkSelect();
		screenShot.captureScreenShot("Log In Screen displayed");
		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));
		loginPOM.sendUserName("chetna");
		loginPOM.sendPassword("hello@4321");
		screenShot.captureScreenShot("Entering Credentials");
		loginPOM.clickLoginBtn(); 
		wait.until(ExpectedConditions.visibilityOf(loginPOM.myProfileClass())); 
		screenShot.captureScreenShot("Profile Screen displayed");
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		 
		jse1.executeScript("window.scrollBy(0,2000)");
		screenShot.captureScreenShot("Bottom of the page");
		Thread.sleep(5000);
		contactPOM.contactUsButtonSelect();
		screenShot.captureScreenShot("Contact Form displayed");
		contactPOM.yourNameTextBOx("chetna");
		contactPOM.yourEmailTextBOx("chetna.gupta@in.ibm.com");
		contactPOM.yourSubjectTextBox("apartments");
		screenShot.captureScreenShot("Fill up the details");
		contactPOM.yourMessageTextBox("looking for an apartments");
		screenShot.captureScreenShot("Fill up Message");
		contactPOM.SendBtn();
		Thread.sleep(3000); 
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000); 
		screenShot.captureScreenShot("Actual Result");
		String result=driver.findElement(By.xpath("//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		String Expected ="Thank you for your message. It has been sent.";
		String Actual =  result;		
		assertEquals(Actual, Expected);	
		screenShot.captureScreenShot("Fifth");
	}
	
	
	 
} 














