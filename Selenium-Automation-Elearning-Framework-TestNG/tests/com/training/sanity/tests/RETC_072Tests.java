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
import com.training.pom.RETC_072POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_072Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_072POM formPagePOM;
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
		formPagePOM = new RETC_072POM(driver); 
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
	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void contactFormPageTest(String yourName, String emailID, String subjText, String msgBox) throws InterruptedException {
		
		formPagePOM.clickNewLaunch();
		formPagePOM.clickFeaturedImg();		
		formPagePOM.sendYourName(yourName);
		System.out.println("Entering incorrect emailId");
		formPagePOM.sendeMailID(emailID);
		Thread.sleep(2000);
		formPagePOM.sendSubjText(subjText); 
		formPagePOM.sendMsgBox(msgBox);
		Thread.sleep(1000);
		formPagePOM.clickSubmitbt();
		String expectedTitle= driver.getTitle();
		String actualTitle="Donec quis – Real Estate";
		Assert.assertEquals(actualTitle,expectedTitle);
		screenShot.captureScreenShot("RETC_072_NewFormPage");
	}
}
