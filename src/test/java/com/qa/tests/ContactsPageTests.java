package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.basepage.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTests extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	TestUtil testUtil;
	ContactsPage cp;
	
	String sheetName = "ContactsData";
	
	public ContactsPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		cp = new ContactsPage();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		hp.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabel() {
		Assert.assertTrue(cp.validateContactsLabel());
	}
	
	@Test(priority=2)
	public void verifySingleContactsCheckbox() throws InterruptedException {
		Thread.sleep(1000);
		cp.validateSingleContactCheckbox();
	}
	
	@DataProvider
	public Object[][] getFreeCRMData() {
		Object[][] data = TestUtil.getDataFromExcel(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getFreeCRMData")
	public void validateCreateNewContact(String title, String ft_name, String lt_name, String cmpny) throws InterruptedException {
		hp.clickOnNewContactLink();
		cp.createNewContact(title, ft_name, lt_name, cmpny);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
