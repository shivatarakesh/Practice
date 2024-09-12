package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateOrgCrossBrowser {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\CommonData11.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER =pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME =pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		
//		Scanner sc=new Scanner(System.in);
//		String browserr=sc.next();
		
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			 driver=new EdgeDriver();
		}
		else{
			 driver=new ChromeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}

}
