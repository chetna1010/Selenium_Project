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
import com.training.pom.AddPost_CreatedCategory;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_039_AddPost_CreatedCategory {


	private WebDriver driver;
	private String baseUrl;
	private AddPost_CreatedCategory addPostPOM;
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
		addPostPOM = new AddPost_CreatedCategory(driver); 
		
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
	public void addPostTest() throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); // launch the Application
		loginPOM.linkSelect();
		screenShot.captureScreenShot("Log In Screen displayed");
		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("Entering Credentials");
		loginPOM.clickLoginBtn(); 
		 
		screenShot.captureScreenShot("Profile Screen displayed");
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.dashboardVisibility())); 
		addPostPOM.postsLinkClick();
		Thread.sleep(1000);
		addPostPOM.categoryLinkClick();
		Thread.sleep(1000);
		addPostPOM.categoryNameText("Testing Category1");
		addPostPOM.slugText("Testing Category slug");
		addPostPOM.descriptionText("Testing Category slug description");
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.addNewCategoryVisibility()));
		addPostPOM.addNewCategory();
		addPostPOM.addNewCategoryLinkClass();
		addPostPOM.postTitleClass("New Title");
		addPostPOM.editorAreaClass("New Title editor area");
		addPostPOM.chooseCategoryClass();
		Thread.sleep(1000);
		addPostPOM.publishButton();
		Thread.sleep(7000);
		String Expected ="Post published. View post";
		String postPublishedMessage=driver.findElement(By.xpath("//*[@id='message' and @class='updated notice notice-success is-dismissible']/p")).getText();
		String Actual =  postPublishedMessage;	
		System.out.println(Actual);
		Thread.sleep(3000);
		
		assertEquals(Actual, Expected);	
		screenShot.captureScreenShot("Fifth");
		}



} 
















