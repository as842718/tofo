package com.uiOperation.action;


import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class UIKeywordOperation {
    WebDriver driver;
    public UIKeywordOperation(WebDriver driver){
        this.driver = driver;
    }
    public static void perform(String operation,String objectName,String value) throws Exception{
     
    	switch (operation) {
        
        case "Click":
        	keywordClass.click(objectName);
            break;
        
        case "Enter Text":
            //Set text on control
        	keywordClass.setext(objectName, value);
            break;
            
        case "loadURL":
            //Get url of application
            keywordClass.load(value);
            break
            
       ;
       
            
        case "Close Browser":
        keywordClass.quit();
        default:
            break;
        }
    }
    
    /**
     * Find element BY using object type and value
     * @param p
     * @param objectName
     * @param objectType
     * @return
     * @throws Exception
     */
    private By getObject(Properties p,String objectName,String objectType) throws Exception{
        //Find by xpath
        if(objectType.equalsIgnoreCase("XPATH")){
            
            return By.xpath(p.getProperty(objectName));
        }
        //find by class
        else if(objectType.equalsIgnoreCase("CLASSNAME")){
            
            return By.className(p.getProperty(objectName));
            
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
            
            return By.name(p.getProperty(objectName));
            
        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){
            
            return By.cssSelector(p.getProperty(objectName));
            
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){
            
            return By.linkText(p.getProperty(objectName));
            
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            
            return By.partialLinkText(p.getProperty(objectName));
            
        }else
        {
            throw new Exception("Wrong object type");
        }
    }
    
}