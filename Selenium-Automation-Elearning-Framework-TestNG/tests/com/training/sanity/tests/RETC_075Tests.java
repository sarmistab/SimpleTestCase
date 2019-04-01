package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.pom.RETC_075POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_075Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_075POM newLaunchPOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;



	@BeforeMethod
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		newLaunchPOM = new RETC_075POM(driver); 
		loginPOM =new RETC_011POM(driver);
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
	public void newLaunchPosts() throws InterruptedException  { 
		//Mouse over on posts link
		Actions action = new Actions(driver);
		WebElement clickposts = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		action.moveToElement(clickposts).build().perform(); 
		//Click on Add New Post link
		newLaunchPOM.clickAddNewPost();
		//Click on New Category link
		newLaunchPOM.clickAddNewCatgLink();
		//Enter Sarmista Test1 text in the Title
		newLaunchPOM.sendTitleTextbox("Sarmista Test");
		//click on the parent drop down 
		Select drpcategoryParent = new Select(driver.findElement(By.name("newcategory_parent")));
		drpcategoryParent.selectByVisibleText("Check");
		//Click on new category button
		newLaunchPOM.clickNewCatgnBtn();
		screenShot.captureScreenShot("RETC_075_NewCatAdded");
		System.out.println("New Category is added");
		//Refresh the page
		driver.navigate().refresh();
		System.out.println("Page is refreshed");
		screenShot.captureScreenShot("RETC_075_PageRefreshed");
		//Enter on Title text box
		newLaunchPOM.sendtitleText("Testing New Launch");
		Thread.sleep(3000);
		//Enter text on Text box
		newLaunchPOM.sendTextBox("New Frame Test");		
		//Click on  added feature check box 
		newLaunchPOM.clickCheckBox();
		Thread.sleep(3000);
		//Click on Publish button
		newLaunchPOM.clickPublishBtn();
		System.out.println("New Post is published");		
		Thread.sleep(2000);	
		//mouse over on Admin name
		Actions action1 = new Actions(driver);
		WebElement admin = driver.findElement(By.partialLinkText("Howd"));
		action1.moveToElement(admin).build().perform();
		//click on logout button
		newLaunchPOM.clicklogoutBtn();
		System.out.println("Admin is logged out");
		
		screenShot.captureScreenShot("RETC_075_Adminloggedout");

		String actualURL=driver.getCurrentUrl();
		String expectedURL="http://realestate.upskills.in/wp-admin/";
		assertEquals(actualURL, expectedURL);

	}
}



