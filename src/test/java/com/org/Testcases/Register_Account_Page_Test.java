package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.Home_Page;
import com.org.PageObjects.Register_Account_Page;
import com.org.utilities.Log;

public class Register_Account_Page_Test extends BaseClass {

	Home_Page home_page;
	Register_Account_Page register_account_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationFile();
		LoadingBrowser();
		Log.startTestCase("Register Account Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("Register Account Page");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void Verify_Home_Page() throws InterruptedException {
		
		home_page = new Home_Page();
		
		home_page.Validate_Home_Page_Title();
		home_page.ClickOn_MyAccount_Dropdown();
		home_page.ClickOn_Register();
	}
	
	@Test(priority=2)
	public void Verify_RegisterPage_URL() {
		
		register_account_page = new Register_Account_Page();
		
		String actURL = register_account_page.Validate_RegisterPage_URL();
		Assert.assertEquals(actURL, prop.getProperty("regPageURL"));
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void Verify_Registration_Page() throws InterruptedException {
		
		register_account_page = new Register_Account_Page();
		
		register_account_page.Add_Personal_Details();
		register_account_page.Create_Password();
		register_account_page.ClickOn_Newsletter_RadioButton();
		register_account_page.ClickOn_PrivacyPolicy_CheckBox();
		register_account_page.ClickOn_Continue_Button1();
	//	Assert.assertTrue(true);
		register_account_page.ClickOn_Continue_Button2();
	}
}
