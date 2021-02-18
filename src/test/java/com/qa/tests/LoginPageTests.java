package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basepage.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTests extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTests() {
		super(); // It will call it's super class constructor. Then all my properties are initialized
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String loginTitle = lp.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
