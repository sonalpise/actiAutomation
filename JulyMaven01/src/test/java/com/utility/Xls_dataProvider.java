package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xls_dataProvider {

	public static String testdata_sheet_path = "C:\\Users\\pisef\\Desktop\\testdata.xlsx";

	public static Object[][] getTestData(String sheetName)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		// public static void main(String[] args) throws IOException,
		// EncryptedDocumentException, InvalidFormatException {

		Workbook wb = WorkbookFactory.create(new File("C:\\Users\\pisef\\Desktop\\testdata.xlsx"));

		Sheet sheet = wb.getSheet("Sheet1");
		Object[][] inputData = new Object[5][4]; // << Learn: how to get size of
													// the data dynamically

		int rowStart = sheet.getFirstRowNum();
		int rowEnd = sheet.getLastRowNum();

		for (int i = 1; i < rowEnd; i++) {
			Row row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				inputData[i][j] = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
			}
			System.out.println("-------");
		}
		System.out.println(inputData.toString());
		return inputData;
	}

}
