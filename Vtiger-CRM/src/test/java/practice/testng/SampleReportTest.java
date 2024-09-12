package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report ;
	@BeforeSuite
	public void configBS() {
		// Spark Report Config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add env Information and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@AfterSuite
	public void configAs() {
		report.flush();

	}

	@Test
	public void createContacttest() {

		ExtentTest test = report.createTest("createContactTest");

		// System.out.println("login to app");
		test.log(Status.INFO, "login to app");

		// System.out.println("navigate to contact page");
		test.log(Status.INFO, "navigate to contact page");

		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HFDC")) {
			// System.out.println("contact is created");
			test.log(Status.PASS, "contact is created");
		} else {
			// System.out.println("contact is not created");
			test.log(Status.FAIL, "contact is not created");
		}
		test.log(Status.INFO,"login to appn");

	}
	@Test
	public void createContactwithOrg() {
		ExtentTest test = report.createTest("createContactwithOrg");

		test.log(Status.INFO, "login to app");

		test.log(Status.INFO, "navigate to contact page");

		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		test.log(Status.INFO,"login to appn");

	}
	@Test
	public void createContactwithPhNo() {
		ExtentTest test = report.createTest("createContactwithPhNo");

		test.log(Status.INFO, "login to app");

		test.log(Status.INFO, "navigate to contact page");

		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
		test.log(Status.INFO,"login to appn");

	}
	@Test
	public void createContactScreenshot() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filepath= ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("createContactScreenshot");
		
		test.log(Status.INFO, "login to app");

		test.log(Status.INFO, "navigate to contact page");

		test.log(Status.INFO,"create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath,"ErrorFiles");
		}
		test.log(Status.INFO,"login to appn");		
		
		
	}
	

}
