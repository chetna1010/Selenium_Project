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

public class AdminPropertyHomeScreen {


	private WebDriver driver; 
	public AdminPropertyHomeScreen(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='wp-menu-name']")
	private WebElement dashBoard;

	@FindBy(xpath="//*[@id=\"mCSBap_1_scrollbar_vertical\"]/a[2]")
	private WebElement scrollButton;

	@FindBy(xpath="//li/a[@href='edit-tags.php?taxonomy=property_feature&post_type=property']")
	private WebElement featureLink; 

	@FindBy(xpath="//*[@name='tag-name' and @id='tag-name']")
	private WebElement categoryName; 

	@FindBy(xpath="//*[@name='slug' and @id='tag-slug']")
	private WebElement slug; 

	@FindBy(xpath="//*[@name='description' and @id='tag-description']")
	private WebElement categoryDesc; 

	@FindBy(xpath="//*[@id='submit' and @value='Add New Feature']")
	private WebElement addNewFeatureButton; 

	@FindBy(xpath="//*[@name='post_title' and @id='title']")
	private WebElement postTitle; 

	@FindBy(xpath="//*[@class='wp-editor-area' and @id='content']")
	private WebElement editorArea; 

	@FindBy(xpath="//*[@name='tax_input[property_feature][]' and @id='in-property_feature-151']")
	private WebElement chooseFeature; 

	@FindBy(xpath="//*[@name='publish' and @class='button button-primary button-large']")
	private WebElement publish; 


	@FindBy(xpath="//*[@href='http://realestatem1.upskills.in/wp-admin/post-new.php?post_type=property' and @class='page-title-action']")
	private WebElement addNewPropertiesLink; 

	@FindBy(xpath="//*[@id='message' and @class='updated notice notice-success is-dismissible']/p")
	private WebElement postPublishMessage; 

	@FindBy(xpath="//*[@id='menu-posts-property']/a/div[3]")
	private WebElement property; 	

	@FindBy(xpath="//*[@id='property_featurediv']/button/span[2]")
	private WebElement featureArrowButton; 

	@FindBy(xpath="//*[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-property']//div[@class='wp-menu-name']")
	private WebElement propertyLinkSelect; 

	@FindBy(xpath="//*[@class='ab-item' and @href='http://realestatem1.upskills.in/wp-admin/profile.php']/span[@class='display-name']")
	private WebElement logOUT; 

	@FindBy(linkText="Log Out")
	private WebElement logOUTSelect; 

	@FindBy(linkText="Real Estate")
	private WebElement realStateIcon; 

	@FindBy(xpath="//*[@title='Search input' and @class='orig']")
	private WebElement searchBox; 

	@FindBy(xpath="//a[@class='asl_res_url' and @href='http://realestatem1.upskills.in/prestige-24/']")
	private WebElement iconClick1; 

	@FindBy(xpath="//*[@id='titlebar']/div/div/div/div[1]/h2")
	private WebElement prestigeVisibility;

	@FindBy(xpath="//*[@id='wrapper']/div[4]/div/div[1]/div/h3[1]")
	private WebElement prestigeOverviewVisibility;


	public WebElement propertyLinkSelectVisibility() {
		return this.property;
	}

	public void propertyLinkSelectClass() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(property).click().perform();
		//Thread.sleep(2000);

	}


	public WebElement propertyLinkClickVisibility() {
		return this.propertyLinkSelect;
	}

	public void propertyLinkClick() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(propertyLinkSelect).build().perform();
		//Thread.sleep(2000);

	}

	public void featureLinkClick() throws InterruptedException
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(featureLink).click().perform();
		Thread.sleep(2000);

	}

	public WebElement categoryNameTextVisibility() {
		return this.categoryName;
	}

	public void categoryNameText(String categoryName)
	{
		this.categoryName.clear();
		this.categoryName.sendKeys(categoryName);
	}

	public void slugText(String slug)
	{
		this.slug.clear();
		this.slug.sendKeys(slug);
	}

	public void descriptionText(String categoryDesc) 
	{
		this.categoryDesc.clear();
		this.categoryDesc.sendKeys(categoryDesc);

	}

	public WebElement addNewFeatureVisibility() {
		return this.addNewFeatureButton;
	}
	public WebElement dashboardVisibility() {
		return this.dashBoard;
	}

	public void addNewFeature() {
		Actions actions = new Actions(driver);

		actions.doubleClick(addNewFeatureButton).click().perform();

	}

	public WebElement addNewPropertiesLinkClassVisibility() {
		return this.addNewPropertiesLink;
	}
	public void addNewPropertiesLinkClass() {
		this.addNewPropertiesLink.click();	
	}

	public void featureArrowButtonClass() {
		this.featureArrowButton.click();	
	}

	public void postTitleClass(String postTitle)
	{
		this.postTitle.clear();
		this.postTitle.sendKeys(postTitle);
	}

	public void editorAreaClass(String editorArea)
	{
		this.editorArea.clear();
		this.editorArea.sendKeys(editorArea);
	}


	public void chooseFeatureClass() {
		this.chooseFeature.click();	
	}

	public WebElement chooseFeatureClassVisibility() {
		return this.chooseFeature;
	}

	public void publishButton() {
		Actions actions = new Actions(driver);

		actions.doubleClick(publish).perform();
	}
	public WebElement publishButtonVisibility() {
		return this.publish;
	}

	public String postPublishMessageClass() {
		return this.postPublishMessage.getText();	
	}


	public void logOUTClick() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(logOUT).build().perform();



	}

	public void logOUTSelect() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(logOUTSelect).click().perform();


	}

	public void realStateICONClick() {
		this.realStateIcon.click();	
	}


	public void iconClickClass() {
		this.iconClick1.click();	
	}

	public WebElement prestigeTextVisibility() {
		return this.prestigeVisibility;
	}
	public WebElement prestigeOverviewClassVisibility() {
		return this.prestigeOverviewVisibility;
	}

	public String prestigeOverviewClass() {
		return this.prestigeOverviewVisibility.getText();	
	}
	
	public void scrollButtonClass() {
		this.scrollButton.click();	
	}
	
}





