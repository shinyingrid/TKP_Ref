package calendarPopUp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalendarPopUp 
{
	@Test
	public void demoCalendar() throws InterruptedException
	{
		String ExpDate ="20";
		String yearmonth="Dec 2024";
		
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
		WebElement from = driver.findElement(By.xpath("(//div[@class='sc-VigVT ishpWr'])[1]/div/div/div/input"));
		WebElement to = driver.findElement(By.xpath("(//div[@class='sc-VigVT ishpWr'])[2]/div/div/div/input"));
		WebElement dateCal = driver.findElement(By.xpath("//div[@class='labelCalendarContainer']"));
		jse.executeScript("arguments[0].value='Chennai';",from);
		jse.executeScript("arguments[0].value='Bangalore';",to);
		dateCal.click();
				WebElement clickontext=driver.findElement(By.xpath("//i[contains(@class,\"sc-cSHVUG\")]"));
		wait.until(ExpectedConditions.elementToBeClickable(clickontext));
		clickontext.click();
		
		
		String expectedmonthyear="September 2024";
	    String expectedday="16";
		int j=1,i=1;
		while(true) {
			String monthHeader = driver.findElement(By.xpath("//div[@class=\"DayNavigator__IconBlock-qj8jdz-2 iZpveD\" and @style='flex-grow: 2; font-size: 0.875rem;']")).getText();
		   System.out.println(monthHeader);
			if(expectedmonthyear.equals(monthHeader)) {
		    	WebElement day=driver.findElement(By.xpath("//span[text()='"+expectedday+"']"));
				wait.until(ExpectedConditions.elementToBeClickable(day));
				js.executeScript("arguments[0].click();", day);
				break;
		    }if(i==1) {
				WebElement next1=driver.findElement(By.xpath("//*[name()='svg'][@id=\"Layer_1\"]"));
				next1.click();
				
			}else {
			List<WebElement> next=driver.findElements(By.xpath("//*[name()='svg'][@id=\"Layer_1\"]"));
			for(WebElement e:next) {
				if(j%2==0) {
					Thread.sleep(2000);
					e.click();
					j++;
				}else {
					j++;
				}
			}
			}
	  }
				
		    	
		    	
		   
	
	
	
	
	
	
	
	
	
	
	}
		
			}
	

