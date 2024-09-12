package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDatafromPropertiesFileToexcel {
	@Test
	public void sheetToSheet() throws Throwable {
		FileInputStream fisPro = new FileInputStream("‪‪./configAppData/ABCD.properties");
		Properties pro = new Properties();
		pro.load(fisPro);
		pro.keySet();
		
		FileInputStream fisExcel = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\Abcd.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet1 = book.getSheet("Sheet1");
	
		
        int rowIndex = 0;
        for (String key : pro.stringPropertyNames()) {
            Row row = sheet1.createRow(rowIndex++);
            row.createCell(0).setCellValue(key);
            row.createCell(1).setCellValue(pro.getProperty(key));
        }
        try (FileOutputStream fos = new FileOutputStream("‪C:\\Users\\Lenovo\\Desktop\\data\\Abcd.xlsx")) {
            book.write(fos);
        }

        book.close();

        System.out.println("Properties have been written to the Excel file.");

	}
		
	
	

}
