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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ApartmentTab_Send;
import com.training.pom.ApartmentTab_CalculateButton;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008_ApartmentTab_CalculateButton {

	private WebDriver driver;
	private String baseUrl;
	private ApartmentTab_CalculateButton calculatePOM;
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
		calculatePOM = new ApartmentTab_CalculateButton(driver); 
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
	public void validCaculateButtonTest() throws AWTException, InterruptedException {
		calculatePOM.linkSelect();
		calculatePOM.sendUserName("chetna");
		calculatePOM.sendPassword("hello@4321");
		screenShot.captureScreenShot("First");
		calculatePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Second");
		calculatePOM.apartmentTabOptions();
		screenShot.captureScreenShot("Third");
		calculatePOM.salesPriceCalculate("400000");
		screenShot.captureScreenShot("Forth");
		calculatePOM.donwPaymenetCalculate("20000");
		screenShot.captureScreenShot("Fifth");
		calculatePOM.loanTermClass("20");
		screenShot.captureScreenShot("Sixth");
		calculatePOM.interestRateCalulator("7.25");
		screenShot.captureScreenShot("Seven");
		calculatePOM.calculateBtn();
		String Expected ="Monthly Payment: 3003.43 Rs.";
		Robot robot = new Robot(); 
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		String CB1 = driver.findElement(By.xpath("//div[@class='calc-output-container']/div[contains(text(),'Monthly Payment')]")).getText();
		Thread.sleep(3000);
		String Actual = CB1;
		System.out.println(Actual);
		Thread.sleep(1000);
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("Eight");
		
		
	}

	
	
	
	 
} 






