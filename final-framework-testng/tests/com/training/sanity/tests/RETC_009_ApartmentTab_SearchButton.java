package com.training.sanity.tests;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009_ApartmentTab_SearchButton {

	private WebDriver driver;
	private String baseUrl;
	private ApartmentTab_SearchButton searchPOM;
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
		loginPOM = new LoginPOM(driver); 
		searchPOM = new ApartmentTab_SearchButton(driver); 
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
		searchPOM.apartmentSelectTab();
		screenShot.captureScreenShot("Map is getting displayed ");
		Thread.sleep(7000);
		String yourMap = driver.findElement(By.linkText("Donec quis")).getText();
		String Expected="Donec quis";
		String Actual=yourMap;
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("Find Your Home screen displayed ");
		Thread.sleep(1000);
		searchPOM.your_Address("Electronic City, Bengaluru, Karnataka, India");
		searchPOM.dropdownSelect1();
		searchPOM.selectOption();
		searchPOM.Region();
		screenShot.captureScreenShot("Fill up the details");
		searchPOM.SearchButtonClick();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Nothing Found");
		String result=driver.findElement(By.xpath("//*[@class='no-results not-found']/header[@class='page-header']/h1[@class='page-title']")).getText();
		String Expected1 ="Records are Matching";
		String Actual1 =  result;		
		assertEquals(Actual1, Expected1);	
		
	}
	
	
	 
} 










