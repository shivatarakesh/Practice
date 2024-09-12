package com.crm.generic.baseutility.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to Db,Report Config===");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("===Launch The Browser===");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("===Login===");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("===Logout===");
	}
	@AfterClass
	public void configAC() {
		System.out.println("===Close The Browser===");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("===connect to Db,Report Backup===");
	}
	
}
