package com.org.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class Logout_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement continueButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement logoutTitleText;
	
	public Logout_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_Logout_Page_Title() {
		
		Log.info("Validating Logout Page Title");
		return logoutTitleText.getText();
	}
	
	public void ClickOn_Continue_Button() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Logout continue button");
		continueButton.click();
	}
}
