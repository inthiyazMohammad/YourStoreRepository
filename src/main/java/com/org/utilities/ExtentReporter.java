package com.org.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	
	public static ExtentReports getExtentReports() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\extentReport.html");
		
		htmlReporter.config().setReportName("Your Store Extent Report Name");
		htmlReporter.config().setDocumentTitle("Your Store Extent Report Title");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Project Name", "Your Store (e-Cart)");
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Browser", "Chrome and Firefox");
		extentReport.setSystemInfo("Tested By", "Inthiyaz Mohammad");
		
		return extentReport;
	}
	
}
