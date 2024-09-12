package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		
		Properties pr=new Properties();
		
		pr.load(fis);
		
		System.out.println(pr.getProperty("url"));
	}

}
