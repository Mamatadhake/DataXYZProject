package com.JenkinUse.SampleProject;

import org.testng.annotations.Test;

public class Attentity {
	
	@Test(enabled=true)
	public void AttentityHomePage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 1, 0));
	  }
	@Test(enabled=true)
	public void AttentityGraphPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 2, 0));
	  }
	@Test(enabled=true)
	public void AttentityDataPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 3, 0));
	  }
	@Test(enabled=true)
	public void AttentityDataLicensingPage() throws Exception{
		  
		  Utility.WebPage(Utility.GetURL("Attentity", 4, 0));
	  }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
