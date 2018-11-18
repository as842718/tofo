package com.uiOperation.action;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.report.ExtentReportsClass;

import net.bytebuddy.implementation.bytecode.constant.LongConstant;

public class keywordClass extends BaseClass {
		
	
	public static void click(String objectName) {		
		   //Perform click
		//ExtentReportsClass.startReport().startTest("tests");
	//	extent.startTest("TestCaseName", "Description");
		try {
        driver.findElement(By.xpath(objectName)).click();
        childTest=parentTest.createNode("Action : CLICK");
    	childTest.log(Status.PASS, MarkupHelper.createLabel("Click", ExtentColor.BLUE));
        
      //  ExtentReportsClass.passTest("CLick Button","");
		}catch(Exception e) {
			 childTest=parentTest.createNode("Action : CLICK");
			childTest.log(Status.FAIL, MarkupHelper.createLabel("Fail to Click", ExtentColor.RED));
	
		}
		
		
		}

	
	public static void setext(String objectName , String value ) {
		try {
		 driver.findElement(By.xpath(objectName)).sendKeys(value);
		
		 childTest=parentTest.createNode("Action : Enter value");
			childTest.log(Status.PASS, MarkupHelper.createLabel("Enter value "+value, ExtentColor.BLUE));	
		// ExtentReportsClass.passTest("Entet Field","Input Text Value: "+value);
		}catch(Exception e) {
			 childTest=parentTest.createNode("Action : Enter value");
			childTest.log(Status.FAIL, MarkupHelper.createLabel("Fail to enter value", ExtentColor.RED));
			
		}
		
		}
	public static void load(String url) {
		try {
		driver.get(url);
		childTest=parentTest.createNode("Open Application URl");
		childTest.log(Status.INFO,"URL: "+url);
		childTest.log(Status.PASS, MarkupHelper.createLabel("Applaciton URL is open", ExtentColor.BLUE));
		}catch(Exception e) {
			childTest=parentTest.createNode("Open Application URl");
			childTest.log(Status.FAIL, MarkupHelper.createLabel("Fail to load", ExtentColor.RED));
		}
		
		
		}
	
	
public static void quit() {
		try {
		driver.quit();
		 childTest=parentTest.createNode("Close Appliaction");
		 childTest.log(Status.PASS, MarkupHelper.createLabel("Quit Appliaction ", ExtentColor.BLUE));
		
	}catch(Exception e) {
		 childTest=parentTest.createNode("Close Appliaction");
		 childTest.log(Status.PASS, MarkupHelper.createLabel("Fail Quit Appliaction ", ExtentColor.RED));
		
		
	}
		finally{
			ExtentReportsClass.endReport();
		}
		}
	
	
}
