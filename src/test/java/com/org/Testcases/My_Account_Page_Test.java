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
import com.org.PageObjects.My_Account_Page;
import com.org.utilities.Log;

@Listeners(com.org.Listeners.Listeners.class)
public class My_Account_Page_Test extends BaseClass {

	Home_Page home_page;
	Login_Page login_page;
	My_Account_Page my_account_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationFile();
		LoadingBrowser();
		Log.startTestCase("My Account Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("My Account Page");
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
	}
}
