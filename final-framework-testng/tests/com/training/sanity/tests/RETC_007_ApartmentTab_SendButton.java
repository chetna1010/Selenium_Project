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
//		Thread.sleep(1000);
		sendPOM.linkSelect();
		screenShot.captureScreenShot("Log In Screen displayed");
		sendPOM.sendUserName("chetna");
		sendPOM.sendPassword("hello@4321");
		screenShot.captureScreenShot("Entering Credentials");
		
		sendPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		screenShot.captureScreenShot("Profile Screen displayed");
		sendPOM.apartmentTab();
		screenShot.captureScreenShot("Mouse hover on Apartment Option");
		sendPOM.apartmentTaboptions();
		screenShot.captureScreenShot("All Apartment Tab options are present");
		sendPOM.donecQuisSearching();
		screenShot.captureScreenShot("DoneC Quis is present");
		sendPOM.donecQuisSelect();
		
		sendPOM.donecQuisOverviewTest();
		screenShot.captureScreenShot("select arrow button again");
		sendPOM.your_Name("chetna");
		sendPOM.your_Email("chetnagupta00@gmail.com");
		sendPOM.your_Subject("apartment");
		screenShot.captureScreenShot("Fill up the details");
		sendPOM.sendMessage("looking for an apartments");
		screenShot.captureScreenShot("fill up the message ");
		sendPOM.SendLoginBtn();
		Thread.sleep(3000); 
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000); 
		screenShot.captureScreenShot("Actual Result");
		
		String element= driver.findElement(By.xpath("//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		
		String Expected="Thank you for your message. It has been sent";
		String Actual = element;
		
		assertEquals(Actual,Expected);
		
	
		
		
	}
	
	
	 
} 




