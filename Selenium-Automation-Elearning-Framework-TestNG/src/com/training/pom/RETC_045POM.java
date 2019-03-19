package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_045POM {

	private WebDriver driver; 

	public RETC_045POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;
	
	@FindBy (linkText="Regions")
	private WebElement regions;
	
	@FindBy (name="tag-name")
	private WebElement nameTextBox;
	
	@FindBy(name="slug")
	private WebElement slugText;
		
	@FindBy (name="description")
	private WebElement descriptionText;
	
	@FindBy(name="submit")
	private WebElement addRegionbtn;
	 
	@FindBy (linkText="Add New")
	private WebElement addNew;

	
	@FindBy (name="post_title")
	private WebElement enterTitle;

	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;
	
	@FindBy (xpath="//*[contains(text(),'Sarmista')]")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;	
	

	

		public  void clickRegions() {
		this.regions.click();
	}

	public  void sendNameTextBox(String nameTextBox ) {
		this.nameTextBox.clear();
		this.nameTextBox.sendKeys(nameTextBox);
	}

	public  void sendSlugText(String slugText ) {
		this.slugText.clear();
		this.slugText.sendKeys(slugText);
	}

	
	public  void sendDescriptionText(String descriptionText ) {
		this.descriptionText.clear();
		this.descriptionText.sendKeys(descriptionText);
	}

	
	public  void clickaddRegionbtn() {
		this.addRegionbtn.click();
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

	}
	
	
		
	






