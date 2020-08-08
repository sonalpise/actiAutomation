package com.qa.testNGScripts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MultiExcelReader {
	
	public static void main(String[] args) {

		try {
			   FileInputStream fis = new FileInputStream("C:\\Users\\pisef\\Desktop\\sharevalue.xlsx");
			 
			   HSSFWorkbook workbook = new HSSFWorkbook(fis);
			 
			   HSSFSheet worksheet = workbook.getSheetAt(0);
			   
			   System.out.println(worksheet.getRow(0).getCell(0).getStringCellValue());
			 
			   Iterator<Row> ite = worksheet.rowIterator();
			   
			   while(ite.hasNext())
			   {
			    Row row =  ite.next();
			 
			    Iterator<Cell> cellIterator = row.cellIterator();
			 
			    while (cellIterator.hasNext())
			    {
			     Cell cell = cellIterator.next();
			     //Check the cell type and format accordingly
			     switch (cell.getCellType())
			     {
			     case Cell.CELL_TYPE_NUMERIC:
			      System.out.print(cell.getNumericCellValue());
			      break;
			     case Cell.CELL_TYPE_STRING:
			      System.out.print(cell.getStringCellValue()+"--");
			      break;
			     }
			    }
			    System.out.println();
			   }
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 }
		 
}




	 	
	 




