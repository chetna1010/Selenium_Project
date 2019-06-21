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

import com.training.dataproviders.AdminPropertyDataProvider;
import com.training.dataproviders.CalculateMortgageDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.AddPost_CreatedCategory;
import com.training.pom.AdminPropertyHomeScreen;
import com.training.pom.LoginPOM;
import com.training.pom.VillasTest;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class AdminProperty_HomeScreen_RETC_070 {


	private WebDriver driver;
	private String adminUrl;
	private AddPost_CreatedCategory addPostPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private LoginPOM loginPOM;
	private AdminPropertyHomeScreen adminPOM;
	private VillasTest villasPOM;

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
		adminPOM= new AdminPropertyHomeScreen(driver);
		addPostPOM = new AddPost_CreatedCategory(driver); 
		villasPOM = new VillasTest(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1" ,dataProviderClass=AdminPropertyDataProvider.class)
	//To verify whether application allows admin to create property details based on the Feature created & added property get displayed on home screen for user
	public void addPropertyTest(String name, String slugText, String description, String title, String editorText) throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); 

		loginPOM.linkSelect();		// linkselect() method will select the Log IN/Register Link
		screenShot.captureScreenShot("Log In Screen displayed");

		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));

		loginPOM.sendUserName("admin");	//sendUserName() method will pass the use name in text box


		loginPOM.sendPassword("admin@123");//sendPassword() method will pass the password in text box
		screenShot.captureScreenShot("Entering Credentials");


		loginPOM.clickLoginBtn(); //clickLoginBtn() method will click on SIGN IN button

		screenShot.captureScreenShot("Profile Screen displayed");
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.dashboardVisibility())); 

		wait.until(ExpectedConditions.visibilityOf(adminPOM.propertyLinkClickVisibility())); 
		adminPOM.propertyLinkClick();//propertyLinkClick() method will select the Property Link
		Thread.sleep(1000);
		screenShot.captureScreenShot("POST Link Selected");

		adminPOM.featureLinkClick();//featureLinkClick() method will select the CATEGORY Link
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.categoryNameTextVisibility())); 


		addPostPOM.categoryNameText(name);//categoryNameText() method will pass the  Name in text box field


		addPostPOM.slugText(slugText);	//slugText() method will pass the SLUG Name in text box field
		screenShot.captureScreenShot("Fill up the Name and Slug");

		addPostPOM.descriptionText(description);//descriptionText() method will pass the DESCRIPTON in text box field	slugText
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		screenShot.captureScreenShot("Fill up the description");
		wait.until(ExpectedConditions.visibilityOf(adminPOM.addNewFeatureVisibility()));


		adminPOM.addNewFeature();//addNewFeature() method will click on the ADD New Feature Button
		wait.until(ExpectedConditions.visibilityOf(adminPOM.propertyLinkSelectVisibility())); 

		adminPOM.propertyLinkSelectClass();		//propertyLinkSelectClass() method will click on the Properties 
		wait.until(ExpectedConditions.visibilityOf(adminPOM.addNewPropertiesLinkClassVisibility())); 


		adminPOM.addNewPropertiesLinkClass();//addNewPropertiesLinkClass() method will click on the Add New Property page 


		addPostPOM.postTitleClass(title);//postTitleClass() method will pass the TITTLE name


		addPostPOM.editorAreaClass(editorText);//editorAreaClass() method will pass the text into EDITOR area
		screenShot.captureScreenShot("Fill up the Title details");

		//	adminPOM.featureArrowButtonClass();	//featureArrowButtonClass() method will click the arrow button


		wait.until(ExpectedConditions.visibilityOf(adminPOM.chooseFeatureClassVisibility()));
		adminPOM.chooseFeatureClass();//chooseFeatureClass() method will Click on Checkbox beside created feature name of feature section 

		wait.until(ExpectedConditions.visibilityOf(addPostPOM.publishButtonVisibility())); 


		addPostPOM.publishButton();//publishButton() method will PUBLISH the ADD
		Thread.sleep(7000);
		screenShot.captureScreenShot("POST Published");
		// Adding Assertion to valdiate wheather Post published. View post message displayed or not
		String Expected ="Post published. View post";

		String Actual =  addPostPOM.postPublishMessageClass();	
		System.out.println(Actual);
		assertEquals(Actual, Expected);	

		adminPOM.logOUTClick();// logOUTClick() method will do mouse hovar on username
		adminPOM.logOUTSelect();//logOUTSelect() method will click on Log OUt option
		wait.until(ExpectedConditions.visibilityOf(loginPOM.myProfileClass()));
		adminPOM.realStateICONClick();//realStateICONClick() method will select the Real STate Icon
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(villasPOM.searchBoxVisibility()));
		villasPOM.searchValueClass("Prestige");	//searchValueClass()method will pass the values in Search field
		adminPOM.scrollButtonClass();
		Thread.sleep(3000);
		adminPOM.iconClickClass();//iconClickClass()method will select the Prestige option after search input
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		wait.until(ExpectedConditions.visibilityOf(adminPOM.prestigeTextVisibility()));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(adminPOM.prestigeOverviewClassVisibility()));
		
		//Adding assertion
		String Expected1 ="Prestige - Overview";

		String Actual1 =  adminPOM.prestigeOverviewClass();	//prestigeOverviewClass()method will return the Text "prestige - Overview"
		System.out.println(Actual1);
		assertEquals(Actual1, Expected1);	
		
		
	}



} 

















