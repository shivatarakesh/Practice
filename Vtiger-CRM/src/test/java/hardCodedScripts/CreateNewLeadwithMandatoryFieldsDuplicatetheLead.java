package hardCodedScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewLeadwithMandatoryFieldsDuplicatetheLead {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if (driver.getTitle().contains("vtiger CRM")) {
			System.out.println("Login Page Displayed");
		}

		else {
			driver.quit();
		}
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Shiva@123");
		driver.findElement(By.id("submitButton")).submit();

		if (driver.getTitle().contains("Home")) {
			System.out.println("HOME Page is Displayed");
		} else {
			driver.quit();
		}
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		if (driver.getTitle().contains("Leads")) {
			System.out.println("leads Page is Displayed");
		} else {
			System.out.println("leads page is not displayed");
		}
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		WebElement pageHeader=driver.findElement(By.className("lvtHeaderText"));
		if(pageHeader.isDisplayed()) {
			System.out.println("Creating new lead");
		}
		else {
			System.out.println("New lead is not clicked");
		}
		driver.findElement(By.name("lastname")).sendKeys("abcde");
		driver.findElement(By.name("company")).sendKeys("abcdef");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String leadPageHeader=driver.findElement(By.className("dvHeaderText")).getText();
		if(leadPageHeader.contains("abcde")) {
			System.out.println("new lead is created");
		}
		else {
			System.out.println("new lead is not created");
		}
		driver.findElement(By.name("Duplicate")).click();
		String DuplicatePageHeader=driver.findElement(By.className("lvtHeaderText")).getText();
		if(DuplicatePageHeader.contains("Duplicating")) {
			System.out.println("duplicating page is displayed");
		}
		else {
			System.out.println("duplicating page is not displayed");
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.quit();
		
		
	}

}
