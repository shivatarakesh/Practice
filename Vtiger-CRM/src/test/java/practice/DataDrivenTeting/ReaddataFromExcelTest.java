package practice.DataDrivenTeting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	//get the excel path location and java object of the physical excel file
	FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\data\\TestScriptData.xlsx");
	//open workbook in read mode
	Workbook wb=WorkbookFactory.create(fis);
	//get the control of the "org" sheet
	Sheet sh=wb.getSheet("org");
	//get the control of the "1st" row
	Row row=sh.getRow(1);
	//get the control of the "2nd" cell and read the string data
	Cell cel=row.getCell(2);
	String data=cel.getStringCellValue();
	System.out.println(data);
	//close the workbook
	wb.close();
		
	}

}
