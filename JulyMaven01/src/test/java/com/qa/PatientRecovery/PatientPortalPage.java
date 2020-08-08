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
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 1. Verify MPP LOGO visible 
 2. Verify Links avaialble for Profile , Schedule Appointment 
 3.Logout Link is Visible and Functional 
 
 */

public class PatientPortalPage {
	
	public static WebDriver driver;
	
	/*--------------------------PAGE ELEMENTS -----------------------------------------------------*/
	
    @FindBy(xpath="//a[@href='index.php']") WebElement homelink;
    @FindBy(xpath="//a[@href='profile.php']") WebElement profilelink;
    @FindBy(xpath="//a[@href='sheduleappointments.php']") WebElement scheduleapp;
  //  @FindBy(xpath="img[@src='images/Health Insurance Logo.png']") WebElement logo;
    
   
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
			

			// . Verify MPP LOGO visible 
			
	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			
	}
		
	
			
		

			  


}
