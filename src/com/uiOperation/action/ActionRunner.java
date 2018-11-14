package com.uiOperation.action;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ActionRunner implements Runnable {

	public List<List<String>> uIData;
	
	private String getbrowserType;
	
	public ActionRunner(List<List<String>> uIData,String getbrowserType) {
		super();
		this.uIData = uIData;
		this.getbrowserType= getbrowserType;
		
	}
	
	@Override
	public void run() {	
		System.out.println("run selenium");
		LaunchBrowser();
		try {
			readData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	public void LaunchBrowser() {
		BaseClass.launchApp(getbrowserType);
	}
	
	
	
	ArrayList<String> newdata = new ArrayList<>();
	
	public ArrayList<String>  readData() throws Exception {
	
		int i,j;
		
			for(i=0;i<uIData.size();i++) {
			/*for(j=0;j<4;j++) {*/			
			
			//	System.out.print(uIData.get(i).get(j)+"--->"+"\n");
				
				
				System.out.println("key-"+uIData.get(i).get(0));
				System.out.println("loc-"+uIData.get(i).get(1));
				System.out.println("Value-"+uIData.get(i).get(2));
				
				//System.out.println("Value-"+uIData.get(i).get(4));
				
				if(!(uIData.get(i).get(0)==" "&&uIData.get(i).get(1)==" "&&uIData.get(i).get(2)==" ")){
				UIKeywordOperation.perform(uIData.get(i).get(0), uIData.get(i).get(1),uIData.get(i).get(2));
				}
				
				else {break;}
				//System.out.println("Step-"+uIData.get(j));
				
			
			
		/*	}*/
		
		//	UIOperation.performOperation(uIData.get(i).get(0), uIData.get(i).get(1),uIData.get(i).get(2),uIData.get(i).get(3));
		//	newdata.addAll(uIData.get(j));
		/*	System.out.println("Step-"+newdata.get(0));
			System.out.println("Locator-"+newdata.get(1));
			System.out.println("Value-"+newdata.get(2));*/
		
		//	UIOperation.performOperation(newdata.get(0), newdata.get(1), newdata.get(2));
			
			}
			
			//System.out.println(newdata);
		return newdata;
	}
	
	public void callUIOperation() throws Exception {
	
		readData();	
		
		System.out.println("Step-"+newdata.get(0));
		System.out.println("Locator-"+newdata.get(1));
		System.out.println("Value-"+newdata.get(2));
		
		
		//UIOperation.performOperation(newdata.get(0), newdata.get(1), newdata.get(2));
		
		
	}
	

}