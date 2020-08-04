package com.qa.testNGScripts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


	
	public class writeinExcel {
		@Test
		public void write() throws IOException
		{
	        //define the file path where excel sheet will be generated
	//	String filepath= (".\\excelsheet\\write.xlsx");
			String filepath="C:\\Users\\pisef\\workspace\\JulyMaven01\\src\\test\\java\\excelsheet\\write.xlsx";
		File file= new File(filepath);
		FileOutputStream fos=new FileOutputStream(file);
	        //create the blank workbook
		Workbook wb= new XSSFWorkbook();
	        //create the blank excel sheet
		Sheet sh= wb.createSheet("Webkul");
		//define the position in the excel sheet where write operation needs to perform
	        Row rw= sh.createRow(4);
		Cell cl=rw.createCell(1);
	        //define input type
		cl.setCellType(CellType.STRING);
	        //define the data value
		cl.setCellValue("Webkul Software");
	        //write the workbook
		wb.write(fos);
		}
	}
	
	
	
	