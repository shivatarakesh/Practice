package com.crm.comcast.orgtestng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.practice.BaseClass;

public class CreateOrgTest extends BaseClass {
	
	@Test
	public void createOrgTest() {
		System.out.println("execute create createOrgTest & verify");
	}
	@Test
	public void createOrgWithIndustry() {
		System.out.println("execute create createOrgWithIndustry & verify");
	}
	

}
