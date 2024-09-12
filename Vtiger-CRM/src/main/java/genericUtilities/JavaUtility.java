package genericUtilities;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class contains reusable methods to perform java related operations @
 */
public class JavaUtility {

	/**
	 * This method generates random number within specified limit
	 * 
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}

	/**
	 * This method passes the script for the specified time
	 * 
	 * @param time
	 */

	public void waiting(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns system date and time in string format
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);
	}

	/**
	 * This method convert string to any data type
	 * 
	 * @param data
	 * @param datatype
	 * @return
	 */

	public Object convertStringToAnyDataType(String data, String datatype) {
		Object obj = null;
		switch (datatype) {
		case "int":
			obj = Integer.parseInt(datatype);
			break;
		case "float":
			obj = Float.parseFloat(datatype);
			break;
		case "double":
			obj = Double.parseDouble(datatype);
			break;
		case "long":
			obj = Long.parseLong(datatype);
			break;
		default:
			System.out.println("Invalid data type");
		}
		return obj;
	}

	public Object convertStringToAnyDataType(String data, DataType datatype) {
		Object obj = null;

		if (datatype.toString().equalsIgnoreCase("int"))
			obj = Integer.parseInt(data);
		else if (datatype.toString().equalsIgnoreCase("float"))
			obj = Float.parseFloat(data);
		else if (datatype.toString().equalsIgnoreCase("double"))
			obj = Double.parseDouble(data);
		else if (datatype.toString().equalsIgnoreCase("long"))
			obj = Long.parseLong(data);
		else
			System.out.println("Invalid data type");

		return obj;
	}
	

	/**
	 * This method converts month name to integer
	 * 
	 * @param month
	 * @return
	 */
	public int convertMonthToInt(String month) {
		return DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(month)
				.get(ChronoField.MONTH_OF_YEAR);

	}

	/**
	 * This method splits a String based on the Split strategy provided
	 * @param str
	 * @param splitStrategy
	 * @return String[]
	 */
	public String[] splitString(String str, String splitStrategy) {
		return str.split(splitStrategy);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
