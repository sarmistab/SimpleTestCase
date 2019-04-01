package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_075POM {

private WebDriver driver; 

public RETC_075POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='post-new.php']")
	private WebElement addNewPost;

	@FindBy (xpath="//a[contains(text(),'Add New Category')]")
	private WebElement addNewCatgLink;

	@FindBy(name="newcategory")
	private WebElement titleTextbox;

	@FindBy (id="category-add-submit")
	private WebElement addNewCatgBtn;

	@FindBy(name="post_title")
	private WebElement titleText;

	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;

	@FindBy (xpath="//*[contains(text(),'Sarmista Test')]")
	private WebElement checkBox;

	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtn;	

	@FindBy(partialLinkText="Howd")
	private WebElement admin;

	@FindBy (linkText="Log Out")
	private WebElement logoutBtn;

	public void clickAddNewPost() {
		this.addNewPost.click();
	}
	public void clickAddNewCatgLink() {
		this.addNewCatgLink.click();
	}
	public  void sendTitleTextbox(String titleTextbox ) {
		this.titleTextbox.clear();
		this.titleTextbox.sendKeys(titleTextbox);
	}
	public void clickNewCatgnBtn() {
		this.addNewCatgBtn.click();
	}
	public void sendtitleText(String titleText){
		this.titleText.clear();
		this.titleText.sendKeys(titleText);
	}
	public  void sendTextBox(String textBox) {
		driver.switchTo().frame(we_textarea_iframe);
		WebElement editor_body = driver.findElement(By.tagName("body"));
		editor_body.sendKeys("IBM Test");
		driver.switchTo().defaultContent();
	}
	public void clickCheckBox() {
		this.checkBox.click();
	}
	public void clickPublishBtn() {
		this.publishBtn.click();
	}	
	public void clicklogoutBtn() {
		this.logoutBtn.click();
	}
}


