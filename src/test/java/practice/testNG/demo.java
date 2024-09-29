package practice.testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SampleUtility.PracticeExcelUtility;
import SampleUtility.PracticeWebDriverUtility;

public class demo 

{
	
	public static String getMultipleDataFromExcel(String sheetName) throws Throwable, FileNotFoundException
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
	@Test
	public void sampleRun() throws Throwable
	{
			
//		WebDriver driver = new EdgeDriver();
//		PracticeWebDriverUtility wlib = new PracticeWebDriverUtility();
//		wlib.maximizeWindow(driver);
//		wlib.implicitWait(driver);
//		driver.get("https://www.amazon.in/");
//		wlib.scrollToTheEndOfPage(driver);
		
		
		demo.getMultipleDataFromExcel("Sheet2");
		System.out.println("execued");
	}

	@DataProvider
	public Object[][] dpTest() throws Throwable
	{
		PracticeExcelUtility eUtil = new PracticeExcelUtility();
		Object[][] value = eUtil.dataProvider("Sheet2");
	return value;
	}
	
	@Test
	public void getData()
	{
		System.out.println();
	}
	
	
}
