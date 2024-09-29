package ExceptionHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PgmToGetStaleElementReferenceException 
{	
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8888");
		WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2=driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
		
				ele1.sendKeys("admin");
				ele2.sendKeys("admin");
		
		//inducing StaleElementReferenceException
		driver.navigate().refresh();
		
		//Trying to enter the values again
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		//Address would have changed and thereby we get SERE
				
		ele3.click();

		
	}

}
