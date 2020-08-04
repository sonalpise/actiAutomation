package com.qa.testNGScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGAnno1 {
	
@Test
public void login()
{
	
//	WebDriver driver = new ChromeDriver();
	//driver.get("https://www.godaddy.com/");
	
	/*Test Case 2 - Open Godaddy.com and maximize browser window.*/
	
//	driver.manage().window().maximize();  /*Test CAse 2*/
	System.out.println("TEST FOR FIRST");
	
}


@Test
public void registerCustomer()
{
	System.out.println("TEST FOR SECOND");
}

}
