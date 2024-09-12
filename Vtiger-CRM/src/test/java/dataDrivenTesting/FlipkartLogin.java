package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLogin {

	public static void main(String[] args) throws IOException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> mobilenames=driver.findElements(By.className("KzDlHZ"));
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet("Sheet3");
		for(int i=0;i<mobilenames.size();i++) {
			String name=mobilenames.get(i).getText();
			String price=driver.findElement(By.xpath("//div[text()='"+name+"']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']")).getText();
		
			sheet.createRow(i).createCell(0).setCellValue(name);
			sheet.getRow(i).createCell(1).setCellValue(price);
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();

	}

}
