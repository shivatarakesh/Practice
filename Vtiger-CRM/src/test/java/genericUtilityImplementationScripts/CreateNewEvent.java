package genericUtilityImplementationScripts;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;

public class CreateNewEvent {

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

//		WebDriver driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
		//Map<String, String> map=excel.readFromExcel(("EventsTestData", "Create New Event");
		
		WebElement QuickCreateDD = driver.findElement(By.id("qccombo"));
		Select s1 = new Select(QuickCreateDD);
		s1.selectByValue("Events");
		driver.findElement(By.name("subject")).sendKeys("event1");
		driver.findElement(By.id("jscal_trigger_date_start")).click();

		int reqStartYear = 2025;
		String reqStartDate = "9";
		String reqStartMonth = "January";

		String currentMonthYear = driver
				.findElement(
						By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']"))
				.getText();
		String[] str = currentMonthYear.split(", ");
		int currentYear = Integer.parseInt(str[1]);

		while (currentYear < reqStartYear) {
			driver.findElement(
					By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']"))
					.click();

			currentMonthYear = driver
					.findElement(By.xpath(
							"//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str = currentMonthYear.split(", ");
			currentYear = Integer.parseInt(str[1]);
		}
		System.out.println(str[0]);
		System.out.println(currentYear);
		int currentmonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
				.get(ChronoField.MONTH_OF_YEAR);
		int reqStartmonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqStartMonth)
				.get(ChronoField.MONTH_OF_YEAR);

		while (currentmonth < reqStartmonthInNum) {

			driver.findElement(
					By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='›']"))
					.click();
			currentMonthYear = driver
					.findElement(By.xpath(
							"//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str = currentMonthYear.split(", ");
			currentmonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		while (currentmonth > reqStartmonthInNum) {
			driver.findElement(
					By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='‹']"))
					.click();
			currentMonthYear = driver
					.findElement(By.xpath(
							"//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str = currentMonthYear.split(", ");
			currentmonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		driver.findElement(By.xpath(
				"//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='" + reqStartDate + "']"))
				.click();

		driver.findElement(By.id("jscal_trigger_due_date")).click();

		int reqEndYear = 2025;
		String reqEndDate = "9";
		String reqEndMonth = "January";

		String currentMonthYear2 = driver
				.findElement(
						By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']"))
				.getText();
		String[] str2 = currentMonthYear2.split(", ");
		int currentYear2 = Integer.parseInt(str2[1]);

		while (currentYear2 < reqEndYear) {
			driver.findElement(
					By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']"))
					.click();

			currentMonthYear2 = driver
					.findElement(By.xpath(
							"//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str2 = currentMonthYear2.split(", ");
			currentYear2 = Integer.parseInt(str2[1]);
		}

		int currentmonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str2[0])
				.get(ChronoField.MONTH_OF_YEAR);
		int reqEndmonthInNum2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqEndMonth)
				.get(ChronoField.MONTH_OF_YEAR);

		while (currentmonth2 < reqEndmonthInNum2) {

			driver.findElement(
					By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='›']"))
					.click();
			currentMonthYear2 = driver
					.findElement(By.xpath(
							"//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str2 = currentMonthYear2.split(", ");
			currentmonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str2[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		while (currentmonth2 > reqEndmonthInNum2) {
			driver.findElement(
					By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='‹']"))
					.click();
			currentMonthYear2 = driver
					.findElement(By.xpath(
							"//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']"))
					.getText();
			str2 = currentMonthYear2.split(", ");
			currentmonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str2[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		driver.findElement(By.xpath(
				"//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='" + reqEndDate + "']"))
				.click();

		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		WebElement Administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(Administrator).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driverutil.QuitAllWindows();

	}

}
