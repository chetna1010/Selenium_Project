package com.training.sanity.tests;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.training.pom.PlotsTests;
import com.training.pom.VillasTest;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_037_PlotsTests {


	private WebDriver driver;
	private String baseUrl;
	private VillasTest villasPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private LoginPOM loginPOM;
	private ContactUsForm contactPOM;
	private PlotsTests plotsPOM;
	private ApartmentTab_SearchButton searchPOM;
	
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
		villasPOM = new VillasTest(driver); 
		contactPOM = new ContactUsForm(driver); 
		searchPOM = new ApartmentTab_SearchButton(driver); 
		plotsPOM = new PlotsTests(driver); 
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
	public void plotsOptionTest() throws AWTException, InterruptedException {
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
		plotsPOM.plotsSelectTab();
		screenShot.captureScreenShot("Plots tab selected");
		searchPOM.your_Address("Electronic City, Bengaluru, Karnataka, India");
		searchPOM.dropdownSelect1();
		searchPOM.selectOption();
		searchPOM.Region();
		screenShot.captureScreenShot("Fill up the details");
		searchPOM.SearchButtonClick();
		
		Thread.sleep(5000);
		villasPOM.searchValueClass("Nullam hendrerit apartment");
		screenShot.captureScreenShot("Entered search criteria");
		Thread.sleep(4000);
		villasPOM.iconClickClass();
		Thread.sleep(5000);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,7500)");
		screenShot.captureScreenShot("select the contact option");
		contactPOM.contactUsButtonSelect();
		contactPOM.yourNameTextBOx("selenium");
		contactPOM.yourEmailTextBOx("selenium@gmail.com");
		contactPOM.yourSubjectTextBox("apartment");
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
















