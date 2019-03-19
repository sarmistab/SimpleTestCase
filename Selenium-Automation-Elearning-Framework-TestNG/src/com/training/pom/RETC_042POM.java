package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_042POM {

	private WebDriver driver; 

	public RETC_042POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Posts	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement posts;
	//New Post	 
	@FindBy (xpath="//a[@href='post-new.php']")
	private WebElement newPost;
	//Enter Title	
	@FindBy (name="post_title")
	private WebElement enterTitle;
	//Text box
	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;
	//Publish button	
	@FindBy(name="publish")
	private WebElement publish;	
	//All Post	
	@FindBy (xpath="//a[@class='wp-first-item current']")
	private WebElement allPost;
	//Created post	
	@FindBy (linkText="Test post2")
	private WebElement postCreated;


	public  void clickPosts() {
		//Click on posts link
		this.posts.click();
	}

	public  void clicknewPost() {
		//Click on New posts link
		this.newPost.click();
	}

	public  void sendEnterTitle(String enterTitle ) {
		this.enterTitle.clear();
		//Enter Title in the Title Text box
		this.enterTitle.sendKeys(enterTitle); 
	}

	public  void sendTextBox(String textBox) {
		driver.switchTo().frame(we_textarea_iframe);
		WebElement editor_body = driver.findElement(By.tagName("body"));
		editor_body.sendKeys("IBM Test");
		driver.switchTo().defaultContent();
	}


	public  void clickPublish() {
		//Click publish button
		this.publish.click(); 
	}

	public  void clickAllPost() {
		//Click on All Posts link
		this.allPost.click();
	}

	public  void clickPostCreated() {
		//Click on the created post link
		this.postCreated.click();
	}

}






