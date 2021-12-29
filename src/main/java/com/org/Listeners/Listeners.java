package com.org.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.Base.BaseClass;
import com.org.utilities.ExtentReporter;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReports();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		extentTestThread.set(extentTest);
		extentTest = extentReport.createTest(testName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		extentTestThread.get().log(Status.PASS, testName+" got passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		extentTestThread.get().log(Status.FAIL, result.getThrowable());
	//	extentTestThread.get().fail(result.getThrowable());
		
		try {
			String screenshotFilePath = getScreenshot(testName);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
