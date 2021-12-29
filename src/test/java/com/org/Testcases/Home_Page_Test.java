package com.org.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.Base.BaseClass;
import com.org.PageObjects.Home_Page;
import com.org.utilities.Log;

public class Home_Page_Test extends BaseClass {

	Home_Page home_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationFile();
		LoadingBrowser();
		Log.startTestCase("Home Page");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.endTestCase("Home Page");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void Verify_Home_Page_Title() {
		
		home_page = new Home_Page();
		
		String actTitle = home_page.Validate_Home_Page_Title();
		
		Assert.assertEquals(actTitle, "Your Store");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	public void Verify_MyAccount_Dropdown() throws InterruptedException {
		
		home_page = new Home_Page();
		
		Thread.sleep(1000);
		home_page.ClickOn_MyAccount_Dropdown();
	}
	
	@Test(priority=3)
	public void Verify_Register() throws InterruptedException {
		
		home_page = new Home_Page();
		
		home_page.ClickOn_Register();		
	}
	
/*	@Test(priority=4)
	public void Verify_Login() {
		
		home_page = new Home_Page();
		
		home_page.ClickOn_Login();
	} */
}
