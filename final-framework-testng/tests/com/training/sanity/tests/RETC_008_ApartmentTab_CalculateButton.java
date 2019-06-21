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
import com.training.pom.ApartmentTab_CalculateButton;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008_ApartmentTab_CalculateButton {

	private WebDriver driver;
	private String baseUrl;
	private ApartmentTab_CalculateButton calculatePOM;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private EnquiryForm_InvalidDetails enquiryPOM;
	private ApartmentTab_Send sendPOM;

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
		calculatePOM = new ApartmentTab_CalculateButton(driver); 
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

		enquiryPOM.commercialTab();
		screenShot.captureScreenShot("All Apartment Tab options are present");
		sendPOM.apartmentTaboptions();
		
		//prestigeSelect() method will select the Prestige option
		sendPOM.PrestigeSelect();
		
		screenShot.captureScreenShot("select arrow button again");
		//salesPriceCalculate() method will provide the input for sales price text box
		calculatePOM.salesPriceCalculate("400000");
		//donwPaymenetCalculate() method will provide the input for down payment text box
		calculatePOM.donwPaymenetCalculate("20000");
		screenShot.captureScreenShot("Fill up the details for sales price and down payment");
		//loanTermClass() method will provide the input for long term text box
		calculatePOM.loanTermClass("20");
		screenShot.captureScreenShot("Fill up the details");
		
		//interestRateCalulator() method will provide the input for interest rate text box
		calculatePOM.interestRateCalulator("7.25");
		screenShot.captureScreenShot("Fill up InterestRate");
		//calculateBtn() method will click on the calculate button
		calculatePOM.calculateBtn();
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		 
		jse1.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		String Expected ="Monthly Payment: 3003.43 Rs.";
		String Actual = calculatePOM.monthlyPaymentMsgTest();
		
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("Actual result");	
		
	}

	
	
	
	 
} 






