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
import com.training.pom.RETC_042POM;
import com.training.pom.RETC_043POM;
import com.training.pom.RETC_044POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_044Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_043POM viewPostsPOM;
	private RETC_044POM featurePOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;



	@BeforeMethod
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		viewPostsPOM = new RETC_043POM(driver); 
		loginPOM =new RETC_011POM(driver);
		featurePOM=new RETC_044POM(driver);
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
	public void validAllPsotsTest() throws InterruptedException  { 


		viewPostsPOM.clickProperties();
		System.out.println("Clicked on Properties Link");
		featurePOM.clickFeature();
		System.out.println("Clicked on Freature Link");
		featurePOM.sendNameTextBox("Sarmis");

		featurePOM.sendSlugText("check");

		featurePOM.sendDescription("Test Case verifivation");

		Thread.sleep(3000);

		featurePOM.clickAddNewFeature();
		System.out.println("Added new Freature");
		Thread.sleep(3000);

		viewPostsPOM.clickAddNew();
		System.out.println("Clicked on Add New Link");
		viewPostsPOM.sendEnterTitle("Test");

		viewPostsPOM.sendTextBox("Sarmista"); 
		Thread.sleep(3000);

		featurePOM.clickCheckBox();
		System.out.println("Clicked on Feature check box");

		viewPostsPOM.clickPublish();
		System.out.println("Published");

		String actualTitle="Add Property ‹ Real Estate — WordPress";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		//take screenshot after profile is updated
		screenShot.captureScreenShot("RETC_044_PostCreated");



	}
}



