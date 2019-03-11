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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_011Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new RETC_011POM(driver); 
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
	public void validLoginTest() {
		String actualTitle=driver.getTitle();
		//login into the application with admin 
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		//click on login button
		loginPOM.clickLoginBtn(); 
		String expectedTitle="My Profile – Real Estate";
		Assert.assertEquals(actualTitle,expectedTitle);
		//taking screen shot
		screenShot.captureScreenShot("RETC_011_Login");
	}
}
