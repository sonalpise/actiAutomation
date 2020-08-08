package com.qa.PatientRecovery;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class PatientProfile {
		
		public static WebDriver driver;
		
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
			
		 //Verify Login is working successfully
			
		/*	driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.xpath("//input[@name='submit']")).click();*/
			
			Thread.sleep(2000);
		// Verify Register Functinality working fine
			//driver.findElement(By.xpath("//input[@value='Register']")).click();
			driver.findElement(By.xpath("//a[@href='registration.php']")).click();
			
			
			  Map<String, String> objMap = new HashMap<String, String>();
			    objMap.put("FirstName", "Tiger");
			    objMap.put("LastName", "Woods");
			    objMap.put("DOB", "01/01/2009");
			    objMap.put("license", "12345678");
			    objMap.put("ssn", "666001587");
			    objMap.put("state", "OH");
			    objMap.put("city", "COLUMBUS");
			    objMap.put("address", "2199 River Run Trace");
			    objMap.put("zipcode", "43017");
			    objMap.put("age", "32");
			    objMap.put("height", "5");
			    objMap.put("weight", "120");
			    objMap.put("pharamacy", "KROGER");
			    objMap.put("pharmacyaddress", "Powell market");
			    objMap.put("email", "megantiger1@gmail.com");
			    objMap.put("username", "Megan14123");
			    objMap.put("password", "Megan211245");
			    objMap.put("confirmpass", "Megan211245");
			   // objMap.put("question", "what is your mother's name ");
			    objMap.put("answer", "molly");
			    
			     driver.findElement(By.id("firstname")).sendKeys(objMap.get("FirstName"));
			     driver.findElement(By.id("lastname")).sendKeys(objMap.get("LastName"));
			     driver.findElement(By.id("datepicker")).sendKeys(objMap.get("DOB"));
			     
			     driver.findElement(By.id("license")).sendKeys(objMap.get("license"));
			     driver.findElement(By.id("ssn")).sendKeys(objMap.get("ssn"));
			     driver.findElement(By.id("state")).sendKeys(objMap.get("state"));
			     driver.findElement(By.id("city")).sendKeys(objMap.get("city"));
			     
			     driver.findElement(By.id("address")).sendKeys(objMap.get("address"));
			     
			     driver.findElement(By.id("zipcode")).sendKeys(objMap.get("zipcode"));
			     driver.findElement(By.id("age")).sendKeys(objMap.get("age"));
			     driver.findElement(By.id("height")).sendKeys(objMap.get("height"));
			     driver.findElement(By.id("weight")).sendKeys(objMap.get("weight"));
			     driver.findElement(By.id("pharmacy")).sendKeys(objMap.get("pharamacy"));
			     driver.findElement(By.id("pharma_adress")).sendKeys(objMap.get("pharmacyaddress"));
			     
			     //Account Details 
			     
			     driver.findElement(By.id("email")).sendKeys(objMap.get("email"));
			     driver.findElement(By.id("username")).sendKeys(objMap.get("username"));
			     driver.findElement(By.id("password")).sendKeys(objMap.get("password"));
			     driver.findElement(By.id("confirmpassword")).sendKeys(objMap.get("confirmpass"));
			    
			     Select question = new Select(driver.findElement(By.id("security")));
			      question.selectByIndex(1);
				//System.out.println(question.selectByIndex(1));	
			     //driver.findElement(By.id("question")).sendKeys("question");;
			    driver.findElement(By.id("answer")).sendKeys(objMap.get("answer"));
			     
			     driver.findElement(By.xpath("//input[@name='register']")).click();
			    
			    
			    System.out.println("Elements of the Map:");
			  //  System.out.println(objMap.get("FirstName"));
			    
			    
			
	
	}

	
	

}
