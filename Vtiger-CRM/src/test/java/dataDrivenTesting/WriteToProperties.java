package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		Properties pr=new Properties();
		pr.load(fis);
		
		pr.put("subject", "selenium");
		FileOutputStream fos= new FileOutputStream("./src/test/resources/data.properties");
		pr.store(fos, "updated succesfully");

	}

}
