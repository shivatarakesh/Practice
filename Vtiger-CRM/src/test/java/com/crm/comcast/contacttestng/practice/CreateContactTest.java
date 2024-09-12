package com.crm.comcast.contacttestng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.practice.BaseClass;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContact() {
		System.out.println("execute create contact & verify");
	}
	@Test
	public void createContactwithSupportDate() {
		System.out.println("execute create contact with support date & verify");
	}
	

}
