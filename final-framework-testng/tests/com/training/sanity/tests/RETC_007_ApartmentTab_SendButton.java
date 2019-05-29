package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ApartmentTab_Send;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007_ApartmentTab_SendButton {


	private WebDriver driver;
	private String baseUrl;
	private ApartmentTab_Send sendPOM;
	private static Properties properties;
	private ScreenShot screenShot;



	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		sendPOM = new ApartmentTab_Send(driver); 
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
	public void validSendButtonTest() throws AWTException, InterruptedException {
		sendPOM.linkSelect();
		sendPOM.sendUserName("chetna");
		sendPOM.sendPassword("hello@4321");
		screenShot.captureScreenShot("First");
		sendPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Second");
		sendPOM.apartmentTabOptions();
		screenShot.captureScreenShot("Third");
		sendPOM.your_Name("chetna");
		sendPOM.your_Email("chetnagupta00@gmail.com");
		sendPOM.your_Subject("apartment");
		sendPOM.sendMessage("looking for an apartments");
		screenShot.captureScreenShot("Forth");
		sendPOM.SendLoginBtn();
		
		String element= driver.findElement(By.xpath("//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		
		String Expected="Thank you for your message. It has been sent";
		String Actual = element;
		
		assertEquals(Actual,Expected);
		
		screenShot.captureScreenShot("Fifth");
		
		
	}
	
	
	 
} 




