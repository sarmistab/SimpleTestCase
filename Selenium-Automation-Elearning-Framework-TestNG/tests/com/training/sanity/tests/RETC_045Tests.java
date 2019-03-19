package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.training.pom.RETC_045POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_045Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_043POM viewPostsPOM;
	private RETC_045POM regionPOM;
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
		regionPOM=new RETC_045POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//login to the application with Admin credentials
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
		//Click on Properties link
		viewPostsPOM.clickProperties();
		//Click on Regions link
		regionPOM.clickRegions();
		//Enter Sarmista in the text box
		regionPOM.sendNameTextBox("Sarmista");
		//Enter check text in Slug text box
		regionPOM.sendSlugText("check");
		//click on the parent drop down 
		Select drpParent=new Select (driver.findElement(By.name("parent")));
		drpParent.selectByValue("24");
		//Enter description in the text box
		regionPOM.sendDescriptionText("test");
		Thread.sleep(3000);
		//Click on Add region button
		regionPOM.clickaddRegionbtn();		
		Thread.sleep(3000);
		//click on add new link
		viewPostsPOM.clickAddNew();
		// 	Enter title in the text boc	
		viewPostsPOM.sendEnterTitle("testtext1");
		//Enter text in text box
		regionPOM.sendTextBox("IBM Test"); 
		Thread.sleep(3000);
		//click on the check box
		regionPOM.clickCheckBox();
		Thread.sleep(3000);
		//click on publish button
		viewPostsPOM.clickPublish();
		
		String actualText="Edit Property";
		String expectedText=driver.findElement(By.xpath("//div//h1[contains(text(),'Edit Property')]")).getText();
		Assert.assertEquals(actualText,expectedText);
		//take screenshot after profile is updated
		screenShot.captureScreenShot("RETC_045_comments");
		
		

	}
}



