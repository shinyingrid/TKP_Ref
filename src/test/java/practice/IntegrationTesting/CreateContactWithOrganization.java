package practice.IntegrationTesting;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateContactWithOrganization
{
	@Test
	public void createNewContWithOrgTest() throws Throwable, Throwable
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
	String ConLastName=book.getSheet("contact").getRow(7).getCell(3).toString()+ranNum;
	System.out.println("Contact Name generated is : "+ConLastName);
	String orgName=book.getSheet("contact").getRow(7).getCell(2).toString()+ranNum;
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

	Thread.sleep(2000);
	
	
	
	//*************************************************************************************************************
	//Create an organization
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	
	//Verification of organization
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
	
	//*********************************************************************************************************
	Thread.sleep(3000);
	
	//************************************************************************************************************
	
	//Create a contact - Enter the last name in contact
	driver.findElement(By.linkText("Contacts")).click();;
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("lastname")).sendKeys(ConLastName);
	
	//selecting organization within contact
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
	//switch to child window
	Set<String> set = driver.getWindowHandles();
	Iterator<String> iterator = set.iterator();
	while(iterator.hasNext())
	{
		String windowID = iterator.next();
		driver.switchTo().window(windowID);
		String actURL=driver.getCurrentUrl();
		if(actURL.contains("module=Accounts&action"))
		{
			break;
		}
	}
	
	
	//Select the organization name from child window
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@type='button']")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
	
	//switch back to parent window
	//switch to child window
	Set<String> setParent = driver.getWindowHandles();
	Iterator<String> iteratorParent = setParent.iterator();
	while(iteratorParent.hasNext())
	{
		String windowID = iteratorParent.next();
		driver.switchTo().window(windowID);
		
		String parentURL=driver.getCurrentUrl();
		if(parentURL.contains("module=Contacts&action"))
		{
			break;
		}
	}
	
	
	//save the contact
	driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	Thread.sleep(2000);
	
	
	//Verification of contact
	String headerName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerName.contains(ConLastName))
	{
		System.out.println("Contact detail is driven == PASS");
	}
	else
	{
		System.out.println("Contact detail is not driven == FAIL");
	}
	
	
	String SavedLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
	if(SavedLastName.equals(ConLastName))
	{
		System.out.println("Contact is created and verified == PASS");
	}
	else
	{
		System.out.println("Contact is not verified== FAIL");
	}
	
	//Verify org name within contact 
	String orgNameSavedInCont=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
	if(orgNameSavedInCont.equals(orgName))
	{
		System.out.println("Org within contact is verified == PASS");
	}
	else
	{
		System.out.println("Org within contact is verified == FAIL");
	}
	
	// If script fails due to space - use trim ---->   if(orgNameSavedInCont.trim().equals(orgName))
	
	
	//***********************************************************************************************************
	//Step 5: Logout of the Application
	Actions act = new Actions(driver);
	Thread.sleep(2000);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();

}

}
