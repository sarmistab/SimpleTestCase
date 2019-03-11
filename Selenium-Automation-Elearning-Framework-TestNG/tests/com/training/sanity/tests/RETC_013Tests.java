package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_013POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_013Tests {
	
	private WebDriver driver;
	private String baseUrl;
	private RETC_013POM updatePOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	/*@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		
	}*/

	@BeforeMethod
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		updatePOM = new RETC_013POM(driver); 
		loginPOM =new RETC_011POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//login to the appliaction with admin credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validUpdateTest() {
		

		String expectedtext="Profile updated.";
		//click on Users link
		updatePOM.clickUsers();
		//click on MyProfile link
		updatePOM.clickMyProfile();
		//update last name
		updatePOM.sendLastName("test394");
		//update phone number
		updatePOM.sendPhoneNumber("900000872"); 
		//click on submit button
		updatePOM.clicksubmitBtn();
		String actualtext=driver.findElement(By.xpath("//strong[contains(text(),'Profile updated.')]")).getText();
		Assert.assertEquals(actualtext,expectedtext);
		//take screen shot after profile is updated
		screenShot.captureScreenShot("RETC_013_UpdateProfile");
		
		
		
		
	}
}



