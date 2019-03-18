package com.din.InvokeMethods;



import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.din.reusable.reusableMethods;

public class MainInvoke 
{

	reusableMethods rm=new reusableMethods();
	
	@BeforeMethod
	
	public void Setup()
	{
		try 
		{
			
			
			rm.invokeurl();
			
			
		} 
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	
	public void mainmethods() throws InterruptedException, IOException
	{
	rm.choosetrip("Round Trip");
	rm.FromCity("Chennai");
	}
	
	
	@AfterMethod
	
	public void quit()
	{
		rm.teardown();
	}
	
	
}
