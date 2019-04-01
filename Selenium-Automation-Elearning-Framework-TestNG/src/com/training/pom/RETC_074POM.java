package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_074POM {
	private WebDriver driver; 

	public RETC_074POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement usersLink; 

	@FindBy(xpath="//a[contains(text(),'All Users')]")
	private WebElement allUsersLink;

	//@FindBy(xpath="//tr[@id='user-60']//th[@class='check-column']")
	@FindBy(xpath="//input[@value='61']")
	private WebElement checkBox; 

	@FindBy(name="changeit")
	private WebElement changeBtn; 


	public void clickUsersLink() {
		this.usersLink.click();
	}
	public void clickallUsersLink() {
		this.allUsersLink.click();	
	}
	public void clickCheckBox() {
		this.checkBox.click();
	}
	public void clickChangeBtn() {
		this.changeBtn.click(); 
	}
}