package com.uiOperation.action;

import org.openqa.selenium.By;

public class keywordClass extends BaseClass {
	
	
	
	public static void click(String objectName) {
		
		   //Perform click
        driver.findElement(By.xpath(objectName)).click();
	}

	
	public static void setext(String objectName , String value ) {
		
		 driver.findElement(By.xpath(objectName)).sendKeys(value);
	}
	public static void load(String url) {
		
		driver.get(url);
	}
	
	
public static void quit() {
		
		driver.quit();
	}
	
	
}
