package com.JenkinUse.SampleProject;

import org.openqa.selenium.WebDriver;

public class Data {
 public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  driver=BaseClass.DriverObject();
			//  driver.switchTo().newWindow(WindowType.WINDOW);
			  driver.get("https://data.xyz/");
	}

}
