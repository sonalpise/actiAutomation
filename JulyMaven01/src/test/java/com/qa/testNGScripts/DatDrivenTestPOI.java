package com.qa.testNGScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Xls_dataProvider;

public class DatDrivenTestPOI {

	WebDriver driver;
	// pass the name of data provide method as parameter to thsi test method

	@BeforeClass
	public void startbrowser() {
		System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");

	}

	@Test(dataProvider = "testdataxlsx")
	public void wikipagedata(String name, String password, String retype, String email) {
		driver.findElement(By.id("wpName2")).clear();

		driver.findElement(By.id("wpName2")).sendKeys(name);

		driver.findElement(By.id("wpPassword2")).clear();
		driver.findElement(By.id("wpPassword2")).sendKeys(password);
		driver.findElement(By.id("wpRetype")).clear();
		driver.findElement(By.id("wpRetype")).sendKeys(retype);
		driver.findElement(By.id("wpEmail")).clear();
		driver.findElement(By.id("wpEmail")).sendKeys(email);
	}

	@DataProvider(name = "testdataxlsx")
	public Object[][] readExcel() throws InvalidFormatException, EncryptedDocumentException, IOException {
		Object input[][] = Xls_dataProvider.getTestData("Sheet1");
		return input;
	}

}