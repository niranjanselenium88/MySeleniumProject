package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basepage.TestBase;

public class LoginPage extends TestBase {
	
	/*Page Factory for all the web elements on Login page*/
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(), 'Sign Up')]")
	WebElement signupBtn;
	
	/*Created a constructor: Then initialized all the page factory objects
	 *'this' inside the 'initElements' refer to current class objects */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*Actions: */
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginBtn.click();
		
		/*We are returning HomePage, because logically after login, the navigation moves to Home page.
		 *Hence , written this step */
		return new HomePage();
	}
}
