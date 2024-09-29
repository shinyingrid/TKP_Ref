package SampleUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PracticeExcelUtility 
{
	public int getLastRowNum(String SheetName) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		int rowCount=book.getSheet(SheetName).getLastRowNum();	
		return rowCount;
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int colNum) throws Throwable, FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		String data=book.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		System.out.println(data);
		return data;
	}
	
	
	public void writeDataBackToExcel(String SheetName, int rowNum, int colNum, String data) throws Throwable, FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Cell cell = book.createSheet(SheetName).createRow(rowNum).createCell(colNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Test.xlsx");
		book.write(fos);
		book.close();
	}
	
	public String getMultipleDataFromExcel(String sheetName) throws Throwable, FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(sheetName);
		String data = null;
		int lrn=sheet.getLastRowNum();
		System.out.println(lrn);
		int lcn=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<=lrn;i++)	//row
		{
			for(int j=0;i<lcn;j++)
			{
				data =sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data);
				
			}
			System.out.println();
		}
		
		return data;
		
	}
	
	//***********************************************************
	
	public Object[][] dataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(sheetName);
		
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		
		
		Object[][] obj = new Object[lastRow+1][lastCell];		//empty array
		
		for (int i = 0; i <lastRow; i++) 	//row
		{
			for (int j = 0; j<lastCell; j++) //cell
			{
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
