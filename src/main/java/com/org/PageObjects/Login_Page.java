package com.org.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class Login_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
	WebElement forgetPasswordLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginButton;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void Validte_Login() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Entering E=Mail address");
		emailAddress.sendKeys(prop.getProperty("EmailId"));
		Log.info("Entering password");
		password.sendKeys(prop.getProperty("Password1"));
		
		Thread.sleep(2000);
		Log.info("Clicking on Login button");
		loginButton.click();
	}
	
	public ForgetPassword_Page Validate_ForgetPassword() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Forget Password link");
		forgetPasswordLink.click();
		
		Log.info("Navigating to ForgetPassword page");
		return new ForgetPassword_Page();
	}
}
