package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BasePack.BaseClass;

import ExtentReports.ExtentsDemo;

public class ListenersClass extends BaseClass implements ITestListener {

	ExtentTest test;
	
	ExtentReports extent=ExtentsDemo.config();

	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();  //to make thread safe using this class
	
	@Override
	public void onTestStart(ITestResult result) {
	
	test=extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);;

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
      extentTest.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		extentTest.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//takes screenshot and attach to reports
		String filepath = null;
		try {
			filepath = takescreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
