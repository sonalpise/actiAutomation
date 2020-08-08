package com.qa.PatientRecovery;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jxl.read.biff.BiffException;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class RegisterPatientFromxls {
	
	public static WebDriver driver;
	public static HashMap<String, String> sharePriceExcelValuesfromXLS;
	
	
	/*--------------------------PAGE ELEMENTS -----------------------------------------------------*/
	
    @FindBy(xpath="//a[@href='index.php']") WebElement homelink;
    @FindBy(xpath="//a[@href='profile.php']") WebElement profilelink;
    @FindBy(xpath="//a[@href='sheduleappointments.php']") WebElement scheduleapp;
	
    public static void main(String args[])
				throws BiffException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException {

   
		/*System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='registration.php']")).click();*/
		
    	  Workbook wb =  WorkbookFactory.create(new File("C:/Users/pisef/workspace/JulyMaven01/src/test/java/excelsheet/Patientdata.xlsx"));
    	  
    	  Sheet mysheet = wb.getSheet("Sheet1");
    	  int firstRow = mysheet.getFirstRowNum();
    	  int lastRow = mysheet.getLastRowNum();
    	  String key = null;
		String val = null;
    	  for(int i=1; i<=lastRow; i++){
    		  Row row = mysheet.getRow(i);
    		  for(int j=row.getFirstCellNum(); j<row.getLastCellNum(); j++){
    			  Cell cell= row.getCell(j);
    			  CellType celltype = row.getCell(j).getCellTypeEnum();
    			  
    			  
    			  switch(cell.getCellTypeEnum()){
    			  case  cell.CELL_TYPE_STRING:
    			  {
    				  key = cell.getStringCellValue();
    				  val = cell.getStringCellValue();
    				  sharePriceExcelValuesfromXLS.put(key,val);	
    				  break;
    			  }
    			  case cell.CELL_TYPE_NUMERIC: 
    			  {
    				  key = cell.getStringCellValue();
    				  val = String.valueOf(cell.getNumericCellValue());
    				  sharePriceExcelValuesfromXLS.put(key,val);	  
    				  break;
    			  }
    			 
    			  
    			  } // End Switch Case 
    			  
    			  
    			  
    		  }// cols
    	  } // rows
    	  
		
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
		    
	    
	
	} // Main Class Closing 
	
	
	
}
