package com.org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.org.utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public void ConfigurationFile() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		
		Log.info("Loading Configuration properties file");
		prop =new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+
				                                  "\\src\\main\\java\\com\\org\\Configuration\\data.properties");
		prop.load(file);
	}
	
	public void LoadingBrowser() {
		
		Log.info("Loading browser");
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Log.info("Loading Application");
		driver.get(prop.getProperty("url"));
	}
	
	public String getScreenshot(String testName) throws IOException {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		
		File sourceFilePath = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destFilePath = System.getProperty("user.dir")+"\\Screendhots\\"+testName+".png";
		
		FileUtils.copyFile(sourceFilePath, new File(destFilePath));
		
		return destFilePath;
	}
}
