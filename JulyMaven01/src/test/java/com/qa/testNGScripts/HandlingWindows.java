package com.qa.testNGScripts;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
	
	public static WebDriver driver;
	
	public static void main(String[] args) 
	{ 
	

		System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		//Switching to a iframe to fetch the details of the price
	 	driver.switchTo().frame("moneyiframe");
		driver.findElement(By.id("query")).sendKeys("TCS");
		driver.findElement(By.cssSelector(".mw001-widget-getquote-btn")).submit();
		
		//Switching to a top window
		driver.switchTo().defaultContent();
 
		//Confirmation about the focus is using getTitle() method
		String title = driver.getTitle();
		System.out.println("Title::"  + title);
 
		String url = driver.getCurrentUrl();
		System.out.println("url is ::: " + url);
 
		//Browsers totally Opened By Webdriver -3
		//1. rediff -13
		//2. rediffmoney-13
		//3. popup-13
		//Method fetches the name of the window which has focus
		String parent = driver.getWindowHandle();
		System.out.println("Name of the window:::" + parent);
		//Set is a DataStructure available in the package java.util
		//Set allows unique values.It doest not allow duplicates compared to list.
		//Set cannot be retrieved using index. So,set is not index based like list.
		//Number of elements in the set can be retrieved using size() method
		//Method fetches all the names of the window
		Set<String> wSet= driver.getWindowHandles();
		System.out.println("Number of windows:::" + wSet.size());
 
		System.out.println("################Logic 1 - Using Enhanced for loop#################");
		for(String x :  wSet)
		{
			if(!(x.equals(parent)))
			{
				driver.switchTo().window(x);
				System.out.println("Title:::"+ driver.getTitle());
				if(driver.getTitle().contains("Tata"))
				{
					String price = driver.findElement(By.id("ltpid")).getText();
					System.out.println("The price is:::" + price);
				}
			}
		}
		System.out.println("########################Logic 2 - Using Iterator###################");
		Iterator<String> it = wSet.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println("Title:::"+ driver.getTitle());
			if(driver.getTitle().contains("Tata"))
			{
				String price = driver.findElement(By.id("ltpid")).getText();
				System.out.println("The price is:::" + price);
			}
		}
		System.out.println("###################Logic 3 - Using Single Dimension Array#############");
		Object[] wNames =  wSet.toArray();
		for(int i=0;i<wNames.length;i++)
		{
			driver.switchTo().window(wNames[i].toString());
			System.out.println("Title:::"+ driver.getTitle());
			if(driver.getTitle().contains("Tata"))
			{
				String price = driver.findElement(By.id("ltpid")).getText();
				System.out.println("The price is:::" + price);
			}
		}
	}

}
