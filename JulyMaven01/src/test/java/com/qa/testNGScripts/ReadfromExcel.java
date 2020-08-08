package com.qa.testNGScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadfromExcel {
	
	public static WebDriver driver;

	public static HashMap<String, String> sharePriceExcelValuesfromXLS;
	public static HashMap<String, String> sharePriceExcelValuesfromWEB;
	public static Locale locale = Locale.US;

	
	/*****************************************
	 * 	Test case to compare current price of stocks.
	 * 	Test data is provided from excel file, while 
	 * 	current prices are obtained from the web page.
	 * 
	 *****************************************/
	public static void main(String args[])
			throws BiffException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException {

		sharePriceExcelValuesfromXLS = readXLSFile("C:/Users/pisef/workspace/JulyMaven01/src/test/java/excelsheet/datasharenew.xls");
		sharePriceExcelValuesfromWEB = readDatafromWEB();

		// System.out.println(sharePriceExcelValuesfromXLS.values().toArray()[1]
		// + " - " +
		// sharePriceExcelValuesfromXLS.values().toArray()[1].getClass().getName());
		// System.out.println(sharePriceExcelValuesfromWEB.values().toArray()[1]
		// + " - " +
		// sharePriceExcelValuesfromWEB.values().toArray()[1].getClass().getName());

		String expected = sharePriceExcelValuesfromXLS.get("Gulf Oil Lubricants");
		String actual = sharePriceExcelValuesfromWEB.get("Gulf Oil Lubricants");

		Set<String> keyList = sharePriceExcelValuesfromXLS.keySet();
		for (String key : keyList) {
			System.out.println("Different Values Found " + key);
			if (sharePriceExcelValuesfromXLS.get(key).equals(sharePriceExcelValuesfromWEB.get(key)))
				System.out.println("Pass. Values Found (File vs Web) " + sharePriceExcelValuesfromXLS.get(key) + " vs "
						+ sharePriceExcelValuesfromWEB.get(key));
			else
				System.out.println("Fail. Values (File vs Web) " + sharePriceExcelValuesfromXLS.get(key) + " vs "
						+ sharePriceExcelValuesfromWEB.get(key));
			System.out.println();
		}
	} // main

	
	/******************************
	 * 	Reading the data from WEB page
	 * 
	 ******************************/
	public static HashMap<String, String> readDatafromWEB() throws ParseException {
		System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://money.rediff.com/gainers/nse");

		List<WebElement> currentPriceList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
		List<WebElement> companyList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("CompanyList contains " + currentPriceList.size() + " records");
		HashMap<String, String> sharePriceExcelValuesfromWEB = new HashMap<String, String>();
		for (int i = 0; i < companyList.size(); i++) {
			NumberFormat nf = NumberFormat.getInstance(locale);
			Number val = nf.parse(currentPriceList.get(i).getText().trim());
			System.out.println(">> WEB: " + companyList.get(i).getText().trim() + " : " + String.valueOf(val));
			sharePriceExcelValuesfromWEB.put(companyList.get(i).getText().trim(), String.valueOf(val));
		}
		return sharePriceExcelValuesfromWEB;
	} // readDatafromWEB

	
	/****************************** 	
	 * 	Reading the data from XLS file	 
	 * 
	 ******************************/
	public static HashMap<String, String> readXLSFile(String fileName)
			throws IOException, BiffException, EncryptedDocumentException, InvalidFormatException {
		HashMap<String, String> sharePriceExcelValuesfromXLS = new HashMap<String, String>();
		
		Workbook wb = WorkbookFactory.create(new File(fileName));
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
		int rowStart = sheet.getFirstRowNum();
		int rowEnd = sheet.getLastRowNum();

		for (int i = 0; i <= rowEnd; i++) {
			Row row = sheet.getRow(i);
			String key = null;
			String val = null;
			for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (j % 2 == 0) { 
					key = cell.getStringCellValue();
				} else {
					val = String.valueOf(cell.getNumericCellValue());
				}
			}
			System.out.println(">> FILE: " + key + " : " + val);
			sharePriceExcelValuesfromXLS.put(key, val);
		}
		return sharePriceExcelValuesfromXLS;
	} // readXLSFile

}
