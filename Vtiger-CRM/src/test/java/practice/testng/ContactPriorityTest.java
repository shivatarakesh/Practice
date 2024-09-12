package practice.testng;

import org.testng.annotations.Test;

public class ContactPriorityTest {
	@Test(priority = 1)
	public void createContactTest(){
		System.out.println("execute createcontact");
	}
	
	@Test(priority = 2)
	public void modifyContactTest(){
		System.out.println("execute modifycontact");
	}
	
	@Test(priority = 3)
	public void deleteContactTest(){
		System.out.println("execute deletecontact");
	}

}
