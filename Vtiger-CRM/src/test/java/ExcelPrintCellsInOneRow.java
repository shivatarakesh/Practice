import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPrintCellsInOneRow {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		//int rowCount=sh.getLastRowNum();
		Row row=sh.getRow(0);
		int colCount=row.getLastCellNum();
		for(int i=0;i<colCount;i++) {
		
		String column1data=row.getCell(i).toString();
		

		System.out.print(column1data+"\t");
		
		}

		wb.close();

	}

}
