package practice.Prod.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateProductWithCategoryAndManufacturer 
{
	@Test
	public void createNewProdWithCatAndManTest() throws Throwable
	{
		FileInputStream fisp = new FileInputStream(".//src//test//resources//CommonData.properties");
		Properties prop = new Properties();
		prop.load(fisp);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME= prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		
		Random ran = new Random();
		int ranNum= ran.nextInt();
		
		FileInputStream fisxl= new FileInputStream(".//src//test//resources//Test.xlsx");
		Workbook book = WorkbookFactory.create(fisxl);
		Sheet sheet = book.getSheet("Products");
		String ExpProdName=sheet.getRow(1).getCell(2).toString()+ranNum;
		String ExpCatName=sheet.getRow(1).getCell(3).toString();
		String ExpManName=sheet.getRow(1).getCell(4).toString();
		
		System.out.println("Expected Product name is :"+ExpProdName);
		
		WebDriver driver = null;
		if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB+PASSWORD);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ExpProdName);
		
		WebElement CatDD = driver.findElement(By.name("productcategory"));
		Select selCat= new Select(CatDD);
		selCat.selectByVisibleText(ExpCatName);
		
		WebElement ManDD = driver.findElement(By.name("manufacturer"));
		Select selMan = new Select(ManDD);
		selMan.selectByVisibleText(ExpManName);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		String ProdHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(ProdHeader.contains(ExpProdName))
		{
			System.out.println();
			System.out.println("Product verification 1 == PASS");
		}
		else
		{
			System.out.println();
			System.out.println("Product verification 1 == FAIL");
		}
		//Verification Of Product Name
		String CreatedProdName=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		System.out.println("Created Product is : "+CreatedProdName);
		if(CreatedProdName.equals(ExpProdName))
		{
			System.out.println();
			System.out.println("Product verification 2 == PASS");
		}
		else
		{
			System.out.println();
			System.out.println("Product verification 2 == FAIL");
		}
		
		//Verification Of Product Category
				String SelectedProdCat=driver.findElement(By.xpath("//span[@id='dtlview_Product Category']")).getText();
				System.out.println("Selected Product Category is : "+SelectedProdCat);
				if(SelectedProdCat.equals(ExpCatName))
				{
					System.out.println();
					System.out.println("Product Category verification == PASS");
				}
				else
				{
					System.out.println();
					System.out.println("Product Category verification == FAIL");
				}
		
				//Verification Of Product Manufacturer
				String SelectedProMan=driver.findElement(By.xpath("//span[@id='dtlview_Manufacturer']")).getText();
				System.out.println("Selected Product Manufacturer is : "+SelectedProMan);
				if(SelectedProMan.equals(ExpManName))
				{
					System.out.println();
					System.out.println("Product Manufacturer verification == PASS");
				}
				else
				{
					System.out.println();
					System.out.println("Product Manufacturer verification == FAIL");
				}
				Actions act = new Actions(driver);
				Thread.sleep(2000);
				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();

		
	}

}
