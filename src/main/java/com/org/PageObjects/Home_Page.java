package com.org.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class Home_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement MyAccount_Dropdown;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement Register;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement Login;
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_Home_Page_Title() {
		
		Log.info("Verifying Home Page Title");
		return driver.getTitle();
	}
	
	public void ClickOn_MyAccount_Dropdown() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on My Account Drop-down");
		MyAccount_Dropdown.click();
	}
	
	public Register_Account_Page ClickOn_Register() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Register");
		Register.click();
		
		return new Register_Account_Page();
	}

	public Login_Page ClickOn_Login() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Login");
		Login.click();
		
		return new Login_Page();
	}
}
