package com.qa.ShoppingCart;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUser {
	
	public static WebDriver driver;
@Test
	public void Register () throws  Exception{
	System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
//	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email_create")).sendKeys("sonaltest1@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		String Currenttxt = driver.getTitle();
		System.out.println(Currenttxt);
		
		// Filling up the Register Form
		
		driver.findElement(By.id("id_gender2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("customer_firstname")).sendKeys("Sonal");
		driver.findElement(By.id("customer_lastname")).sendKeys("Testuser");
		driver.findElement(By.id("passwd")).sendKeys("test123");
		
		
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("22");
		Thread.sleep(2000);
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByIndex(2);
		Thread.sleep(2000);
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByIndex(4);
	
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Sonal");
		driver.findElement(By.id("lastname")).sendKeys("Test");
		driver.findElement(By.id("company")).sendKeys("Automation Startup");
		driver.findElement(By.id("address1")).sendKeys("105 TestRoad");
		driver.findElement(By.id("city")).sendKeys("Fanatasy Island");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByIndex(3);
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("postcode")).sendKeys("43021");
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByIndex(1);
		Thread.sleep(2000);
		
		driver.findElement(By.id("other")).sendKeys("This is Testing Automation Project");
		
		
		driver.findElement(By.id("phone")).sendKeys("614-434-6122");
		driver.findElement(By.id("phone_mobile")).sendKeys("614-892-1233");
		driver.findElement(By.id("alias")).sendKeys("Use Same Address");
		
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		
	
		
		Thread.sleep(2000);
		
		
		
		driver.close(); 
		
	}
	


/*
@BeforeClass
public void configuration()
{
	//System.setProperty("webdriver.chrome.driver", "C:\Users\pisef\workspace\JulyMaven01\BrowserExe\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
//	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	driver.get("http://demo.guru99.com/test/newtours/");
}
*/

}
