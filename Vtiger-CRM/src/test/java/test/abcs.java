package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class abcs {

	@Test
	 public void m1() throws Exception {
		 FileInputStream fis=new FileInputStream("./commonData.propeties");
		 Properties pobj=new Properties();
		 pobj.load(fis);
		Set<Object> data=pobj.keySet();
		int size = data.size();
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\devee\\OneDrive\\Desktop\\Selenium\\DATA_LIB\\Practice33.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sheet1 = wb.createSheet();
		Sheet sheet2 = wb.createSheet();
		Sheet sheet3 = wb.createSheet();
		
		int n=0; int i=0;int j=0;
		for (Object key : data)
		{
			n++;
			String value = pobj.getProperty((String) key);
			if(n<=size/2)
			{
				sheet1.createRow(i++).createCell(0).setCellValue(value);
			}else
			{
				sheet2.createRow(j++).createCell(0).setCellValue(value);

			}
		}
		FileOutputStream fout = new FileOutputStream("C:\\Users\\devee\\OneDrive\\Desktop\\Selenium\\DATA_LIB\\Practice33.xlsx");
		wb.write(fout);
		
		int length=sheet1.getLastRowNum()+sheet2.getLastRowNum();
		for (int k = 0,a=0,b=0 ;k < length; k++)
		{
			if(k<sheet1.getLastRowNum())
			{
				sheet3.createRow(k).createCell(0).setCellValue(sheet1.getRow(a++).getCell(0).getStringCellValue());
			}else
			{
				sheet3.createRow(k).createCell(0).setCellValue(sheet2.getRow(b++).getCell(0).getStringCellValue());

			}
		}
		FileOutputStream fout1 = new FileOutputStream("C:\\Users\\devee\\OneDrive\\Desktop\\Selenium\\DATA_LIB\\Practice33.xlsx");
		wb.write(fout1);
	}
}
