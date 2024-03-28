package com.JenkinUse.SampleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {  
	
	@Test
	public void MachintelContent() throws Exception{
		  
		  BaseClass.BrokenURL();
	  }
  
  @Test(enabled=false)
  public void HomePage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("URL", 1, 0));
	  
  }
  @Test(enabled=false)
  public void OurDataPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("URL", 2, 0));
	  
 }
  @Test(enabled=false)
  public void WhyUsPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("URL", 3, 0));
	  
 }
  @Test(enabled=false)
  public void PricingPage() throws Exception{ 
	   Utility.WebPage(Utility.GetURL("URL", 4, 0));
	  
 }
 

  
  

}
