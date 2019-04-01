package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_072POM {
	private WebDriver driver; 

	public RETC_072POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement newLaunch; 

	@FindBy(xpath="//span[contains(text(),'Donec quis')]")
	private WebElement featuredImg;

	//@FindBy(id="formLogin_submitAuth")
	@FindBy(name="your-name")
	private WebElement yourName; 

	@FindBy(name="your-email")
	private WebElement emailID; 

	@FindBy(name="your-subject")
	private WebElement subjText; 

	@FindBy(name="your-message")
	private WebElement msgBox; 

	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbt; 



	public void clickNewLaunch() {
		this.newLaunch.click();
	}

	public void clickFeaturedImg() {
		this.featuredImg.click();
	}


	public void sendYourName(String yourName) {
		this.yourName.clear(); 
		this.yourName.sendKeys(yourName); 
	}

	public void sendeMailID(String emailID) {
		this.emailID.clear(); 
		this.emailID.sendKeys(emailID); 
	}

	public void sendSubjText(String subjText) {
		this.subjText.clear(); 
		this.subjText.sendKeys(subjText); 
	}

	public void sendMsgBox(String msgBox) {
		this.msgBox.clear(); 
		this.msgBox.sendKeys(msgBox); 
	}


	public void clickSubmitbt() {
		this.submitbt.click();

	}




}
