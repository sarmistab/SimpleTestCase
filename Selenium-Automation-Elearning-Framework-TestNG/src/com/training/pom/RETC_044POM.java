package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_044POM {

	private WebDriver driver; 

	public RETC_044POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;

	
	@FindBy (linkText="Features")
	private WebElement feature;
	
	@FindBy(name="tag-name")
	private WebElement nameTextBox;

	
	@FindBy (name="slug")
	private WebElement slugText;

	@FindBy (name="description")
	private WebElement description;
	
	@FindBy(name="submit")
	private WebElement addNewFeature;
	 
	@FindBy (linkText="Add New")
	private WebElement addNew;

	
	@FindBy (name="post_title")
	private WebElement enterTitle;

	@FindBy (xpath="//textarea[@id='content']")
	private WebElement textBox;
	
	@FindBy (xpath="//*[contains(text(),'Sarmis')]")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;	
	
	
		public  void clickProperties() {
		this.properties.click();
	}
		
		public  void clickFeature() {
			this.feature.click();
		}
		
		public  void sendNameTextBox(String nameTextBox) {
			this.nameTextBox.clear();
			this.nameTextBox.sendKeys(nameTextBox);
		}
		

		public  void sendSlugText(String slugText ) {
			this.slugText.clear();
			this.slugText.sendKeys(slugText);
		}
		
		
		public  void sendDescription(String description) {
			this.description.clear();
			this.description.sendKeys(description);
		}
		
		public  void clickCheckBox() {
			this.checkBox.click();
		}

	public  void clickAddNew() {
		this.addNew.click();
	}

	public  void sendEnterTitle(String enterTitle ) {
		this.enterTitle.clear();
		this.enterTitle.sendKeys(enterTitle); 

	}

	public  void sendTextBox(String textBox) {
		this.textBox.clear();
		this.textBox.sendKeys(textBox); 

	}
	
	public  void clickAddNewFeature() {
		this.addNewFeature.click();
	}


	public  void clickPublish() {
		this.publish.click(); 
	}

	}
	
	
		
	






