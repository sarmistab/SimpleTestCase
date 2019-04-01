package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_073POM {
	private WebDriver driver; 

	public RETC_073POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement newLaunch; 

	@FindBy(xpath="//span[contains(text(),'Donec quis')]")
	private WebElement featuredImg;

	//@FindBy(id="formLogin_submitAuth")
	@FindBy(name="your-name")
	private WebElement username; 

	@FindBy(name="your-email")
	private WebElement email; 

	@FindBy(name="your-subject")
	private WebElement message; 

	@FindBy(name="your-message")
	private WebElement info; 

	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbt; 



	public void clickNewLaunch() {
		this.newLaunch.click();
	}

	public void clickFeaturedImg() {
		this.featuredImg.click();
	}


	public void sendYourName(String yourName) {
		this.username.clear(); 
		this.username.sendKeys(yourName); 
	}

	public void sendeMailID(String emailID) {
		this.email.clear(); 
		this.email.sendKeys(emailID); 
	}

	public void sendMessage(String message) {
		this.message.clear(); 
		this.message.sendKeys(message); 
	}

	public void sendInfo(String info) {
		this.info.clear(); 
		this.info.sendKeys(info); 
	}


	public void clickSubmitbt() {
		this.submitbt.click();

	}




}
