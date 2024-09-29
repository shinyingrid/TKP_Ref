package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WriteFromWebPageToExcel 
{
	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in");
		for(int i=1;i<=32;i++)
		{
		String allLinks=driver.findElement(By.xpath("(//a[@class='nav-a  '])["+i+"]")).getText();
		FileInputStream fis = new FileInputStream("./src/test/resources/dummy123.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(allLinks);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/dummy123.xlsx");
		book.write(fos);
		book.close();
	   System.out.println(allLinks);
		}
	}
}
