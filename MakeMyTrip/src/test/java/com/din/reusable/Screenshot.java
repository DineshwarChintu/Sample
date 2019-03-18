package com.din.reusable;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{

	public static int IMPLICIT_WAIT;
	
	
	public static void TakeScreenshot(WebDriver driver,String Filename) throws IOException
	{
		TakesScreenshot screen=((TakesScreenshot)driver);
		File source= screen.getScreenshotAs(OutputType.FILE);
		
		File destination= new File("E:\\workspace\\MakeMyTrip\\src\\test\\Screenshot\\Screenshot_" +Filename+".png");
		
		FileUtils.copyFile(source,destination);
	}
	
	
	
}
