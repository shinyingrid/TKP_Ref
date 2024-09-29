package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteToExcelCreateNewSheet {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell createdcell = book.createSheet("SindhuSheet").createRow(1).createCell(4);
		createdcell.setCellType(CellType.STRING);
		createdcell.setCellValue("Sindhu");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Test.xlsx");
		book.write(fos);
		System.out.println("Data added successfully");
		book.close();
	}

}
