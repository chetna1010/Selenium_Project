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



public class ApartmentTab_CalculateButton {

	private WebDriver driver; 

	public ApartmentTab_CalculateButton(WebDriver driver) {
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

	@FindBy(xpath="//*[@id='amount' and @name='amount']")
	private WebElement salesPrice; 

	@FindBy(xpath="//*[@id='downpayment' and @type='text']")
	private WebElement downPayment; 

	@FindBy(xpath="//*[@id='years' and @type='text']")
	private WebElement loanTerm; 

	@FindBy(xpath="//*[@id='interest' and @type='text']")
	private WebElement interestRate; 

	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(xpath="//*[@class='notification success')]")
	private WebElement element;

	@FindBy(xpath="//*[@id='widget_mortgage_calc_properties-4']/form/div[5]/div/text()")
	private WebElement element1;

	@FindBy(id="user_pass")
	private WebElement password;



	@FindBy(name="login")
	private WebElement loginBtn; 

	@FindBy(xpath="//*[@class='button calc-button']")
	private WebElement calculateBtn;

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

	public void apartmentTabOptions() throws AWTException, InterruptedException 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(apartment).build().perform();


		boolean CB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/central-bangalore-apartments/' and @data-new_object_id='24']")).isDisplayed();
		System.out.println("First Options is :"+ CB);


		boolean EB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/east-bangalore-apartments/' and @data-new_object_id='30']")).isDisplayed();
		System.out.println("Second Options is :"+EB);
		boolean NB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/north-bangalore-apartments/' and @data-new_object_id='22']")).isDisplayed();
		System.out.println("Third Options is :"+NB);
		boolean SB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/south-bangalore-apartments/' and @data-new_object_id='28']")).isDisplayed();
		System.out.println("Forth Options is :"+SB);
		boolean WB = driver.findElement(By.xpath("//a[@href='http://realestatem1.upskills.in/region/west-bangalore-apartments/' and @data-new_object_id='27']")).isDisplayed();
		System.out.println("Fifth Options is :"+WB);
		this.navigation.click();
		Boolean bool= false;

		if(driver.findElement(By.linkText("Donec quis")).equals(bool))
		{
			this.navigation.click();
			this.donecQuis.click();
		}
		else 
		{
			System.out.println("Donec Quis is not found");
		}
		Robot robot = new Robot();  // Robot class throws AWT Exception	
		Thread.sleep(2000); // Thread.sleep throws InterruptedException	
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		boolean donecQuis_Overview = driver.findElement(By.xpath("//h3[contains(text(),'Donec quis - Overview')]")).isDisplayed();
		System.out.println("Donec Quis Overview :"+donecQuis_Overview);
		boolean donecQuis_Details = driver.findElement(By.xpath("//h3[contains(text(),'Donec quis - Details')]")).isDisplayed();
		System.out.println("Donec Quis Details :"+donecQuis_Details);



	}

	public void salesPriceCalculate(String salesPrice) {
		this.salesPrice.clear();

		this.salesPrice.sendKeys(salesPrice);           

	}
	public void donwPaymenetCalculate(String downPayment) {

		this.downPayment.clear();
		this.downPayment.sendKeys(downPayment);

	}

	public void loanTermClass(String loanTerm) {

		this.loanTerm.clear(); 
		this.loanTerm.sendKeys(loanTerm);
	}

	public void interestRateCalulator(String interestRate) {

		this.interestRate.clear();
		this.interestRate.sendKeys(interestRate);

	}

	public void calculateBtn() {
		this.calculateBtn.click();



	}




}





