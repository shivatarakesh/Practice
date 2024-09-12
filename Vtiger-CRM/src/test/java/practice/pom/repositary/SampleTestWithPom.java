package practice.pom.repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	WebElement ele3;
	
	@Test
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888/");
		
		SampleTestWithPom s= PageFactory.initElements(driver, SampleTestWithPom.class);
	
		driver.navigate().refresh();
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("Shiva@123");
		s.ele3.click();

	}

}
