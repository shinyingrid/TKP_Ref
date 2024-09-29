package practice.OrgTest;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganizationWithPhoneNumber
{
	@Test
	public void createOrgWithPhNoTest() throws Throwable, Throwable
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
		Sheet sheet = book.getSheet("org");
		Row row = sheet.getRow(9);
		String ExpOrgName = row.getCell(2).toString()+ranNum;
		System.out.println("Org Name generated is : "+ExpOrgName);
		String ExpPhNo=row.getCell(3).toString();

		System.out.println("Org Name generated is : "+ExpPhNo);

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Step 2: Navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: Click on "Create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 4: Enter all the details and create an organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ExpOrgName);
		driver.findElement(By.id("phone")).sendKeys(ExpPhNo);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Verify Header Detail with respect to Expected Result
		String ActPhNo=driver.findElement(By.xpath("//td[@id='mouseArea_Phone']")).getText();
		if(ActPhNo.contains(ExpPhNo))
		{
			System.out.println("Phone Number is verified == PASS");
		}
		else
		{
			System.out.println("Phone Number is NOT verified == FAIL");
		}
	
		
		
		//Step 5: Logout of the Application
//		Actions act = new Actions(driver);
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();

	}

}
