package com.JenkinUse.SampleProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static  WebDriver driver;
	public static void BrokenURL() throws Exception 
	{ driver=Utility.DriverObject();
  	  //  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://machintel.com/content-hub/");
	  
	  List<WebElement>pagination= driver.findElements(By.xpath("//*[contains(@class,'p-2 rounded-lg border border-gray-200 shadow-md')]"));
	  
	  for(WebElement Singlepage:pagination) 
	  { List<WebElement> blogDiv= driver.findElements(By.xpath("//*[@data-type='Blog' or @data-type='E-Book' or data-type='Infographic'or data-type='Case Study'or data-type='Webinar'or data-type='Whitepaper']"));
	  
		 for(WebElement SingleBlog: blogDiv) 
		 {  String url= SingleBlog.getAttribute("href"); 
		     Utility.VerifPageURL(url);				  
		  }Utility.pagination();  // BLOG FOR EACH LOOP
		  
	  }// PAGE FOR EACH LOOp
		 driver.close();
		 
	 }  // MAIN METHOD END
	 			
  
	
	

 
  
}


