package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws IOException {
			//1. convert physical file into java java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
			//2.open workbook
		Workbook wb=WorkbookFactory.create(fis);
			//3.get control to the sheet
//		Sheet sheet=wb.getSheet("Sheet1");
			//4.get control to the row
//		Row row=sheet.getRow(1);
			//5.get control to the cell
//		Cell cell=row.getCell(1);
			//6.fetch the value
//		System.out.println(cell.getStringCellValue());
		
		String data=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
			//7.close the workbook
		wb.close();
	}

}
