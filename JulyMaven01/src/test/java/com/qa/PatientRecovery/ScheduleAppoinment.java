
package com.qa.PatientRecovery;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class ScheduleAppoinment {	

	public static WebDriver driver;
	
	
	/*--------------------------PAGE ELEMENTS -----------------------------------------------------*/
	
     @FindBy(xpath="//input[@value='Create new appointment']") WebElement createbutton;
     //@FindBy(id="username") WebElement usernameTb;
   // @FindBy(name="pwd") WebElement passwordTb;
     //@FindBy(id="loginButton") WebElement loginBtn;
   
	@Test
		public void Login () throws  Exception{
		System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	
			// Verify LoginPage Link is working  Patient Profile Account 
		
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		
	
		// Verify Login is working successfully
			
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			System.out.println("Login Succesful");
			

			// Verify Schedule Information Link working
			
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/ul/li[4]/a")).click();
			System.out.println("Schedule  Appoinement Link is working fine");
			
			
			// Verify Create Appointment button is functional
					
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/ul/li[4]/a")).click();
			System.out.println("Create  Appoinement Button is working fine");
			
			//Verify Book Appoinment is functional
		
			driver.findElement(By.id("opener")).click();
			System.out.println("Book Appoinement Button is working fine");
			
	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			
	}
		
		public void Choosedate()
	
		{
			
			String dot="12/August/2020";
			String date,month,year;
			String caldt,calmonth,calyear;		
			/*
			 * Split the String into String Array
			 */
			String dateArray[]= dot.split("/");
			date=dateArray[0];
			month=dateArray[1];
			year=dateArray[2];
	 
		//	driver.findElement(By.id("DepartDate")).click();
	 

}
			
		

	

}
