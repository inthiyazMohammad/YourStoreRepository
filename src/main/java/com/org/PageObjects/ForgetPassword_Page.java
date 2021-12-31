package com.org.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class ForgetPassword_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement fotgetpageTitleText;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	WebElement continueButton;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	WebElement successmessage;
	
	public ForgetPassword_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_ForgetPage_Text() {
		
		Log.info("Validating Forget password Title text");
		return fotgetpageTitleText.getText();
	}
	
	public void Enter_EmailAddress() throws InterruptedException {
		
		Thread.sleep(1000);
		Log.info("Entering E-mail address");
		emailAddress.sendKeys(prop.getProperty("emailaddress"));
	}
	
	public void ClickOn_ContinueButton() throws InterruptedException {
		
		Thread.sleep(1000);
		Log.info("Clicking on continue button");
		continueButton.click();
	}
	
	public String Validate_SuccessMessage() {
		
		return successmessage.getText();
	}
}
