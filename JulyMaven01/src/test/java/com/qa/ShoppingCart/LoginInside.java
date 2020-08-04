package com.qa.ShoppingCart;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginInside{
	
	public static WebDriver driver;
@Test
	public void Login () throws  Exception{
	System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
//	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.id("email")).sendKeys("sonaltest@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("test123");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		Thread.sleep(2000);
		driver.close();
		
		
} 
}
