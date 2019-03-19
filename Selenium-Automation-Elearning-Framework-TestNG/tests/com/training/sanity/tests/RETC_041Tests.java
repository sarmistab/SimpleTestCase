package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_041POM;
import com.training.pom.RETC_042POM;
import com.training.pom.RETC_043POM;
import com.training.pom.RETC_044POM;
import com.training.pom.RETC_045POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_041Tests {

	private WebDriver driver;
	private String baseUrl;
	private String baseUrl1;
	private RETC_041POM blogPOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		blogPOM = new RETC_041POM(driver); 
		loginPOM =new RETC_011POM(driver);
		baseUrl1= properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl1);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();

	}
	@Test(priority=1)
	public void validBlogTest() throws InterruptedException  { 

		//Click on Blog link
		blogPOM.clickBlog();		
		//Click on ReadMode link
		blogPOM.clickReadMore();
		Thread.sleep(3000);
		//Enter text on Comment box
		blogPOM.sendCommentText("Pristine");
		//Enter Name
		blogPOM.sendNameText("Sarmi");
		//Enter email id
		blogPOM.sendEmailAddress("test123@gmail.com");
		//Click on post comment button
		blogPOM.clickPostCommentbtn();
		System.out.println("Comment is posted");

	}

	@Test (priority=2)
	public void validLoginTest() throws InterruptedException  { 
		// opening admin link in new Tab
		WebElement element =driver.findElement(By.tagName("body"));
		element.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("http://realestate.upskills.in/wp-admin/");
		System.out.println("Opening New Window for Admin login");
		//login to the application with Admin credentials
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		//click on login button
		loginPOM.clickLoginBtn(); 
		System.out.println("Logged in as Admin");
		//click on Comments link
		blogPOM.clickCommentsLink();
		System.out.println("Comments Page is loaded");
		String actualText="Comments";
		String expectedText=driver.findElement(By.xpath("//div//h1[contains(text(), 'Comments')]")).getText();
		Assert.assertEquals(actualText,expectedText);
		//take screenshot after profile is updated
		screenShot.captureScreenShot("RETC_041_Comments Page");



	}
}



