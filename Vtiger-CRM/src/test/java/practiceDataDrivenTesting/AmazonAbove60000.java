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

public class AmazonAbove60000 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> phones = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet readsh = wb.getSheet("AllPhones");
		Sheet writesh = wb.getSheet("Above60000");
		int rowNo=0;

		for (int i = 0; i <= readsh.getLastRowNum(); i++) {
			Row readRow = readsh.getRow(i);

			Cell readCell = readRow.getCell(1);
			Cell readCell2 = readRow.getCell(0);
			String data = readCell2.getStringCellValue();
			String data1 = readCell.getStringCellValue();
			int priceWithoutComma = Integer.parseInt(data1.replace(",", ""));
			
			if (priceWithoutComma > 60000) {
				Row writeRow = writesh.createRow(rowNo++);
				Cell writeCell = writeRow.createCell(1);
				Cell writeCell2 = writeRow.createCell(0);

				writeCell.setCellValue(priceWithoutComma);
				System.out.println(priceWithoutComma);
				writeCell2.setCellValue(data);
				System.out.println(data);

			}

		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();

	}

}
