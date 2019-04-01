package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_011POM;
import com.training.pom.RETC_074POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_074Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_074POM changeRolePOM;
	private RETC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeMethod
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		changeRolePOM = new RETC_074POM(driver); 
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
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void contactFormPageTest(String Name, String new_role) throws InterruptedException {

		//Click on Users link
		changeRolePOM.clickUsersLink();
		//Click on New All Users link
		changeRolePOM.clickallUsersLink();
		//Click on user check box
		changeRolePOM.clickCheckBox();
		//click on the Role change drop down 
		Select drpcategoryParent = new Select(driver.findElement(By.name("new_role")));
		drpcategoryParent.selectByVisibleText(new_role);
		Thread.sleep(1000);
		//Click on new category button
		changeRolePOM.clickChangeBtn();
		Thread.sleep(1000);
		String expectedTitle= driver.findElement(By.xpath("//p[contains(text(),'Changed roles.')]")).getText();
		String actualTitle="Changed roles.";
		Assert.assertEquals(actualTitle,expectedTitle);
		screenShot.captureScreenShot("RETC_074_RoleChanged");
		System.out.println("Role is changed for user");
	}
}