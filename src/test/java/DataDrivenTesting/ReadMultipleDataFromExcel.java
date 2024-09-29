package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable
	{
		
				FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\Test.xlsx");
				Workbook book = WorkbookFactory.create(fis);	
				Sheet sheet = book.getSheet("Products");
				
				
//				Row row = sheet.getRow(1);
//				String column1Data = row.getCell(0).toString();
//				String column2Data=row.getCell(1).toString();
//				System.out.println(column1Data+"\t"+column2Data);
				
				
//				
//				int lrn = sheet.getLastRowNum();
//				System.out.println("LastRowNum is :"+lrn);
//				
//				for(int i=0;i<lrn+1;i++)
//				{
//				Row row = sheet.getRow(i);
//				String column1Data = row.getCell(0).toString();
//				String column2Data = row.getCell(1).toString();
//				System.out.println(column1Data+"\t"+column2Data);
//				}
				
				
				
				int lrn = sheet.getLastRowNum();
				for(int i =0;i<=lrn;i++)  
				{
					Row row = sheet.getRow(i); //Row 0
					short lcn = row.getLastCellNum(); //2
					//System.out.println("Last Cell Number is : "+lcn);
					
					for(int j =0;j<lcn;j++)
					{
						String cellData = row.getCell(j).getStringCellValue();
						System.out.println("Data in cell is :"+cellData);
					}
					
				}
				
				

	}

}
