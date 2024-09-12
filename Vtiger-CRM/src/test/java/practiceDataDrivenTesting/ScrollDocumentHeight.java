package practiceDataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class ScrollDocumentHeight {
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		long documentHeight=(long)js.executeScript("return document.body.scrollHeight;");
		System.out.println(documentHeight);
		driver.quit();
	}
	

}
