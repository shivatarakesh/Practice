package practice.DataDrivenTeting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatafromExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rowCount=sh.getLastRowNum();
		
		for(int i=1;i<rowCount;i++) {
		Row row=sh.getRow(i);
		
		String column1data=row.getCell(0).toString();
		String column2data=row.getCell(1).toString();

		System.out.println(column1data+"\t"+column2data);
		
		}

		wb.close();
			

	}

}
