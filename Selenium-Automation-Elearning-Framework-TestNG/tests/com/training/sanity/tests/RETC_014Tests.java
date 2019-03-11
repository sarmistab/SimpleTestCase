package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_013POM;
import com.training.pom.RETC_014POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_014Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_014POM updatePasswordPOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeMethod
	public void setUp() throws Exception {

		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		updatePasswordPOM = new RETC_014POM(driver); 
		loginPOM =new RETC_011POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	
	}
	@Test
	public void validUpdatePasswordTest()  { 
		
		String expectedtext="Your password has been updated.";
		//enter username
		updatePasswordPOM.sendUserName("samtest");
		//enter password
		updatePasswordPOM.sendPassword("testP@ssword5");
		//click login button
		updatePasswordPOM.clickLogin();
		//click on change password link
		updatePasswordPOM.clickChangePass(); 
		//enter current password
		updatePasswordPOM.sendCurrentPass("testP@ssword5");
		//enter new password
		updatePasswordPOM.sendNewPass("testP@ssword6");
		//confirm new password
		updatePasswordPOM.sendConfirmPass("testP@ssword6");
		//click on save button
		updatePasswordPOM.clickSaveBtn();
		String actualtext=driver.findElement(By.xpath("//p[contains(text(),'Your password has been updated.')]")).getText();
		Assert.assertEquals(actualtext,expectedtext);
		//take screenshot after profile is updated
		screenShot.captureScreenShot("RETC_014_PasswordUpdated");
		
		

	}
}



