package practice.homePage;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageVerificationTest {
	
	@Test
	public void homePageTest(Method mtd) {
	//	SoftAssert assertObj=new SoftAssert();
		Reporter.log(mtd.getName()+"Test Start",true);
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertEquals("Home", "Home");
	//	assertObj.assertEquals("Home", "Home-p");
		
		Reporter.log("step-3",true);
		Assert.assertEquals("Home-CRM", "Home-CRM");
		Reporter.log("step-4",true);
	//	assertObj.assertAll();
		Reporter.log(mtd.getName()+"Test end",true);
		

	
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
	//	SoftAssert assertObj=new SoftAssert();

		Reporter.log(mtd.getName()+"Test Start",true);
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertTrue(true);
	//	assertObj.assertTrue(true);

		Reporter.log("step-3",true);
		Reporter.log("step-4",true);	
	//	assertObj.assertAll();

		Reporter.log(mtd.getName()+"Test End",true);

	}

}
