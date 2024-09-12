package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgAssignment {

	public static void main(String[] args) throws Throwable {
		//read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\CommonData11.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER =pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME =pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		
		//generate random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		//read testScript data from Excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		String orgname=row.getCell(2).toString() + randomInt;
		wb.close();


		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equals("chrome")) {
			 driver=new EdgeDriver();
		}
		else{
			 driver=new ChromeDriver();
		}
		//Step 1: login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
	
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 2: navigate to org module
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step 3: click on create org button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 4: enter all details and create org
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();
		
		//step 5: logout
		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("done");
		driver.quit();
	}
	

}
