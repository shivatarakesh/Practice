package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderInvocationTest {
	
	@Test(invocationCount = 10)
	public void createOrdertest() {
		System.out.println("execute createOrderTest");
	}

}
