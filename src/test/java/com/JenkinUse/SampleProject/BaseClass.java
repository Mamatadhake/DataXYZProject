package com.JenkinUse.SampleProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static  WebDriver driver;
	public static void BrokenURL() throws Exception {
	
	  driver=BaseClass.DriverObject();
	//  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://machintel.com/content-hub/");
	  
		 List<WebElement>pagination= driver.findElements(By.xpath("//*[contains(@class,'p-2 rounded-lg border border-gray-200 shadow-md')]"));
		 
		 for(WebElement Singlepage:pagination) {
			  List<WebElement> blogDiv= driver.findElements(By.xpath("//*[@data-type='Blog' or @data-type='E-Book' or data-type='Infographic'or data-type='Case Study'or data-type='Webinar'or data-type='Whitepaper']"));
			  for(WebElement SingleBlog: blogDiv) {
				  String href=SingleBlog.getAttribute("href");
				  URL url = new URL(SingleBlog.getAttribute("href"));
				  HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				     //head request to minimal response
			      if(urlConnection.getResponseCode()==200)
			      {	 System.out.println(SingleBlog.getAttribute("href")+"\n"+"Is not broken");}
			      else {System.out.println(SingleBlog.getAttribute("href")+"\n"+"Is  broken");}
			                                                                           }pagination();  // BLOG FOR EACH LOOP
		                                                                                   }// PAGE FOR EACH LOOp
		 driver.close();
	 }  // MAIN METHOD END
	 			
  
	
	public static void pagination()
	{  WebElement NextButton= driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[4]/button[contains(text(),'next')]"));
	   if(NextButton.isDisplayed()) {	NextButton.click();}
	}
	

  public static WebDriver DriverObject() 
  {     WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         driver=new ChromeDriver(options);
         driver.manage().window().maximize();
	     return driver;
   }
  
  public static void VerifyURL(String Name) throws Exception
  {
	          URL url= new URL(Name);
	    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
	    	  if(Conn.getResponseCode()==200){ System.out.println(Name+" "+"Page is Working"+"\n");}
	    	  else {System.out.println(Name+" "+"Page is not working"+"\n");}
  }
 
  public static void VerifyPageURL(WebElement  SingleButtons) throws Exception
  {
	          URL url= new URL(SingleButtons.getAttribute("href"));
	    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
	    	  if(Conn.getResponseCode()==200){ System.out.println(SingleButtons.getText()+" "+"Button URL is Working"+"\n");}
	    	  else {System.out.println(SingleButtons.getText()+" " +"Button URL is not working"+"\n");}
  }
}


