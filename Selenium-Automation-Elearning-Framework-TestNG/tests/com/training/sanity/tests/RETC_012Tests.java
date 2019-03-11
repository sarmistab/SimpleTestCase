package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_012POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_012Tests {

	private static final WebElement Reset = null;
	private WebDriver driver;
	private String baseUrl;
	private RETC_012POM resetPOM;
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
		resetPOM = new RETC_012POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void validRecoverPasswordTest() {

		String expectedtext="A confirmation link has been sent to your email address";
		//click on forget password button
		resetPOM.clickForgetPass();
		//enter mail id
		resetPOM.sendEmail("manzoor@gmail.com");
		//click on reset button
		resetPOM.clickResetBtn(); 
		String actualtext=driver.findElement(By.xpath("//p[contains(text(),'The email could not be sent.')]")).getText();
		Assert.assertEquals(actualtext,expectedtext);
		screenShot.captureScreenShot("RETC_012_ResetPassword");

	}



}
