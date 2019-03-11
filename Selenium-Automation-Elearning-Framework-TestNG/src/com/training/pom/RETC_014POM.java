package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_014POM {

	private WebDriver driver; 

	public RETC_014POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//click on login link
	@FindBy(id="user_login")
	private WebElement userName;

	//click on password 
	@FindBy (id="user_pass")
	private WebElement password;

	//click on generate login button
	@FindBy (name="login")
	private WebElement login;

	//click on new change password link
	@FindBy (xpath="//a[@href='http://realestate.upskills.in/change-password/']")
	private WebElement changePass;

	//click on current password
	@FindBy (name="current_pass")
	private WebElement currentPass;

	//click on new password
	@FindBy (name="pass1")
	private WebElement newPass;

	//click on confirm password
	@FindBy (name="pass2")
	private WebElement confirmPass;
	
	//click on save button
	@FindBy (name="wp-submit")
	private WebElement saveBtn;





	public  void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public  void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLogin() {
		this.login.click();

	}

	public void clickChangePass() {
		this.changePass.click();
	}

	public  void sendCurrentPass(String currentPass) {
		this.currentPass.clear();
		this.currentPass.sendKeys(currentPass); 

	}

	public  void sendNewPass(String newPass) {
		this.newPass.clear();
		this.newPass.sendKeys(newPass); 

	}

	public  void sendConfirmPass(String confirmPass) {
		this.confirmPass.clear();
		this.confirmPass.sendKeys(confirmPass);

	}

	public  void clickSaveBtn() {
		this.saveBtn.click(); 


	}

		
	}






