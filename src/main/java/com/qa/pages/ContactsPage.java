package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.basepage.TestBase;
import com.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//*[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[contains(text(), 'Aman Test')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//*[@name='contact_id']")
	WebElement amanTestCheckBox;
	
	@FindBy(xpath="//*[@id='first_name']")
	WebElement firstNameTestbox;
	
	@FindBy(xpath="//*[@id='surname']")
	WebElement lastNameTestbox;
	
	@FindBy(xpath="//*[@name='client_lookup']")
	WebElement companyTestbox;
	
	@FindBy(xpath="//input[@value='Load From Company']//following::input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	/*Created a constructor: Then initialized all the page factory objects
	 *'this' inside the 'initElements' refer to current class objects */
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void validateSingleContactCheckbox() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		amanTestCheckBox.isDisplayed();
		amanTestCheckBox.click();
	}
	
	public void createNewContact(String title, String ft_Name, String lt_Name, String cmpny) throws InterruptedException {
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstNameTestbox.sendKeys(ft_Name);
		lastNameTestbox.sendKeys(lt_Name);
		companyTestbox.sendKeys(cmpny);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		saveButton.click();
		
	}
}
