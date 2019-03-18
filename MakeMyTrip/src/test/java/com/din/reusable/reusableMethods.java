package com.din.reusable;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.din.MakeMyTrip.ObjectRep;

public class reusableMethods extends Screenshot
{


	public static WebDriver driver;
	ObjectRep OR=new ObjectRep();
	
	
public void invokeurl() throws InterruptedException
{
	try {
	
	System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	driver=new ChromeDriver();
	
	System.out.println("invoked url successfully");
	
	driver.get("https://www.makemytrip.com/flights/");
	
	driver.manage().window().maximize();
	
	TakeScreenshot(driver,"URLInvoke");
	Thread.sleep(5000);
	}
	
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}


public void choosetrip(String name) throws InterruptedException, IOException
{
	WebElement getname=null;
	WebElement parent=checkelement(OR.divparent,"Parentelement");
	if(parent!=null)
	{
		List<WebElement> liname=Checkelementlistpresent(OR.litag,"litagPresent");
		if(liname!=null)
		{
			for(int i=0;i<liname.size();i++)
			{
				getname=liname.get(i);
				if(getname.getText().trim().equalsIgnoreCase(name))
				{
					click(getname,"RoundTrip");
					TakeScreenshot(driver,"ChooseTripType");
					Thread.sleep(4000);
					break;
				}
			}
		}
	
		
	}
}

public void FromCity(String name) throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver,10);
	WebElement parent=wait.until(ExpectedConditions.visibilityOf(checkelement(OR.fromcity,"From")));
	if(parent!=null)
	{
		WebElement getname=checkelementparent(parent,OR.fromcitychild,"childpresent");
		if(getname!=null)
		{
			click(getname,"from");
			
		}
	}
}




public static void sendkeys(WebElement element,String name,String elementname)
{
	element.sendKeys(name);
	System.out.println("the " +elementname+ "  is entered");
}

public static WebElement click(WebElement clicker,String elementname)
{
	clicker.click();
	System.out.println("the " +elementname+ " is clicked");
	return clicker;
}
	

public static WebElement checkelement(By element,String name)
{
	WebElement ele=null;
	try
	{
		ele=driver.findElement(element);
	}
	catch(Exception e)
	{
		System.out.println("Element not found");
	}
	
	return ele;
}

public static WebElement checkelementparent(WebElement parent,By element,String name)
{
	WebElement ele=null;
	try
	{
		ele=parent.findElement(element);
	}
	catch(Exception e)
	{
		System.out.println("Element not found");
	}
	
	return ele;
}

public static List<WebElement> Checkelementlistpresent(By element,String elementname)
{
	List<WebElement> list=null;
	try
	{
		list=driver.findElements(element);
		System.out.println("the " +elementname+ " is present");
	}
	catch(Exception e)
	{
		System.out.println("THe " +elementname+ " is not present");
	}
	return list;
}






public void teardown()
{
	driver.quit();
}


}
