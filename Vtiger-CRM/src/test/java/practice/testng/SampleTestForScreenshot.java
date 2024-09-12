package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	
	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File temp=ts.getScreenshotAs(OutputType.FILE);
//		File perm=new File("./Screenshots/image.png");
//		FileHandler.copy(temp, perm);
		
		//step-1: create an object to event firing webdriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//step-2:use getScreenshotAs method to get file type of screenshot
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		
		//step-3:store screenshot on local driver
		FileUtils.copyFile(srcFile, new File("./Screenshots/image1.png"));
		driver.quit();
	
	}

}
