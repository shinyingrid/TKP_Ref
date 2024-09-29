package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("org");
		Row row = sheet.getRow(1);
		Cell cel = row.createCell(4);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("PASS");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\Test.xlsx");
		book.write(fos);
		
		book.close();
		System.out.println("Executed");

	}

}
