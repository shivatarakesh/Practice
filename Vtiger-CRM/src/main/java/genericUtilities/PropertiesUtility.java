package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods to read data from properties file
 */
public class PropertiesUtility {
	private Properties pr;
	
	/**
	 * This method initializes properties file
	 * @param filePath
	 */
	public void propertiesInIt(String filePath) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pr=new Properties();
		try {
			pr.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method fetches the value of the key specified from properties file
	 * @param key
	 * @return String
	 */
	public String readFromProperties(String key) {
		
		return pr.getProperty(key);
	}

}
