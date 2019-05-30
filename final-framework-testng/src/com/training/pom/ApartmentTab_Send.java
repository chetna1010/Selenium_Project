package com.training.pom;



import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ApartmentTab_Send {

	private WebDriver driver; 

	public ApartmentTab_Send(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText="LOG IN / REGISTER")
	private WebElement link; 
	
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement link1; 

	@FindBy(linkText="Real Estate")
	private WebElement homeScreen; 


	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/region/apartments-in-bangalore/']")
	private WebElement apartment; 

	@FindBy(xpath="//a[@class='wpmm-pagination-next']")
	private WebElement navigation; 

	@FindBy(xpath="//*[@name='your-name' and @class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")
	private WebElement yourName; 

	@FindBy(xpath="//*[@name='your-email' and @class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")
	private WebElement yourEmail; 

	@FindBy(xpath="//*[@name='your-subject' and @class='wpcf7-form-control wpcf7-text']")
	private WebElement yourSubject; 

	@FindBy(xpath="//textarea[@name='your-message' and @class='wpcf7-form-control wpcf7-textarea']")
	private WebElement yourMessage; 

	@FindBy(id="user_login")
	private WebElement userName; 

	
	
	@FindBy(id="user_pass")
	private WebElement password;



	@FindBy(name="login")
	private WebElement loginBtn; 

	@FindBy(xpath="//*[@class='wpcf7-form-control wpcf7-submit' and @type='submit']")
	private WebElement SendloginBtn;
	
	@FindBy(linkText="Donec quis")
	private WebElement donecQuis;
	
	public void linkSelect() {

		this.link.click();
	
	}

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}


	public void apartmentTab() throws InterruptedException 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(apartment).build().perform();
		Thread.sleep(2000);
	}
	
	public void apartmentTaboptions() throws InterruptedException 
	{
		boolean CB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/central-bangalore-apartments/' and @data-new_object_id='24']")).isDisplayed();
		System.out.println("Central Bangalore is Present :"+ CB);
		boolean EB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/east-bangalore-apartments/' and @data-new_object_id='30']")).isDisplayed();
		System.out.println("East Bangalore is Present :"+EB);
		boolean NB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/north-bangalore-apartments/' and @data-new_object_id='22']")).isDisplayed();
		System.out.println("North Bangalore is Present :"+NB);
		boolean SB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/south-bangalore-apartments/' and @data-new_object_id='28']")).isDisplayed();
		System.out.println("South Bangalore is Present :"+SB);
		boolean WB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/west-bangalore-apartments/' and @data-new_object_id='27']")).isDisplayed();
		System.out.println("West Bangalore is Present :"+WB);

		this.navigation.click();
		Thread.sleep(2000);
		
	}
	public void donecQuisSearching() throws  InterruptedException 
	{	Thread.sleep(4000);
		if(driver.findElement(By.linkText("Prestige")).isDisplayed())
		{
			
			this.navigation.click();
		}
		else 
		{
			System.out.println("Donec Quis is not found");
		}
		
	}
	public void donecQuisSelect() throws  InterruptedException 
	{
	Thread.sleep(2000);
	this.donecQuis.click();
	}
	public void donecQuisOverviewTest() throws AWTException, InterruptedException 
	{
		Robot robot = new Robot(); 
        Thread.sleep(2000); 
        robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		boolean donecQuis_Overview = driver.findElement(By.xpath("//h3[contains(text(),'Donec quis - Overview')]")).isDisplayed();
		System.out.println("Donec Quis Overview is displayed :"+donecQuis_Overview);
		boolean donecQuis_Details = driver.findElement(By.xpath("//h3[contains(text(),'Donec quis - Details')]")).isDisplayed();
		System.out.println("Donec Quis Details are present :"+donecQuis_Details);
		
	}

	public void your_Name(String yourName) {
		this.yourName.clear();
	
		this.yourName.sendKeys(yourName);           
		
	}
	public void your_Email(String yourEmail) {
		           
		this.yourEmail.clear();
		this.yourEmail.sendKeys(yourEmail);
		
	}
	
	public void your_Subject(String yourSubject) {
		
		this.yourSubject.clear(); 
		this.yourSubject.sendKeys(yourSubject);
	}
	
	public void sendMessage(String yourMessage) {

		this.yourMessage.clear();
		this.yourMessage.sendKeys(yourMessage);
		
	}
	
	public void SendLoginBtn() {
		this.SendloginBtn.click();
		
	}
}




