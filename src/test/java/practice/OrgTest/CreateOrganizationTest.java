package practice.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganizationTest
{
	@Test
	public void createOrgTest() throws Throwable, Throwable
	{
		WebDriver driver = null;

		//Read common data from Properties File
		FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER =prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME =prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//Generate the random number
		Random ran= new Random();
		int ranNum=ran.nextInt(1000);
		
		//Read Test Script data from Excel
		FileInputStream fisXl = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook book = WorkbookFactory.create(fisXl);
		String orgName=book.getSheet("org").getRow(1).getCell(2).toString()+ranNum;
		System.out.println("Org Name generated is : "+orgName);
		
		//Polymorphism concept implementation
		if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		//Step 1: Login to app
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB+PASSWORD);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Step 2: Navigate to Organization Module
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 3: Click on "Create Organization" Button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
				//Step 4: Enter all the details and create an organization
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Verify Header Detail with respect to Expected Result
		String HeaderDetails=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Details of Header is : "+HeaderDetails);
		if(HeaderDetails.contains(orgName))
		{
			System.out.println("****OrgName is found in Header****: PASS");
		}
		else
		{
			System.out.println("****OrgName is NOT found in Header****: FAIL");
		}
		
		//Verify Header orgName infor w.r.t Expected Result
		String orgNameCreated = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(orgNameCreated.equals(orgName))
		{
			System.out.println(orgName+" is created successfully==PASS");
		}
		else
		{
			System.out.println(orgName+" is NOT created== FAIL");
		}
		
		
		//Step 5: Logout of the Application
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
