package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_043POM {

	private WebDriver driver; 

	public RETC_043POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

//properties	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;
//Add new	 
	@FindBy (linkText="Add New")
	private WebElement addNew;
//Title	
	@FindBy (name="post_title")
	private WebElement enterTitle;
//Text box
	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;
//Publish	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;	
//view posts	
	@FindBy (linkText="View post")
	private WebElement viewPost;
	
//Click on properties link
		public  void clickProperties() {
		this.properties.click();
	}
//Click on Add New link
	public  void clickAddNew() {
		this.addNew.click();
	}
//Enter Title
	public  void sendEnterTitle(String enterTitle ) {
		this.enterTitle.clear();
		this.enterTitle.sendKeys(enterTitle); 
	}
//Enter in text box
	public  void sendTextBox(String textBox) {
		driver.switchTo().frame(we_textarea_iframe);
		WebElement editor_body = driver.findElement(By.tagName("body"));
		editor_body.sendKeys("testing");
		driver.switchTo().defaultContent();
	
	}
//Click on publish
	public  void clickPublish() {
		this.publish.click(); 
	}
//Click on view post link	
	public  void clickViewPost() {
		this.viewPost.click();
	}
}






