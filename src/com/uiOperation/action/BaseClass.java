package com.uiOperation.action;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.report.ExtentReportsClass;


public class BaseClass extends ExtentReportsClass {
	
	//final static Logger logger =Logger.getLogger(BaseClass.class);
	
	public static WebDriver driver ;

	public static void launchApp(String Browser){
		
		try {
					
			if (Browser.toUpperCase().contains("CHROME")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			
			//	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				/*ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				//capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				
				//driver.get(URL);
				driver.manage().deleteAllCookies();*/
				
			/*	logger.info("Chrome browser");
				logger.info("URL"+URL);
				
			*/	
				driver = new ChromeDriver();
			} else if (Browser.toUpperCase().contains("FIREFOX")) {

				
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") +"\\Driver\\geckodriver.exe");
				
				driver = new FirefoxDriver();
				
				//driver.get(URL);
				
				/*logger.info("FIREFOX");
				logger.info("URL"+URL);
*/
			} else if (Browser.toUpperCase().contains("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") +"\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();		
				//driver.get(URL);
				
			/*	logger.info("IE");
				logger.info("URL"+URL);
			*/}
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());

		
		}
		
		ExtentReportsClass.startReport();
	}
			

	public void closeApp(){
		
	//driver.close();
	
//	logger.info("Browser Close");
		
	}
	
	

}