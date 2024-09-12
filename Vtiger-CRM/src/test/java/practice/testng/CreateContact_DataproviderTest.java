package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataproviderTest {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName, long phoneNum) {
		
		System.out.println("FirstName : "+firstName+", LastName : "+lastName +", PhoneNum : "+phoneNum);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="shiva";
		objArr[0][1]="s";
		objArr[0][2]=1234567890l;
		
		objArr[1][0]="deepak";
		objArr[1][1]="hr";
		objArr[1][2]=1234567890l;
		
		objArr[2][0]="jhon";
		objArr[2][1]="smith";
		objArr[2][2]=1234567890l;
		
		return objArr;
	}

}
