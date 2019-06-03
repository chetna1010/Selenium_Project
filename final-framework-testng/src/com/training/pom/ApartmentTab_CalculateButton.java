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


	@FindBy(xpath="//*[@id='amount' and @name='amount']")
	private WebElement salesPrice; 

	@FindBy(xpath="//*[@id='downpayment' and @type='text']")
	private WebElement downPayment; 

	@FindBy(xpath="//*[@id='years' and @type='text']")
	private WebElement loanTerm; 

	@FindBy(xpath="//*[@id='interest' and @type='text']")
	private WebElement interestRate; 

	@FindBy(xpath="//*[@class='button calc-button']")
	private WebElement calculateBtn;

	
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





