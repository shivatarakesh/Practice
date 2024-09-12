package hardCodedScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hp.com/in-en/home.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		if(driver.getTitle().contains("Laptop Computers")) {
			System.out.println("home page is displayed");
		}
		
		else {
			System.out.println("script failed");
		}
		driver.findElement(By.name("search-bar")).sendKeys("i5laptops");
		

	}

}
