package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

WebDriver driver;
Properties prop;

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is: " +prop.getProperty("browser"));
			switch (browserName.trim().toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
		
			default:
				System.out.println("plz pass right browser...");
				break;
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			
			return driver;
		}
	
	public Properties initProp() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
		return prop;
	}

}
