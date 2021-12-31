package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.Home_Page;
import com.org.PageObjects.Login_Page;
import com.org.PageObjects.Logout_Page;
import com.org.PageObjects.My_Account_Page;
import com.org.utilities.Log;

@Listeners(com.org.Listeners.Listeners.class)
public class Logout_Page_Test extends BaseClass {

	Home_Page home_page;
	Login_Page login_page;
	My_Account_Page my_account_page;
	Logout_Page logout_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationFile();
		LoadingBrowser();
		Log.startTestCase("Logout Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("Logout Page");
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

		login_page.Validte_Login();
	}
	
	@Test(priority=3)
	public void Verify_My_Account_Page() throws InterruptedException {
		
		my_account_page = new My_Account_Page();
		
		String actText = my_account_page.Validate_MyAccount_Page_Title();
		Assert.assertEquals(actText, "My Account");
		
		my_account_page.ClickOn_Logout();
	}
	
	@Test(priority=4)
	public void Verify_Logout_Page() throws InterruptedException {
		
		logout_page = new Logout_Page();
		
		logout_page.Validate_Logout_Page_Title();
		logout_page.ClickOn_Continue_Button();
	}
}
