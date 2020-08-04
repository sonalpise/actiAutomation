package com.qa.testNGScripts;

import java.io.File;
import java.io.IOException;
import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcel {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		Workbook wb = WorkbookFactory.create(new File("C:\\Users\\pisef\\Desktop\\testdata.xlsx"));
			
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			
			for(int i=0; i<rowEnd; i++){
				Row row = sheet.getRow(i);
				for(int j=row.getFirstCellNum(); j<row.getLastCellNum(); j++){
					Cell cell = row.getCell(j);
					System.out.println(cell.getStringCellValue());
				}
				System.out.println("-------");
			}
		
	}

}
