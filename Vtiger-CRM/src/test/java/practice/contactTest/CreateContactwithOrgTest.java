package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactwithOrgTest {
	public static void main(String[] args) throws Throwable {
		// read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\CommonData11.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		// generate random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		// read testScript data from Excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String lastname = row.getCell(3).toString() + randomInt;
		String orgname = row.getCell(4).toString() + randomInt;
		wb.close();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		// Step 1: login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step 2: create new org
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// step 3: click on create org button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step 4: enter all details and create new org
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();

		// step 5: verify header msg expected result
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		if (headerInfo.contains(orgname)) {
			System.out.println(orgname + " is created==PASS");
		} else {
			System.out.println(orgname + "is not created==FAIL");
		}

		// step 2: navigate to contacts module
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// step 3: click on create contact button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step 4: enter all details and create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		// switch to child window
		String parent=driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains("Accounts&action")) {
				break;
			}
		}
		driver.findElement(By.className("txtBox")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		// switch to parent window
//		Set<String> set1 = driver.getWindowHandles();
//		Iterator<String> it1 = set.iterator();
//
//		while (it.hasNext()) {
//			String windowID = it1.next();
//			driver.switchTo().window(windowID);
//
//			String actUrl = driver.getCurrentUrl();
//			System.out.println(actUrl);
//			if (actUrl.contains("Contacts&action")) {
//				break;
//			}
//		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// step 5: verify header msg expected result
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(lastname)) {
			System.out.println(lastname + " is created==PASS");
		} else {
			System.out.println(lastname + "is not created==FAIL");
		}

		// step 6: verify header orgname info expected result
		String actOrgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgname);
		if (actOrgname.trim().equals(orgname)) {
			System.out.println(orgname + " is created==PASS");
		} else {
			System.out.println(orgname + "is not created==FAIL");
		}
		// step 7: logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("logout done");
		driver.quit();
	}

}
