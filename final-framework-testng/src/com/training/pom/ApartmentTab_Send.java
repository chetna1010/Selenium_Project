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

	@FindBy(xpath="//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement afterMessage; 

	@FindBy(xpath="//*[@class='wpcf7-form-control wpcf7-submit' and @type='submit']")
	private WebElement SendloginBtn;

	@FindBy(linkText="Donec quis")
	private WebElement donecQuis;

	@FindBy(xpath="//*[@title='Prestige' and @href='http://realestatem1.upskills.in/prestige-12/']")
	private WebElement prestige;

	
	public String afterMessageTest() {
		return this.afterMessage.getText();	
	}
	public void apartmentTab() throws InterruptedException 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(apartment).build().perform();
		Thread.sleep(2000);
	}

	public void apartmentTaboptions() throws InterruptedException 
	{
		
		this.navigation.click();
		Thread.sleep(2000);
	}

	public void donecQuisSearching() throws  InterruptedException 
	{	
		Thread.sleep(4000);
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

	public void PrestigeSelect() throws  InterruptedException 
	{
		Thread.sleep(2000);
		this.prestige.click();
	}
	
	public void donecQuisOverviewTest() throws AWTException, InterruptedException 
	{
		Robot robot = new Robot(); 
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		
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




