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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_042Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_042POM allPostsPOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;



	@BeforeMethod
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		allPostsPOM = new RETC_042POM(driver); 
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
	public void validAllPsotsTest() throws InterruptedException  { 
//Click posts link
		allPostsPOM.clickPosts();
		System.out.println("Posts Clicked");
//Click new posts link
		allPostsPOM.clicknewPost();
//Enter Title
		allPostsPOM.sendEnterTitle("Test post2");
//Enter in the text box
		allPostsPOM.sendTextBox("IBM Test"); 
//Click publish button
		Thread.sleep(3000);
		allPostsPOM.clickPublish();
		System.out.println("Publish button is clicked. Post published. View post message is displayed");
//Click on All posts link
		allPostsPOM.clickAllPost();
//Click on the created post 
		allPostsPOM.clickPostCreated();
//print
		System.out.println("Created post is clicked and details of post are displayed");


		String expectedtext="Edit Post";
		String actualtext=driver.findElement(By.xpath("//h1[contains(@class,'wp-heading-inline')]")).getText();
		Assert.assertEquals(actualtext,expectedtext);
		//take screenshot after profile is updated
		screenShot.captureScreenShot("RETC_042_PostCreated");


	}
}



