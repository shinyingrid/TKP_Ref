package DataDrivenTesting;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadSingleDataFromExcel {

	public static void main(String[] args) throws Throwable
	{

		//Step 1 : Get the excel file path to get the java object representation of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\Test.xlsx");
		
		//Step 2: Open the workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get the Control of the Organization Sheet
		Sheet sheet = book.getSheet("Organization");
		
		//Step 4: Get the control of the First Row
		Row row = sheet.getRow(0);
		
		//Step 5: Get the Control of the 2nd cell
		Cell cell = row.getCell(3);
		 
		
		//Step 6: Read the String data from the cell
		//double data = cell.getNumericCellValue(); //returns number.0 in the output
		//String data = row.getCell(3).toString(); //to read numeric value and convert to String directly 
		 String data = cell.getStringCellValue();  // to read string data
		 System.out.println(data);
		
		//Step 7: Close the WorkBook
		 book.close();
				
		

	}

}
