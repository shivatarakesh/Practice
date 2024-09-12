package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTeting {
	
	public static void main(String[] args) throws Throwable  {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\CommonData11.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		System.out.println(pObj.getProperty("url"));
		
	}
 
}
