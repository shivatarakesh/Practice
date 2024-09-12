package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrg {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\CommonData11.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER =pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME =pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}
}
