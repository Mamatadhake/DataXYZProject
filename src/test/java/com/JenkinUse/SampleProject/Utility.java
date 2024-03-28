package com.JenkinUse.SampleProject;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	 public static WebDriver driver;
	 
	 //************************************************************* WEBDRIVER OBJECT **************************************************************************//
	 public static WebDriver DriverObject() 
	  {     WebDriverManager.chromedriver().setup();
	         ChromeOptions options = new ChromeOptions();
	         driver=new ChromeDriver(options);
	         driver.manage().window().maximize();
		     return driver;
	  }
	 
	 //*********************************************************** DATA.XYZ WEBPAGES***************************************************************************//
	 public static void  WebPage(String SinglePage) throws Exception 
	 {   driver=Utility.DriverObject(); 
		  driver.get(SinglePage); VerifPageURL(SinglePage);
		 
          List<WebElement> Buttons= driver.findElements(By.xpath("//*[@id=\"main\"]//a"));//*[@id=\"main\"]/div/div[1]//a
          for(WebElement SingleButtons:Buttons ) {String URL= SingleButtons.getAttribute("href"); VerifySubURL(SingleButtons);}
         driver.close();
	 }
	
	 
	 //************************************************************ VERIFY PAGE URL******************************************************************************//
	 public static void VerifPageURL(String Name) throws Exception // for  page URL
	  {
		          URL url= new URL(Name);
		    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
		    	  if(Conn.getResponseCode()==200){ System.out.println(Name+" "+"Page is Working"+"\n");}
		    	  else {System.out.println(Name+" "+"Page is not working"+"\n");}
	  } 
	 //*********************************************************VERIFY Sub_URL*******************************************************************************//
	 
	 public static void VerifySubURL(WebElement  SubURL) throws Exception // For Button URL
	  {
		          URL url= new URL(SubURL.getAttribute("href"));
		    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
		    	  if(Conn.getResponseCode()==200){ System.out.println(SubURL.getText()+" "+"SubURL is Working"+"\n");}
		    	  else {System.out.println(SubURL.getText()+" " +"SubURL is not working"+"\n");}
	  }
	//*************************************************************** GET VALUE FROM EXCEL SHEET********************************************************//
	 public static String GetURL(String SheetName, int row, int cell) throws Exception
	  { String File="TestData.xlsx";
	     File file =    new File(File);
	     FileInputStream inputStream = new FileInputStream(file);
	     XSSFWorkbook wb=new XSSFWorkbook(inputStream);    
	     XSSFSheet sheet =wb.getSheet(SheetName);
	     String Value=sheet.getRow(row).getCell(cell).getStringCellValue();
	     return Value;
	  }
   	 
	 //******************************************PAGINATION FUNCTION**********************************************************************************//
	 public static void pagination()
		{  WebElement NextButton= driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[4]/button[contains(text(),'next')]"));
		   if(NextButton.isDisplayed()) {	NextButton.click();}
		}

	}


