package Machintel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.JenkinUse.SampleProject.Utility;

public class MachintelPages {
	
	static int Num=0;
	static WebDriver driver;
	public static void WhatWeDo() throws Exception {
		
		driver= Utility.DriverObject();
	    driver.get("https://machintel.com/");
    	driver.findElement(By.id("mega-menu-button")).click();
	   driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div[1]/ul/li[2]/a")).click();
	   List<WebElement> Pages=driver.findElements(By.xpath("//*[@id=\"mega-menu\"]/div/ul/li/a"));
	   for(WebElement page:Pages) {
		   
		   String PageURL= page.getAttribute("href");
		  Utility.VerifPageURL(PageURL, Num);
		     Num++;
	   }
		
		
		
	}
	
	public static void CTALink() throws Exception {
		driver= Utility.DriverObject();
		
		List<WebElement>ClickButton=driver.findElements(By.xpath("//*[@id=\"main\"]/div//a"));
		
		for(WebElement button:ClickButton) {
			Utility.VerifySubURL(button, Num);
			Num++;
		}
		
		
	}
public static void main(String []args) throws Exception {
	
	
	MachintelPages.WhatWeDo();
}
}
