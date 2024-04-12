package com.JenkinUse.SampleProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Attentity {
	 static ExtentTest test;
	 static ExtentReports report;
	@BeforeClass
	public static void StartTest() {
		report= new ExtentReports(System.getProperty("user.dir")+"\\LOGS\\ExtentReport.html");
		test=report.startTest("Extent");
}
	@Test(enabled=true)
	public void AttentityHomePage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 1, 0));
	  }
	@Test(enabled=true)
	public void AttentityGraphPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 2, 0));
	  }
	@Test(enabled=true)
	public void AttentityDataPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 3, 0));
	  }
	@Test(enabled=true)
	public void AttentityDataLicensingPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 4, 0));
	  }

	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
