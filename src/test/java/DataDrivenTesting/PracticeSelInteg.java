package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PracticeSelInteg 
{
	public static void main(String[] args) throws Throwable 
	{
		String ExpectedTestID="tc_03";
		boolean flag=false;
		String testCaseID ="";
		String testCaseName ="";
		String orgName ="";
				
		FileInputStream fisp = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fisp);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
				
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("org");
		
		int lrn = sheet.getLastRowNum();
		for(int i=1;i<=lrn+1;i++)
		{
			try {
			String testID = sheet.getRow(i).getCell(0).toString();
			if(testID.equals(ExpectedTestID))
			{
				flag=true;
				testCaseID = sheet.getRow(i).getCell(0).toString();
				testCaseName = sheet.getRow(i).getCell(1).toString();
				orgName = sheet.getRow(i).getCell(2).toString();
			}
			}
			catch(Exception e) {}
		}
		
		if(flag==true)
		{
			System.out.println(testCaseID+"\t"+testCaseName+"\t"+orgName);
		}
		
	}
}
