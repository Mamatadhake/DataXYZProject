package com.JenkinUse.SampleProject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	 public static WebDriver driver;
	 
	 public static void HomePage() throws Exception 
	 {driver=BaseClass.DriverObject(); 
	  for(String SinglePage:Utility.PageNameList()) 
	      { driver.get(SinglePage); BaseClass.VerifyURL(SinglePage);
             List<WebElement> Buttons= driver.findElements(By.xpath("//*[@id=\"main\"]//a"));//*[@id=\"main\"]/div/div[1]//a
             for(WebElement SingleButtons:Buttons ) {String URL= SingleButtons.getAttribute("href"); BaseClass.VerifyPageURL(SingleButtons);}
	      } 
    }
	 
	 public static void  WebPage(String SinglePage) throws Exception {driver=BaseClass.DriverObject(); 
		 driver.get(SinglePage); BaseClass.VerifyURL(SinglePage);
         List<WebElement> Buttons= driver.findElements(By.xpath("//*[@id=\"main\"]//a"));//*[@id=\"main\"]/div/div[1]//a
         for(WebElement SingleButtons:Buttons ) {String URL= SingleButtons.getAttribute("href"); BaseClass.VerifyPageURL(SingleButtons);}
         driver.close();
	 }
	 public static List<String> PageNameList() 
	 {	 List<String>PageName= new ArrayList<String>();
		
		 PageName.add("https://data.xyz/");
		 PageName.add("https://data.xyz/our-data/");
		 PageName.add("https://data.xyz/why-us/");
		 PageName.add("https://data.xyz/pricing/");
		 
		 return PageName;
	 } 
		 
	 
	 
	
	 public static void main(String args[]) throws Exception {
		 Utility.HomePage();
	 }
	
   	 
	}


