package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddatafromExcelTest1 {

	public static void main(String[] args) throws IOException {
		//get the excel path location and java object of the physical excel file
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
		//open workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		//read the string data
		DataFormatter format=new DataFormatter();
		
		String data=//wb.getSheet("org").getRow(1).getCell(3).toString();
				format.formatCellValue(wb.getSheet("org").getRow(1).getCell(3));
		System.out.println(data);
		//close the workbook
		wb.close();

	}

}
