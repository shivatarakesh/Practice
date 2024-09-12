package hardCodedScripts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewContactwithExistingOrganisation {

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
			System.out.println("home page is not displayed");
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if (driver.getTitle().contains("Contacts")) {
			System.out.println("Contacts Page is Displayed");
		} else {
			System.out.println("Contacts page is not displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement pageHeader=driver.findElement(By.className("lvtHeaderText"));
		if(pageHeader.isDisplayed()) {
			System.out.println("Creating new contact");
		}
		else {
			System.out.println("New contact is not clicked");
		}
		driver.findElement(By.name("lastname")).sendKeys("sktuf");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String windowId =driver.getWindowHandle();
		Set<String> windowIds =driver.getWindowHandles();
		for(String id:windowIds) {
			driver.switchTo().window(id);
		}
		driver.findElement(By.xpath("//a[text()='abcdef']")).click();
		driver.switchTo().window(windowId);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		

	}

}
