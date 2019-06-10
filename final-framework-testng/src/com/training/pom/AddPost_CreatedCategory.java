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

public class AddPost_CreatedCategory {


	private WebDriver driver; 
	public AddPost_CreatedCategory(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='wp-menu-name']")
	private WebElement dashBoard;
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[3]")
	private WebElement postLink; 

	@FindBy(xpath="//li/a[@href='edit-tags.php?taxonomy=category']")
	private WebElement categoryLink; 

	@FindBy(xpath="//*[@name='tag-name' and @id='tag-name']")
	private WebElement categoryName; 

	@FindBy(xpath="//*[@name='slug' and @id='tag-slug']")
	private WebElement slug; 

	@FindBy(xpath="//*[@name='description' and @id='tag-description']")
	private WebElement categoryDesc; 

	@FindBy(xpath="//*[@id='submit']")
	private WebElement addNewCategoryButton; 

	@FindBy(xpath="//*[@name='post_title' and @id='title']")
	private WebElement postTitle; 

	@FindBy(xpath="//*[@class='wp-editor-area' and @id='content']")
	private WebElement editorArea; 

	@FindBy(xpath="//*[@name='post_category[]' and @id='in-category-328']")
	private WebElement chooseCategory; 

	@FindBy(xpath="//*[@name='publish' and @class='button button-primary button-large']")
	private WebElement publish; 

		
	@FindBy(xpath="//*[@href='http://realestatem1.upskills.in/wp-admin/post-new.php' and @class='page-title-action']")
	private WebElement addNewCategoryLink; 

	@FindBy(xpath="//*[@id='message' and @class='updated notice notice-success is-dismissible']/p")
	private WebElement postPublishMessage; 


	//@FindBy(xpath="//*[@id='submitdiv' and @class='postbox closed']/button/span[2]")
	//private WebElement publishArrowButton; 
	
	@FindBy(xpath="//*[@id='adminmenuwrap' ]/ul/li[3][@id='menu-posts']/a[@class='wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-post open-if-no-js menu-top-first']/div[3][@class='wp-menu-name']")
	private WebElement postLinkSelect; 
	
	
	

	public WebElement postsLinkSelectVisibility() {
		return this.postLinkSelect;
	}

	public void postsLinkSelectClass() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(postLinkSelect).click().perform();
		//Thread.sleep(2000);


	}
	
	
	public WebElement postsLinkClickVisibility() {
		return this.postLink;
	}

	public void postsLinkClick() throws InterruptedException
	{	
		Actions builder = new Actions(driver);
		builder.moveToElement(postLink).build().perform();
		//Thread.sleep(2000);


	}

	public void categoryLinkClick() throws InterruptedException
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(categoryLink).click().perform();
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

	public WebElement addNewCategoryVisibility() {
		return this.addNewCategoryButton;
	}
	public WebElement dashboardVisibility() {
		return this.dashBoard;
	}

	public void addNewCategory() {
		Actions actions = new Actions(driver);

		actions.doubleClick(addNewCategoryButton).click().perform();

	}

	public WebElement addNewCategoryLinkClassVisibility() {
		return this.addNewCategoryLink;
	}
	public void addNewCategoryLinkClass() {
		this.addNewCategoryLink.click();	
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


	public void chooseCategoryClass() {
		this.chooseCategory.click();	
	}

	public WebElement chooseCategoryClassVisibility() {
		return this.chooseCategory;
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

}



