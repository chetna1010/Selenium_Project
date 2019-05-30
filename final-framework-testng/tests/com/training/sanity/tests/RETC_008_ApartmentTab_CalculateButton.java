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
		screenShot.captureScreenShot("Log In Screen displayed");
		calculatePOM.sendUserName("chetna");
		calculatePOM.sendPassword("hello@4321");
		screenShot.captureScreenShot("Entering Credentials");
		
		calculatePOM.clickLoginBtn(); 
		Thread.sleep(3000);
		screenShot.captureScreenShot("Profile Screen displayed");
		calculatePOM.apartmentTab();
		screenShot.captureScreenShot("Mouse hover on Apartment Option");
		calculatePOM.apartmentTaboptions();
		screenShot.captureScreenShot("All Apartment Tab options are present");
		calculatePOM.donecQuisSearching();
		screenShot.captureScreenShot("DoneC Quis is present");
		calculatePOM.donecQuisSelect();
		
		calculatePOM.donecQuisOverviewTest();
		screenShot.captureScreenShot("select arrow button again");
		
		calculatePOM.salesPriceCalculate("400000");
	
		calculatePOM.donwPaymenetCalculate("20000");
		screenShot.captureScreenShot("Fill up the details for sales price and down payment");
		calculatePOM.loanTermClass("20");
		screenShot.captureScreenShot("Fill up the details");
		calculatePOM.interestRateCalulator("7.25");
		screenShot.captureScreenShot("Fill up InterestRate");
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
		screenShot.captureScreenShot("Actual result");
		
		
	}

	
	
	
	 
} 






