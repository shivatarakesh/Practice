package hardCodedScripts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisationwithMandatoryFields {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		if(driver.getTitle().contains("vtiger CRM")) {
			System.out.println("Login Page Displayed");
		}
		
		else {
			driver.quit();
		}
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Shiva@123");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home")) {
			System.out.println("HOME Page is Displayed");
		}
		else {
			driver.quit();
		}
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		if(driver.getTitle().contains("Organizations")) {
			System.out.println("Organisations page is displayed");
		}
		else {
			driver.quit();
		}
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		WebElement pageHeader=driver.findElement(By.className("lvtHeaderText"));
		if(pageHeader.isDisplayed()) {
			System.out.println("Creating new organisation page is dsplayed");
		}
		else {
			driver.quit();
		}
		driver.findElement(By.name("accountname")).sendKeys("shiva2");
		driver.findElement(By.name("button")).click();
		String newOrgPageHeader =driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(newOrgPageHeader.contains("shiva2"))
		driver.findElement(By.name("Delete")).click();
		Thread.sleep(2000);
		Alert a1=driver.switchTo().alert();
		a1.accept();

		WebElement logout=driver.findElement(By.className("small"));
		Actions a2=new Actions(driver);
		a2.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
					
	}

}
