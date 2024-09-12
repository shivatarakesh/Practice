package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderTest {
	
	@Test
	public void createOrdertest() {
		System.out.println("execute createOrderTest");
//		String str=null;
//		System.out.println(str.equals("abc"));
	}
	
	@Test(dependsOnMethods = "createOrdertest")
	public void BillingAndOrdertest() {
		System.out.println("execute billing Order Test");
	}
	
	

}
