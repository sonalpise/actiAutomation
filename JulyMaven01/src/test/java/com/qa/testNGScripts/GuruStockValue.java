package com.qa.testNGScripts;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class GuruStockValue {
	

	    public static void main(String[] args) throws ParseException {
	    	WebDriver driver;
	    	
	    	System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
	        driver.get("http://demo.guru99.com/test/web-table-element.php");         
	        //No.of Columns
	        List  col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	        System.out.println("No of cols are : " +col.size()); 
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
	        System.out.println("No of rows are : " + rows.size());
	       
	    		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    		 WebElement baseTable = driver.findElement(By.tagName("table"));
	    		  
	    		 //To find third row of table
	    		 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
	             String rowtext = tableRow.getText();
	    		 System.out.println("DATA in the 3rd of table : "+rowtext);
	    		    
	    		    //to get 3rd row's 2nd column data
	    		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
	    		    String valueIneed = cellIneed.getText();
	    		    System.out.println("Cell value is : " + valueIneed); 
	    		    driver.close();
	    
	        
	

	    }
	    }
