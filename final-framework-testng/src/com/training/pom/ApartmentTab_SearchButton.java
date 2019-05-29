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
import org.openqa.selenium.support.ui.Select;



public class ApartmentTab_SearchButton {

	private WebDriver driver; 

	public ApartmentTab_SearchButton(WebDriver driver) {
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

	@FindBy(xpath="//*[@id='keyword_search' and @id='keyword_search']")
	private WebElement youraddress; 

	@FindBy(xpath="//*[@id='nextpoint' and @title='Next point on map']")
	private WebElement nextButton; 

	@FindBy(xpath="//*[@class='chosen-single chosen-default']")
	private WebElement dropDownSelect; 

	@FindBy(xpath="//div/div/ul[@class='chosen-results']/li[@class='active-result' and @data-option-array-index='3']")
	private WebElement dropDownOptionSelect; 

	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(xpath="//*[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement element;

	@FindBy(id="user_pass")
	private WebElement password;

	

	@FindBy(name="login")
	private WebElement loginBtn; 

	@FindBy(xpath="//*[@class='wpcf7-form-control wpcf7-submit' and @type='submit']")
	private WebElement SendloginBtn;

	@FindBy(xpath="//a[@class='chosen-single chosen-default']/span")
	private WebElement region;
	@FindBy(xpath="//*[@id='realteo-search-form']/div[2]/div[2]/div/div/ul/li[3]")
	private WebElement regionSelect;
	
	@FindBy(xpath="//*[@class='button fullwidth']")
	private WebElement searchButton;
	
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


	public void your_Address(String youraddress) {

		this.youraddress.clear(); 
		this.youraddress.sendKeys(youraddress);
	}

	

	

	
	public void apartmentSelectTab()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(apartment).click().perform();
		this.nextButton.click();
		
	}
	
	
	public void dropdownSelect1()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(dropDownSelect).click().perform();
		
		
	    }
	public void selectOption()
	{
		Actions builder = new Actions(driver);
		//builder.moveToElement(dropDownOptionSelect).build().perform();
		builder.moveToElement(dropDownOptionSelect).click().perform();
		
	
	}
	public void Region()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(region).build().perform();
		builder.moveToElement(region).click().perform();
		builder.moveToElement(regionSelect).click().perform();	
		
		
	
	}
	public void SearchButtonClick() {
		this.searchButton.click();

	}
	
	
}

	
			
	



	








