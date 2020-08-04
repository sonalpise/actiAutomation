package com.qa.testNGScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


public class excelsheet {

	@Test
	  public void excel() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException { 
	                //get the excel sheet file location               
	             //   String filepath=".\\excelsheet\\testdata.xlsx";
		String filepath="C:\\Users\\pisef\\workspace\\JulyMaven01\\src\\test\\java\\excelsheet\\testdata.xlsx";
		              Workbook wb= new WorkbookFactory().create(new FileInputStream(new File(filepath)));
	                //get the sheet which needs read operation
			            Sheet sh = wb.getSheet("sheet1");
	                //get the total row count in the excel sheet	
			            int rowcount = sh.getLastRowNum();
			              for (int i = 0; i <= rowcount; i++) 
	                  {
	                    // get the total cell count in the excel sheet
				               int cellcount = sh.getRow(i).getLastCellNum();
				                  for (int j = 0; j < cellcount; j++) 
	                        {                         
	                            //get cell value at the given position [i][j]
			                        String value = sh.getRow(i).getCell(j).getStringCellValue();
	                            //print the cell value
					                    System.out.println(value);
					
				                   }			
			                }	
			          }
	

}
