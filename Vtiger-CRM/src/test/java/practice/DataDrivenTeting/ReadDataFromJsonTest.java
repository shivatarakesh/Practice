package practice.DataDrivenTeting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//step 1: parse json physical file into java object using jsonparser class
		JSONParser parser=new JSONParser();
		Object obj= parser.parse(new FileReader("C:\\Users\\Lenovo\\Desktop\\data\\appCommondata.json"));
		
		//step 2:convert java object into json object using downcasting
		JSONObject map=(JSONObject) obj;
		
		//step 3: get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeouts"));
	}

}
