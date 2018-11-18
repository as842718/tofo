package com.report;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportsClass{
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static ExtentHtmlReporter htmlReports;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	static String fileName= System.getProperty("user.dir") +"/test-output/STMExtentReport.html";
	
	
	public static void startReport(){
		
		htmlReports = new ExtentHtmlReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		
		htmlReports.config().setReportName("Regression");
		htmlReports.config().setTestViewChartLocation(ChartLocation.TOP);
		parentTest = extent.createTest("New TestCase_1");
		System.out.println("Inside 1");
			//	return extent;
	}
		
/*
	public static void passTest(String testcasenaem,String desc){
		
	
		//logger=extent.startReporter(reporterType, filePath)
		logger=extent.startTest(testcasenaem,desc);
		logger.log(LogStatus.INFO,desc);
		logger.log(LogStatus.PASS,testcasenaem);
	}
	

	public static void failTest(String testcasenaem,String desc){
	logger = extent.startTest(testcasenaem);
	//	Assert.assertTrue(false);
		logger.log(LogStatus.INFO,desc);
		logger.log(LogStatus.FAIL,testcasenaem);
	}
	

	public void skipTest(){
		logger = extent.startTest("skipTest");
	//	throw new SkipException("Skipping - This is not ready for testing ");
	}
	*/

	/*public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	*/
	public static void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
            //   extent.close();
    }
}
