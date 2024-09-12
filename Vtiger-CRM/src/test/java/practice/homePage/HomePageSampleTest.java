package practice.homePage;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageSampleTest {
	
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		String expectedPage="Home";
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Shiva@123");
		driver.findElement(By.id("submitButton")).submit();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert

		Assert.assertEquals(actTitle, expectedPage);
//		if(actTitle.equals(expectedPage)) {
//			System.out.println(expectedPage+"Page is verified==PASS");
//		}
//		else {
//			System.out.println(expectedPage+"Page is not verified==FAIL");
//		}
		driver.close();
		System.out.println(mtd.getName()+"Test end");

		
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Shiva@123");
		driver.findElement(By.id("submitButton")).submit();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		Assert.assertEquals(true, status);
//		Assert.assertTrue(status);
//		if (status) {
//			System.out.println(" Logo is verified==PASS");
//		}
//		else {
//			System.out.println(" Logo is not verified==FAIL");
//		}
		driver.close();
		System.out.println(mtd.getName()+"Test End");

	}

}
