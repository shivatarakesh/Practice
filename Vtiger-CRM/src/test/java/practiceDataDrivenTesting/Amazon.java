package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> phones=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> prices=driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("AllPhones");
		Sheet writesh = wb.getSheet("Above60000");

		for (int i = 0; i < phones.size(); i++) {
			String names=phones.get(i).getText();
			sh.createRow(i).createCell(0).setCellValue(names);
			String price=prices.get(i).getText();
			sh.getRow(i).createCell(1).setCellValue(price);
			
		}


		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();
		

	}

}
