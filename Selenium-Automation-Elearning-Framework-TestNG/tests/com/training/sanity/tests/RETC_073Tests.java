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
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_073POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_073Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_073POM formPagePOM;
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
		formPagePOM = new RETC_073POM(driver); 
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
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void contactFormPageTest(String username, String email, String message, String info) throws InterruptedException {
		
		//click on NewLaunch link
		formPagePOM.clickNewLaunch();
		//Click on Featured image
		formPagePOM.clickFeaturedImg();
		//Fetch data from db
		formPagePOM.sendYourName(username);
		formPagePOM.sendeMailID(email);
		formPagePOM.sendMessage(message); 
		Thread.sleep(1000);
		String expectedTitle= driver.getTitle();
		String actualTitle="Donec quis – Real Estate";
		Assert.assertEquals(actualTitle,expectedTitle);
		formPagePOM.sendInfo(info);
		Thread.sleep(1000);
		screenShot.captureScreenShot("RETC_073_DBScript");
		//Click on send button
		formPagePOM.clickSubmitbt();
		
	}
}
