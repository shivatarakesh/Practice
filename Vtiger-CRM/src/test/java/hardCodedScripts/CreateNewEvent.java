package hardCodedScripts;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		if(driver.getTitle().contains("vtiger CRM")) {
			System.out.println("Login Page Displayed");
		}
		
		else {
			driver.quit();
		}
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Shiva@123");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home")) {
			System.out.println("HOME Page is Displayed");
		}
		else {
			System.out.println("login failed");
		}
		WebElement QuickCreateDD=driver.findElement(By.id("qccombo"));
		Select s1=new Select(QuickCreateDD);
		s1.selectByValue("Events");
		driver.findElement(By.name("subject")).sendKeys("event1");
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		
		int reqStartYear=2025;
		String reqStartDate="9";
		String reqStartMonth="January";
		
		String currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		String[] str=currentMonthYear.split(", ");
		int currentYear=Integer.parseInt(str[1]);
		
		while(currentYear<reqStartYear) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			
			currentMonthYear=driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str=currentMonthYear.split(", ");
			currentYear=Integer.parseInt(str[1]);
		}
		System.out.println(str[0]);
		System.out.println(currentYear);
		int currentmonth=DateTimeFormatter
						.ofPattern("MMMM")
						.withLocale(Locale.ENGLISH)
						.parse(str[0])
						.get(ChronoField.MONTH_OF_YEAR);
		int reqStartmonthInNum = DateTimeFormatter
								.ofPattern("MMMM")
								.withLocale(Locale.ENGLISH)
								.parse(reqStartMonth)
								.get(ChronoField.MONTH_OF_YEAR);
		
		while(currentmonth<reqStartmonthInNum) {
			
			driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='›']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentmonth = DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		while(currentmonth > reqStartmonthInNum) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='‹']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentmonth = DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='"+reqStartDate+"']")).click();
		
		
driver.findElement(By.id("jscal_trigger_due_date")).click();
		
		int reqEndYear=2025;
		String reqEndDate="9";
		String reqEndMonth="January";
		
		String currentMonthYear2=driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		String[] str2=currentMonthYear2.split(", ");
		int currentYear2=Integer.parseInt(str2[1]);
		
		while(currentYear2<reqEndYear) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			
			currentMonthYear2=driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2=currentMonthYear2.split(", ");
			currentYear2=Integer.parseInt(str2[1]);
		}
		
		int currentmonth2=DateTimeFormatter
						.ofPattern("MMMM")
						.withLocale(Locale.ENGLISH)
						.parse(str2[0])
						.get(ChronoField.MONTH_OF_YEAR);
		int reqEndmonthInNum2 = DateTimeFormatter
								.ofPattern("MMMM")
								.withLocale(Locale.ENGLISH)
								.parse(reqEndMonth)
								.get(ChronoField.MONTH_OF_YEAR);
		
		while(currentmonth2<reqEndmonthInNum2) {
			
			driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='›']")).click();
			currentMonthYear2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2 = currentMonthYear2.split(", ");
			currentmonth2 = DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str2[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		while(currentmonth2 > reqEndmonthInNum2) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='‹']")).click();
			currentMonthYear2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2 = currentMonthYear2.split(", ");
			currentmonth2 = DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(str2[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		driver.findElement(By.xpath("//div[@class='calendar'and contains(@style,'block')]/descendant::td[text()='"+reqEndDate+"']")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		WebElement Administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(Administrator).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();


	}

}
