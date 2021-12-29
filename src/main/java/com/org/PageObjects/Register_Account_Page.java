package com.org.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.Base.BaseClass;
import com.org.utilities.Log;

public class Register_Account_Page extends BaseClass {

	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement Register_Page_Title;
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement Telephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement PasswordConfirm;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	WebElement Newsletter;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement ContinueButton1;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement CongratulationsText;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement ContinueButton2;
	
	public Register_Account_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_RegisterPage_URL() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", Register_Page_Title);
		
		Log.info("Verifying Register Page URL");
		
		return driver.getCurrentUrl();
	}
	
	public void Add_Personal_Details() throws InterruptedException {
		
		Thread.sleep(2000);
		
		Log.info("Entering Personal details");
		FirstName.sendKeys(prop.getProperty("FirstName"));
		LastName.sendKeys(prop.getProperty("LastName"));
		Email.sendKeys(prop.getProperty("Email"));
		Telephone.sendKeys(prop.getProperty("Telephone"));
	}
	
	public void Create_Password() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Creating password");
		Password.sendKeys(prop.getProperty("Password"));
		PasswordConfirm.sendKeys(prop.getProperty("PasswordConfirm"));
	}
	
	public void ClickOn_Newsletter_RadioButton() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Newsletter Radio button");
		Newsletter.click();
	}
	
	public void ClickOn_PrivacyPolicy_CheckBox() {
		
		Log.info("Clicking on Privacy policy check box");
		PrivacyPolicy.click();
	}

	public void ClickOn_Continue_Button1() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Continue button1");
		ContinueButton1.click();
	}
	
	public My_Account_Page ClickOn_Continue_Button2() throws InterruptedException {
		
		Thread.sleep(2000);
		Log.info("Clicking on Continue button2");
		ContinueButton2.click();
		
		Log.info("Navigating to My Account Page");
		return new My_Account_Page();
	}
}
