package com.training.sanity.tests;



import static org.testng.Assert.assertEquals;

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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_006_LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
	public void validLoginTest() throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); 
 
		loginPOM.linkSelect();// linkselect() method will select the Log IN/Register Link
		screenShot.captureScreenShot("Log In Screen displayed");
		
		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));
	
		loginPOM.sendUserName("chetna");	//sendUserName() method will pass the use name in text box
		
		loginPOM.sendPassword("hello@4321");//sendPassword() method will pass the password in text box
		screenShot.captureScreenShot("Entering Credentials");
		
		loginPOM.clickLoginBtn(); //clickLoginBtn() method will click on SIGN IN button
		wait.until(ExpectedConditions.visibilityOf(loginPOM.myProfileClass()));
		String ExpectedProfilePage= "My Profile";
		String profilePage=driver.findElement(By.xpath("//div[@class='col-md-12']/h2")).getText();
		String ActualProfilePage=loginPOM.myProfileMessageTest();
		
		assertEquals(ActualProfilePage, ExpectedProfilePage);
		screenShot.captureScreenShot("My Profile Page is displayed");
		loginPOM.linkMouseHover();
		String ExpectedLogInScreen= "Log In";
		
		String ActualLoginScreen=loginPOM.logInPageMessageTest();
		Thread.sleep(2000);
		assertEquals(ActualLoginScreen, ExpectedLogInScreen);
		screenShot.captureScreenShot("Back to LogIn screen after Logout");
		
	}
}
