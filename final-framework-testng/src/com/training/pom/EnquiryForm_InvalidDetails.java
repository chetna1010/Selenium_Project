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


public class EnquiryForm_InvalidDetails {
	private WebDriver driver; 
	public EnquiryForm_InvalidDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/region/commercial-properties-in-bangalore/']")
	private WebElement commercial; 

	@FindBy(linkText="prestige")
	private WebElement prestige;

	public void commercialTab() throws InterruptedException 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(commercial).build().perform();
		Thread.sleep(2000);
	}
	public void prestigeOptionSelect() throws InterruptedException 
	{
	
		
		this.prestige.click();
	}
	
	public String backgroundColorCheck() 
	{
	String color = driver.findElement(By.xpath("//*[@id='wpcf7-f4-o1']/form/p[2]/label/span/input")).getCssValue("background-color");
	String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
	 
	int hexValue1=Integer.parseInt(hexValue[0]);
	hexValue[1] = hexValue[1].trim();
	int hexValue2=Integer.parseInt(hexValue[1]);
	hexValue[2] = hexValue[2].trim();
	int hexValue3=Integer.parseInt(hexValue[2]);
	 
	String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
	return actualColor;
	}
	

}

















