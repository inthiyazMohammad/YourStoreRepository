package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.ForgetPassword_Page;
import com.org.PageObjects.Home_Page;
import com.org.PageObjects.Login_Page;
import com.org.utilities.Log;

@Listeners(com.org.Listeners.Listeners.class)
public class ForgetPassword_Page_Test extends BaseClass {

	Home_Page home_page;
	Login_Page login_page;
	ForgetPassword_Page forgetPassword_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationFile();
		LoadingBrowser();
		Log.startTestCase("ForgetPassword Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("ForgetPassword Page");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void Verify_Home_Page() throws InterruptedException {
		
		home_page = new Home_Page();
		
		home_page.Validate_Home_Page_Title();
		home_page.ClickOn_MyAccount_Dropdown();
		home_page.ClickOn_Login();
	}
	
	@Test(priority=2)
	public void Verify_Login_Page() throws InterruptedException {
		
		login_page = new Login_Page();
		
		login_page.Validate_ForgetPassword();
	}
	
	@Test(priority=3)
	public void Verify_ForgetPassword_Page() throws InterruptedException {
		
		forgetPassword_page = new ForgetPassword_Page();
		
		String actTitle = forgetPassword_page.Validate_ForgetPage_Text();
		
		Assert.assertEquals(actTitle, "Forgot Your Password?");
		
		forgetPassword_page.Enter_EmailAddress();
		forgetPassword_page.ClickOn_ContinueButton();
		
		String actText = forgetPassword_page.Validate_SuccessMessage();
		
		Assert.assertEquals(actText, "An email with a confirmation link has been sent your email address.");
	}
}
