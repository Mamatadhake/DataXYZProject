package com.JenkinUse.SampleProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	 public static WebDriver driver;
	 static ExtentTest test;
	 static ExtentReports report;
	 
	 
	 //************************************************************* WEBDRIVER OBJECT **************************************************************************//
	 public static WebDriver DriverObject() 
	  {     WebDriverManager.chromedriver().setup();
	         ChromeOptions options = new ChromeOptions();
	         driver=new ChromeDriver(options);
	         driver.manage().window().maximize();
		     return driver;
	  }
	 
	 //**********************************************************WebDriverWait*************************************************************************************//
	 public static void WebDriverWait() {
		 driver=DriverObject();
		// org.openqa.selenium.support.ui.WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 }
	 
	 //*********************************************************** DATA.XYZ WEBPAGES***************************************************************************//
	 public static void  WebPage(String SinglePage) throws Exception 
	 {   driver=Utility.DriverObject(); 
	       int Num=0;
		  driver.get(SinglePage); VerifPageURL(SinglePage,  Num);
		 
          List<WebElement> Buttons= driver.findElements(By.xpath("//*[@id=\"main\"]//a"));//*[@id=\"main\"]/div/div[1]//a
          for(WebElement SingleButtons:Buttons ) {String URL= SingleButtons.getAttribute("href"); VerifySubURL(SingleButtons, Num);Num++;}
         driver.close();
	 }
	
	 
	 //************************************************************ VERIFY PAGE URL******************************************************************************//
	 public static void VerifPageURL(String Name, int Num) throws Exception // for  page URL
	  {          report= ExtentReport();
  	         	             URL url= new URL(Name);
		    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
		    	  if(Conn.getResponseCode()==200){ System.out.println(Name+" "+"Page is Working"+"\n");
		    	  test.log(LogStatus.PASS,test.addScreenCapture(Utility.CaptureScreenshot(Num))+"Page is working");	}
		    	  else {System.out.println(Name+" "+"Page is not working"+"\n");
		      	  test.log(LogStatus.FAIL,test.addScreenCapture(Utility.CaptureScreenshot(Num))+"Page is not working");		    	}
		    	  report.endTest(test);
		    	  report.flush();
	  } 	 
	 //******************************************EXTENTREPORT.html**************************************************************************************//
	    public static ExtentReports ExtentReport() 
	    {report=new ExtentReports(System.getProperty("user.dir")+"\\LOGS\\ExtentReport.html");
		 test=report.startTest("Extent");
		 return report;
		}
	    
	    //*****************************************SCREENSHOTEXTENTREPORT*******************************************************************************//
		 public static String CaptureScreenshot(int Num) throws Exception {
		 TakesScreenshot screenshot= (TakesScreenshot)driver;
		 File source= screenshot.getScreenshotAs(OutputType.FILE);
		 File Destination=new File(System.getProperty("user.dir")+"\\LOGS"+"\\"+"Image"+"-"+Num+".png");
		 System.out.print(System.getProperty("user.dir")+"\\LOGS"+"CaptureScreenshot");
		 String Dest=Destination.getAbsolutePath();
		 FileUtils.copyFile(source, Destination);
		 return Dest;
		 }
	    
	 //*********************************************************VERIFY Sub_URL*******************************************************************************//
	 
	 public static void VerifySubURL(WebElement  SubURL, int Num) throws Exception // For Button URL
	  {          report=ExtentReport();         	  
	          	  URL url= new URL(SubURL.getAttribute("href"));
		    	  HttpURLConnection Conn=(HttpURLConnection)url.openConnection();
		    	  if(Conn.getResponseCode()==200)
		    	  { test.log(LogStatus.PASS,test.addScreenCapture(Utility.CaptureScreenshot(Num))+"SubURL is Working");}	
		    	  else { test.log(LogStatus.FAIL,test.addScreenCapture(Utility.CaptureScreenshot(Num))+"SubURL is not Working"); }
		    	   report.endTest(test);
		    	  report.flush();
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


