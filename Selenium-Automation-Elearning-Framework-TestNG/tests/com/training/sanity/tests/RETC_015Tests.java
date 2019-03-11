package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_015POM;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_013POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_015Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_015POM logoutPOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeMethod
	public void setUp() throws Exception {


		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);


		driver = DriverFactory.getDriver(DriverNames.CHROME);
		logoutPOM = new RETC_015POM(driver); 
		loginPOM =new RETC_011POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//login into the application
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
	public void validLogoutTest() {
		String actualURL=driver.getCurrentUrl();
		//mouse over admin link
		Actions action = new Actions(driver);
		WebElement admin = driver.findElement(By.partialLinkText("Howd"));
		action.moveToElement(admin).build().perform(); 
		// click logout
		logoutPOM.clickLogout();
		String expectedURL="http://realestate.upskills.in/wp-admin/";
		assertEquals(actualURL, expectedURL);
		screenShot.captureScreenShot("RETC_015_Logout");
		


	}
}



