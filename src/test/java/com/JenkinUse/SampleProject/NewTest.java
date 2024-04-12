package com.JenkinUse.SampleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {  
	 static ExtentReports report;
	 
	
	@Test(enabled=false)
	public void MachintelContent() throws Exception{
		  
		  BaseClass.BrokenURL();
	  }
  
  @Test(enabled=true)
  public void HomePage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("DataXYZ", 1, 0));
	  
  }
  @Test(enabled=false)
  public void OurDataPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("DataXYZ", 2, 0));
	  
 }
  @Test(enabled=false)
  public void WhyUsPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("DataXYZ", 3, 0));
	  
 }
  @Test(enabled=false)
  public void PricingPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("DataXYZ", 4, 0));
	  
 }
  @Test(enabled=false)
  public void ContentHubPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("DataXYZ", 5, 0));
	  
 }
 
    

}
