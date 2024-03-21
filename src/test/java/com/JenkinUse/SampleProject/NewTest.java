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
  public void HomePage() throws Exception{ 
	   Utility.WebPage("https://data.xyz/");
	  
  }
  @Test
  public void OurDataPage() throws Exception{ 
	   Utility.WebPage("https://data.xyz/our-data/");
	  
 }
  @Test
  public void WhyUsPage() throws Exception{ 
	   Utility.WebPage("https://data.xyz/why-us/");
	  
 }
  @Test
  public void PricingPage() throws Exception{ 
	   Utility.WebPage("https://data.xyz/pricing/");
	  
 }
 
  

}
