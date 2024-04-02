package com.qa.opencase.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.tests.BaseTest;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains("route=account/login"));
	}
	
	@Test (priority = 3)
	public void forgotPwd() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test (priority = 4)
	public void doLogin() {
		String accPageTitle = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(accPageTitle,"My Account");
	}
}
