package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_013POM {

	private WebDriver driver; 

	public RETC_013POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;

	@FindBy (xpath="//a[contains(text(),'Your Profile')]")
	private WebElement yourProfile;

	@FindBy (id="last_name")
	private WebElement lastName;

	@FindBy (id="phone")
	private WebElement phonenumber;

	@FindBy (id="submit")
	private WebElement submitBtn;



	
	public  void clickUsers() {
		this.users.click();
	}

	public  void clickMyProfile() {
		this.yourProfile.click();
	}

	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void sendPhoneNumber(String phonenumber) {
		this.lastName.clear();
		this.lastName.sendKeys(phonenumber);
	}


	public  void clicksubmitBtn() {
		this.submitBtn.click(); 


	}
}