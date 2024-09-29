package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = null;
	
		FileInputStream fis = new FileInputStream("C:\\Users\\Shiny Ingrid C\\OneDrive\\Desktop\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER =prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME =prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
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
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
