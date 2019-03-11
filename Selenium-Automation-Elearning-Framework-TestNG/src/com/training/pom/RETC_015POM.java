package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_015POM {

	private WebDriver driver; 

	public RETC_015POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(partialLinkText="Howd")
	private WebElement admin;

	@FindBy (xpath="//a[@class='ab-item'][contains(text(),'Log Out')]")
	private WebElement logout;

	public  void clickLogout() {
		this.logout.click();
		
		
	}




}
