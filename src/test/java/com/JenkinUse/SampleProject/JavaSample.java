package com.JenkinUse.SampleProject;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaSample {

	  static  WebDriver driver;
		public static void main(String []args) throws Exception {
		
		WebDriverManager.chromedriver().setup();

		  ChromeOptions options = new ChromeOptions();
	      
	   driver=new ChromeDriver(options);
////			  System.setProperty("webdriver.chrome.driver","D://Automation//Software//chromedriver_win32//chromedriver.exe"); 
////			  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.switchTo().newWindow(WindowType.WINDOW);
		  driver.get("https://data.xyz/");
		  
		  WebElement tryf= driver.findElement(By.linkText("Try for free"));
		  URL url= new URL(tryf.getAttribute("href"));
		  HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		  if(urlConnection.getResponseCode()==200){
			     System.out.println(tryf.getAttribute("href")+"Is not broken");
		   }else {System.out.println(tryf.getAttribute("href")+"Is  broken");}
   }
		
}
