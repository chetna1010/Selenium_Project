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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ApartmentTab_Send;
import com.training.pom.EnquiryForm_InvalidDetails;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007_ApartmentTab_SendButton {


	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ApartmentTab_Send sendPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private EnquiryForm_InvalidDetails enquiryPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		sendPOM = new ApartmentTab_Send(driver); 
		enquiryPOM= new EnquiryForm_InvalidDetails(driver);
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
	public void apartmentSearchButtonTest() throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); 

		loginPOM.linkSelect();		// linkselect() method will select the Log IN/Register Link
		screenShot.captureScreenShot("Log In Screen displayed");

		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));

		loginPOM.sendUserName("chetna");	//sendUserName() method will pass the use name in text box

		loginPOM.sendPassword("hello@4321");//sendPassword() method will pass the password in text box
		screenShot.captureScreenShot("Entering Credentials");

		loginPOM.clickLoginBtn(); //clickLoginBtn() method will click on SIGN IN button


		wait.until(ExpectedConditions.visibilityOf(loginPOM.myProfileClass())); 
		screenShot.captureScreenShot("Profile Screen displayed");

		//apartmentTaboptions() method will hit the arrow button untill prestige option is not visible
		enquiryPOM.commercialTab();
		screenShot.captureScreenShot("All Apartment Tab options are present");
		sendPOM.apartmentTaboptions();
		
		//prestigeOptionSelect() method will select the Prestige option
		sendPOM.PrestigeSelect();
		screenShot.captureScreenShot("select arrow button again");
		//your_Name()method will pass the input for Name text box
		sendPOM.your_Name("chetna");
		//your_Email() method will pass the input for email text box
		sendPOM.your_Email("chetna.gupta@in.ibm.com");
		//your_Subject()method will pass the input for subject text box
		sendPOM.your_Subject("apartment");
		screenShot.captureScreenShot("Fill up the details");
		//sendMessage() method pass the input for message text box
		sendPOM.sendMessage("looking for an apartments");
		screenShot.captureScreenShot("fill up the message ");
		//SendLoginBtn() method will clik on Send button
		sendPOM.SendLoginBtn();
		Thread.sleep(3000); 
		//This  will scroll down the page by  300 pixel vertical
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,300)");
		Thread.sleep(4000); 
		screenShot.captureScreenShot("Actual Result");
		
		String Expected="Thank you for your message. It has been sent";
		String Actual = sendPOM.afterMessageTest();
		assertEquals(Actual,Expected);
	}



} 




