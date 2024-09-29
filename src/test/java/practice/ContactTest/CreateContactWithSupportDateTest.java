package practice.ContactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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


public class CreateContactWithSupportDateTest 
{
		@Test
			public void createNewContWithSuppTest() throws Throwable, Throwable
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
			String LastName=book.getSheet("org").getRow(1).getCell(2).toString()+ranNum;
			System.out.println("Contact Name generated is : "+LastName);
			
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

			//Creating a contact
			Thread.sleep(2000);
			driver.findElement(By.linkText("Contacts")).click();;
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("lastname")).sendKeys(LastName);
			
			//Generating the support date
			Date dateObj = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String SupportStartDate=sim.format(dateObj);		
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, 30); 
			String SupportEndDate = sim.format(cal.getTime());
			driver.findElement(By.name("support_start_date")).clear();
			driver.findElement(By.name("support_start_date")).sendKeys(SupportStartDate);
			driver.findElement(By.name("support_end_date")).clear();
			driver.findElement(By.name("support_end_date")).sendKeys(SupportEndDate);
			
			
			//save the contact created	
			driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
			Thread.sleep(2000);
			
			//Verify the contact w.r.t. header
			String headerName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerName.contains(LastName))
			{
				System.out.println("Contact detail is driven == PASS");
			}
			else
			{
				System.out.println("Contact detail is not driven == FAIL");
			}
			
			//verify the contact w.r.t contact last name
			String SavedLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(SavedLastName.equals(LastName))
			{
				System.out.println("Contact is created and verified == PASS");
			}
			else
			{
				System.out.println("Contact is not verified== FAIL");
			}
			
			
			//Verify the support start date 
			String SupportSDCreated=driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
			if(SupportSDCreated.contains(SupportStartDate))
			{
				System.out.println("Support start date is verified == PASS");
			}
			else
			{
				System.out.println("support start date is incorrect == FAIL");
			}
			
			//Verify the support end date 
			String SupportEDCreated=driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
			if(SupportEDCreated.contains(SupportEndDate))
			{
				System.out.println("Support End date is verified == PASS");
			}
			else
			{
				System.out.println("support End date is incorrect == FAIL");
			}
			
			
			//Step 5: Logout of the Application
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();


	}
}
