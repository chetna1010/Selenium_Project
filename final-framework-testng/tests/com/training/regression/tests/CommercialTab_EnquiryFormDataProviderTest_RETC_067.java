package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.CommercialTab_EnquiryDataProvider;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.ApartmentTab_Send;
import com.training.pom.CommercialTab_EnquiryFormDataProviderTest;
import com.training.pom.EnquiryForm_InvalidDetails;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CommercialTab_EnquiryFormDataProviderTest_RETC_067 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	private WebDriverWait wait;
	private EnquiryForm_InvalidDetails enquiryPOM;
	private ApartmentTab_Send sendPOM;
	private CommercialTab_EnquiryFormDataProviderTest commercialPOM;
	
	
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
		enquiryPOM = new EnquiryForm_InvalidDetails(driver);
		commercialPOM= new CommercialTab_EnquiryFormDataProviderTest(driver);
		sendPOM= new ApartmentTab_Send(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = CommercialTab_EnquiryDataProvider.class)
	//TO Verify whether application allows the user to send an enquiry in Done quis under Apartments tab & filled details get displayed in database
	public void EnquiryDBTest(String userName, String userEmail, String userSubject, String userMessage) throws InterruptedException {
		
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(loginPOM.loginRegisterVisibility())); 
	
		loginPOM.linkSelect();	// linkselect() method will select the Log IN/Register Link 
		screenShot.captureScreenShot("Log In Screen displayed");

		wait.until(ExpectedConditions.visibilityOf(loginPOM.userNameVisibility()));
		
		loginPOM.sendUserName("chetna");//sendUserName() method will pass the use name in text box
		
		loginPOM.sendPassword("hello@4321");//sendPassword() method will pass the password in text box
		screenShot.captureScreenShot("Entering Credentials");
	
		loginPOM.clickLoginBtn(); 	//clickLoginBtn() method will click on SIGN IN button

		wait.until(ExpectedConditions.visibilityOf(loginPOM.myProfileClass())); 
		screenShot.captureScreenShot("Profile Screen displayed");

		enquiryPOM.commercialTab();//commercialTab() method will select the commercial tab
		screenShot.captureScreenShot("Mouse hover on Apartment Option");
				
		sendPOM.apartmentTaboptions();//apartmentTaboptions() method will hit the arrow button untill prestige option is not visible
		screenShot.captureScreenShot("All Apartment Tab options are present");
				
		sendPOM.PrestigeSelect();//prestigeOptionSelect() method will select the Prestige option
		
		commercialPOM.your_Name("manzoor");//your_Name()method will pass the input for Name text box

		String USERNAME= commercialPOM.getYour_Name(); //To fetch userName from Application
		
		commercialPOM.your_Email("manzoor@gmail.com");//your_Email() method will pass the input for email text box

		String EMAIL= commercialPOM.getYour_Email();//To fetch EMAIL from Application
		screenShot.captureScreenShot("fill up the name and email");
		
		commercialPOM.your_Subject("apartments");//your_Subject()method will pass the input for subject text box
		String SUBJECT= commercialPOM.getYour_Subject();//To fetch Subject from Application
		screenShot.captureScreenShot("filled the subject");
		
		
		commercialPOM.sendMessage("looking for an apartments");//sendMessage() method pass the input for message text box
		String MESSAGE= commercialPOM.getYour_Message();//To fetch Message from Application
		screenShot.captureScreenShot("fill up the message ");
			
		sendPOM.SendLoginBtn();//SendLoginBtn() method will clik on Send button

		Thread.sleep(3000); 
	
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;	//This  will scroll down the page by  300 pixel vertical

		jse1.executeScript("window.scrollBy(0,300)");
	
		assertEquals(USERNAME, userName);	
		assertEquals(EMAIL, userEmail);
		assertEquals(SUBJECT, userSubject);
		assertEquals(MESSAGE, userMessage);
		

	}

}


