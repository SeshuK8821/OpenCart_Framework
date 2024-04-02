package com.qa.opencart.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() throws IOException {
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
