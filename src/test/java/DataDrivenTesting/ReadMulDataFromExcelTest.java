package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMulDataFromExcelTest {

	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Random");
		int rowcount = sh.getLastRowNum();
		int cellcount = sh.getRow(0).getLastCellNum();
		
		System.out.println(rowcount);
		System.out.println(cellcount);
		
		System.out.println("-----------");
		
		for (int i = 0; i <=rowcount; i++) 
		{
			for (int j = 0; j <cellcount; j++) {
				
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"  ");
			}
		System.out.println();
		}
		
		
		
		
		
		
	}
}
