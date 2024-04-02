package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil; 

	//1. Private By Locators
	private By emailId = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	
	//2. Public Page Class Const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
		
	//3. Public Page Actions/methods
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("login page title:" +title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("login page url is:" +url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public String doLogin(String username, String password) {
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(pwd, password);
		elementUtil.doClick(loginButton);

		return driver.getTitle();
	}
}
