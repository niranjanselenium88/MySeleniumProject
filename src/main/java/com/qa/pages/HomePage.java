package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basepage.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[contains(text(), 'Demo User')]")
	/* It is used for performance improvement. 
	 * It will create a small memory, and stores this element in cache. When you execute the script, it gets the element from cache.
	 * Dis-advantage: If there's any change in DOM, then stale element exception is thrown and the cache value will be gone. */
	@CacheLookup
	WebElement userNameHP;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//*[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	/*Created a constructor: Then initialized all the page factory objects
	 *'this' inside the 'initElements' refer to current class objects */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUsernameOnHomePage() {
		return userNameHP.isDisplayed();
	}
	
	public boolean validateContactsLinkOnHomePage() {
		return contactsLink.isDisplayed();
	}
	
	public boolean validateDealsLinkOnHomePage() {
		return dealsLink.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		
		/*We are returning ContactsPage, because from home page when you click on Contacts, the navigation moves to Home page.
		 *Hence , written this step */
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		Action act = builder.moveToElement(contactsLink).build();
		act.perform();
		
		newContactLink.click();
	}
}
