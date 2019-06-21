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
import com.training.pom.BlogSection_ViewPostLink;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_040_BlogSection_ViewPostLink {

	private WebDriver driver;
	private String adminUrl;
	private AddPost_CreatedCategory addPostPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;
	private LoginPOM loginPOM;
	private BlogSection_ViewPostLink blogSectionPOM;

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
		blogSectionPOM = new BlogSection_ViewPostLink(driver); 
		adminUrl = properties.getProperty("adminUrl");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void blogSelctionPostTest() throws AWTException, InterruptedException {
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
		//postsLinkClick() method will select the POST Link
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.postsLinkClickVisibility())); 
		addPostPOM.postsLinkClick();
		Thread.sleep(1000);
		screenShot.captureScreenShot("POST Link Selected");
		//categoryLinkClick() method will select the CATEGORY Link
		addPostPOM.categoryLinkClick();
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.categoryNameTextVisibility())); 

		//categoryNameText() method will pass the Category Name in text box field
		addPostPOM.categoryNameText("Testing Category1");

		//slugText() method will pass the SLUG Name in text box field
		addPostPOM.slugText("Testing Category slug");
		screenShot.captureScreenShot("Fill up the Name and Slug");
		//descriptionText() method will pass the DESCRIPTON in text box field	slugText
		addPostPOM.descriptionText("Testing Category slug description");
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		screenShot.captureScreenShot("Fill up the description");
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.addNewCategoryVisibility()));

		//addNewCategory() method will click on the ADD New Category Button
		addPostPOM.addNewCategory();
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.postsLinkSelectVisibility())); 

		addPostPOM.postsLinkSelectClass();
		wait.until(ExpectedConditions.visibilityOf(addPostPOM.addNewCategoryLinkClassVisibility())); 

		//addNewCategoryLinkClass() method will click on the Add New Post page 
		addPostPOM.addNewCategoryLinkClass();

		//postTitleClass() method will pass the TITTLE name 
		addPostPOM.postTitleClass("New Title");

		//editorAreaClass() method will pass the text into EDITOR area
		addPostPOM.editorAreaClass("New Title editor area");
		screenShot.captureScreenShot("Fill up the Title details");
		//chooseCategoryClass() method will Click on Checkbox beside created category name of category section 

		wait.until(ExpectedConditions.visibilityOf(addPostPOM.chooseCategoryClassVisibility()));
		addPostPOM.chooseCategoryClass();

		wait.until(ExpectedConditions.visibilityOf(addPostPOM.publishButtonVisibility())); 

		//publishButton() method will PUBLISH the ADD
		addPostPOM.publishButton();
		Thread.sleep(7000);
		screenShot.captureScreenShot("POST Published");

		//Adding Assertion to validate whether Post published. View post message displayed or not
		String Expected ="Post published. View post";

		String Actual =  addPostPOM.postPublishMessageClass();	
		System.out.println(Actual);
		Thread.sleep(3000);

		assertEquals(Actual, Expected);	

		//viewPostLinkClass() method will click on the VIEW POst Link
		blogSectionPOM.viewPostLinkClass();
		Thread.sleep(7000);

		screenShot.captureScreenShot("BLog Section displayed added Post details");
		//Adding Assertion to validate whether Blog section of home screen containing post details displayed or not

		String Expected1 = "New Title for Real State";
		String Actual1 =  blogSectionPOM.addedProprtyMessage();
		System.out.println("message"+ Actual1);
		assertEquals(Actual1, Expected1);

	}



} 



















