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

public class BlogSection_ViewPostLink {


	private WebDriver driver; 
	public BlogSection_ViewPostLink(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="View post")
	private WebElement viewPostLink;

	@FindBy(xpath="//*[@class='col-md-8']/div[@class='blog-post single-post']/div[@class='post-content']/a")
	private WebElement addedPropertyTitle;

	public void viewPostLinkClass() {

		this.viewPostLink.click();
	}

	public String addedProprtyMessage() {

		return this.addedPropertyTitle.getText();
	}


}






