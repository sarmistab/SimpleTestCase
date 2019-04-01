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
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_071POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_071Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_071POM contactFormPgPOM;
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
		contactFormPgPOM = new RETC_071POM(driver); 
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
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void contactFormPageTest(String yourName, String emailID, String subjText, String msgBox) throws InterruptedException {	
		//Click on new launch button
		contactFormPgPOM.clickNewLaunch();
		//Click on featured image
		contactFormPgPOM.clickFeaturedImg();
		System.out.println("Fetch Data from excel");
		contactFormPgPOM.sendYourName(yourName);
		contactFormPgPOM.sendeMailID(emailID);
		contactFormPgPOM.sendSubjText(subjText); 
		contactFormPgPOM.sendMsgBox(msgBox);
		//click on send button
		contactFormPgPOM.clickSubmitbt();
		Thread.sleep(2000);
		String expectedTitle= driver.getTitle();
		String actualTitle="Donec quis – Real Estate";
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println("Query sent in contant info page");
		
		screenShot.captureScreenShot("RETC_071_NewFormPage");
	}
}
