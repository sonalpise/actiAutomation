package com.qa.testNGScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnoNew {
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login First");
		
	}
	
	@Test(priority='1')
	public void createuser()
	{
		System.out.println("Create  First User");
	}
	
	@Test(priority='3')
	public void deleteuser()
	{
		System.out.println("Delete  First User");


	}
	
	
	
	
	

}
