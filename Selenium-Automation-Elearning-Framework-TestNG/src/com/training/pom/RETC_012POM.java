package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_012POM {
	private WebDriver driver; 

	public RETC_012POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
 

	@FindBy(linkText="Lost Your Password?")
	private WebElement forgetpassword;


	@FindBy(id="user_login")
	private WebElement email;


	@FindBy(name="submit")
	private WebElement resetBtn; 
	


	public void clickForgetPass() {
		this.forgetpassword.click(); 
	}

	public void sendEmail(String email ) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}


	public void clickResetBtn() {
		this.resetBtn.click(); 

	}
}

