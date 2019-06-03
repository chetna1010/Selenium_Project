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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ApartmentTab_Send;
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
		sendPOM.apartmentTab();
		screenShot.captureScreenShot("Mouse hover on Apartment Option");
		sendPOM.apartmentTaboptions();
		screenShot.captureScreenShot("All Apartment Tab options are present");
		sendPOM.donecQuisSearching();
		screenShot.captureScreenShot("DoneC Quis is present");
		sendPOM.donecQuisSelect();
		sendPOM.donecQuisOverviewTest();
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






