package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure " + result.getName());
		
		ITestContext context= result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File("C:\\Program Files\\Eclips\\eclipse-workspace\\InetBanking\\Screenshots\\"+filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}

	public void onStart(ISuite arg0) {
		System.out.println("onStart");
	}

	public void onFinish(ISuite context) {
		System.out.println("onFinish");
	}

}
