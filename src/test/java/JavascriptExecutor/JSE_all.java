package JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JSE_all 
{

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//***********To launch browser using URL*********
		//Method 1:
		//jse.executeScript("window.location=arguments[0];","https://www.amazon.in/");
		
		//Method 2:
		String url ="https://www.amazon.in/";
		
		jse.executeScript("window.location=arguments[0];",url); //To load url
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //To scroll to bottom of page
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//To scroll to top of page
				
		WebElement ele = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);",ele);//To Scroll to an element
		
	//	jse.executeScript("arguments[0].click();",ele);//To click an element
		
	

	}
}
