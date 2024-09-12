package genericUtilityImplementationScripts;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;

public class CreateNewContactwithExistingOrganisation {

	public static void main(String[] args) {
		PropertiesUtility propertyUtil = new PropertiesUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility driverutil = new WebDriverUtility();

		propertyUtil.propertiesInIt(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInIt(IConstantPath.EXCEL_PATH);

		WebDriver driver = driverutil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverutil.maximizeBrowser();
		driverutil.navigateToApp(propertyUtil.readFromProperties("url"));

		long time = (Long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), DataType.LONG);

		driverutil.waitTillElementFound(time);
		
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://localhost:8888/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if (driver.getTitle().contains("vtiger CRM")) {
			System.out.println("Login Page Displayed");
		}

		else {
			driverutil.QuitAllWindows();		
		}
		driver.findElement(By.name("user_name")).sendKeys(propertyUtil.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyUtil.readFromProperties("password"));
		driver.findElement(By.id("submitButton")).submit();

		if (driver.getTitle().contains("Home")) {
			System.out.println("HOME Page is Displayed");
		} else {
			driverutil.QuitAllWindows();		
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if (driver.getTitle().contains("Contacts")) {
			System.out.println("Contacts Page is Displayed");
		} else {
			driverutil.QuitAllWindows();		
		}
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement pageHeader=driver.findElement(By.className("lvtHeaderText"));
		if(pageHeader.isDisplayed()) {
			System.out.println("Creating new contact");
		}
		else {
			driverutil.QuitAllWindows();		
		}
		Map<String, String> map=excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		
		driver.findElement(By.name("lastname")).sendKeys(map.get("Last Name"));
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String windowId =driver.getWindowHandle();
//		Set<String> windowIds =driver.getWindowHandles();
//		for(String id:windowIds) {
//			driver.switchTo().window(id);
//		}
		
		driverutil.switchToWindow("Accounts");
		
		driver.findElement(By.xpath("//a[text()='"+map.get("Organization Name")+"']")).click();
		//driver.switchTo().window(windowId);
		driverutil.switchToWindow("Contacts");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String newOrgPageHeader = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if (newOrgPageHeader.contains(map.get("Last Name")))
			System.out.println("Contact created succesfully");
		else
			driverutil.QuitAllWindows();
		
		driver.findElement(By.name("Delete")).click();
		driverutil.handleAlert("ok");
		//driver.switchTo().alert().accept();
		if(driver.getTitle().contains("Contacts")) {
			System.out.println("Contacts page is displayed");
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Passss");
		}
		else {
			driverutil.QuitAllWindows();
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Fail");
		}
		
		excel.saveExcel(IConstantPath.EXCEL_PATH);

		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverutil.mouseHover(logout);
//		Actions a2 = new Actions(driver);
//		a2.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		excel.closeExcel();
		driverutil.QuitAllWindows();

		
		

	}

}
