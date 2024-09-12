package practice.DataDrivenTeting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Throwable {
		String expectedCondition = "tc_02";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag = false;

		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rowCount = sh.getLastRowNum();

		for (int i = 1; i < rowCount; i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedCondition)) {
					flag = true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();

				}
			} catch (Exception e) {
			}
		}
		if (flag = true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		} else {
			System.out.println("expected testcase id is not available");
		}

		wb.close();

	}

}
