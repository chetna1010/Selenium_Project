package com.training.pom;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlogTests {

	private WebDriver driver; 
	public BlogTests(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/blog/']")
	private WebElement blog; 
	
	@FindBy(xpath="//*[@title='Search input' and @class='orig']")
	private WebElement searchIcon; 

	@FindBy(xpath="//a[@class='asl_res_url' and @href='http://realestatem1.upskills.in/nullam-hendrerit-apartments/']")
	private WebElement iconClick; 
	
	public void blogSelectTab()
	{	Actions builder = new Actions(driver);
	builder.moveToElement(blog).click().perform();
	
	}
	
	public void searchValueClass(String searchIcon)
	{
		this.searchIcon.clear();
		this.searchIcon.sendKeys(searchIcon);
	}
	
	public void iconClickClass() {
		this.iconClick.click();	
	}
	
}



