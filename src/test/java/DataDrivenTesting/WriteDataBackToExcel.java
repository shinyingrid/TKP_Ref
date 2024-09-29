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

public class WriteDataBackToExcel 
{
	public static void main(String[] args) throws Throwable  
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("NewSheet");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Hello");
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Test.xlsx");
		book.write(fos);
		book.close();
	}
}
