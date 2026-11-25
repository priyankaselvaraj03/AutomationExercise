package com.tp.AutomationExercise.generic.listenerUtility;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tp.AutomationExercise.generic.basetest.BaseClass;

public class LinstenerImplementation implements ITestListener, ISuiteListener {
	
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configruation");
		String report_name=suite.getName();
		// Spark reort config
		String time = new java.util.Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/"+report_name+"_"+time+".html");
		spark.config().setDocumentTitle("Test suite");
		spark.config().setReportName("Test");
		spark.config().setTheme(Theme.DARK);

		// add env info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows10");
		report.setSystemInfo("browser", "chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====" + result.getMethod().getMethodName() + "===Start===");
		test = report.createTest(result.getMethod().getMethodName());
		
		test.log(Status.INFO,result.getMethod().getMethodName()+"========STARTED=========");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====" + result.getMethod().getMethodName() + "===end===");
		test.log(Status.PASS,result.getMethod().getMethodName()+"========COMPLETED=========");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot t = (TakesScreenshot)BaseClass.sdriver;
		String filepath = t.getScreenshotAs(OutputType.BASE64);
		String time = new java.util.Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,name+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"========FAILED=========");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,result.getMethod().getMethodName()+"========SKIPPED=========");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
