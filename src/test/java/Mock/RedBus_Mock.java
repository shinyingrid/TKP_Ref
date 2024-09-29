package Mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBus_Mock 
{
	@Test
	public void bookTicket() throws Throwable
	{
		EdgeOptions op=new EdgeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new EdgeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		
		String url="https://www.redbus.in/";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.location=arguments[0];", url);
		
		//Identification of the webelements
		WebElement from = driver.findElement(By.xpath("(//div[@class='sc-VigVT ishpWr'])[1]/div/div/div/input"));
		
		
		
		//From selection
		from.click();
	from.sendKeys("Bang");
		Thread.sleep(5000);
		List<WebElement> fromList = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']/li[*]/div[*]/text"));
		wait.until(ExpectedConditions.visibilityOfAllElements(fromList));
		for(WebElement f : fromList)
		{
			String fName = f.getText();
			//System.out.println(fName);
			if(fName.contains("Bangalore"))
			{
				f.click();
				break;
			}
		}
		
		
		
		//To Selection
		
		WebElement to = driver.findElement(By.xpath("//input[@id='dest']"));
		Actions act = new Actions(driver);
		act.sendKeys("Chenn").perform();
		Thread.sleep(5000);
		List<WebElement> ToList = driver.findElements(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']/li[*]/div[*]/text"));
		wait.until(ExpectedConditions.visibilityOfAllElements(ToList));
		for(WebElement t : ToList)
		{
			String tName = t.getText();
			//System.out.println(fName);
			if(tName.contains("Chennai"))
			{
				t.click();
			}
		}
		
		//Calendar Selection
		driver.findElement(By.xpath("//div[@class='labelCalendarContainer']"));
		WebElement date = driver.findElement(By.xpath("//div[@class='sc-jzJRlG dPBSOp']/div/div/div[3]/div[3]/span/div[3]/div"));
		driver.switchTo().frame(date);
		date.click();
		
		//jse.executeScript("arguments[0].value='Chen';",to);
		
		
		
		
		
		
		
		
	
		
		
	}
}
