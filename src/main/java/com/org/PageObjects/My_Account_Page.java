package com.org.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class My_Account_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement myAccountPageTitle;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement logout;
	
	public My_Account_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_MyAccount_Page_Title() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", logout);
		
		return myAccountPageTitle.getText();
	}
	
	public Logout_Page ClickOn_Logout() throws InterruptedException {
				
		Thread.sleep(2000);
		Log.info("Clicking on Logout link");
		logout.click();
		
		return new Logout_Page();
	}
}
