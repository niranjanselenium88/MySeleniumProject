package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basepage.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTests extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	TestUtil testUtil;
	ContactsPage cp;
	
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle = hp.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(hp.validateUsernameOnHomePage());
	}
	
	@Test(priority=3)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(hp.validateDealsLinkOnHomePage());
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(hp.validateContactsLinkOnHomePage());
		cp = hp.clickOnContactsLink();
		System.out.println("Contacts link was clicked");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
