package liseners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testscripts.Base;
import utilities.Extendreport;

public class Liseners extends Base implements ITestListener {// ITestListener is a interface
	ExtentTest test;   
 	ExtentReports extent = Extendreport.createExtentReports();   
  
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();  //for thread safety
  
 	public void onTestStart(ITestResult result) {    
  
 		ITestListener.super.onTestStart(result);    
 		test = extent.createTest(result.getMethod().getMethodName());   
 		extentTest.set(test);  	}  
 	public void onTestSuccess(ITestResult result) { 
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
 	} 
  
 	public void onTestFailure(ITestResult result) { 
  
 		ITestListener.super.onTestFailure(result); 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		WebDriver driver = null; 
 		String testMethodName = result.getMethod().getMethodName(); 
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); 
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); 
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
 public void onTestSkipped(ITestResult result) {   //Called when a test is skipped. 
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		//String testMethodName = result.getMethod().getMethodName(); 
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  //Called if the test fails but still meets the defined success percentage. Rarely used. 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) {  //Called if a test fails due to a timeout 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) {  //Called at the start of a test context (e.g., suite or test tag in testng.xml). 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) {   //Called at the end of the test context. 
  
 		ITestListener.super.onFinish(context);  //Called at the end of the test context. 
 		extent.flush();  //extent.flush() saves and writes all the collected logs and test details into the final report. 
 	}
  }

