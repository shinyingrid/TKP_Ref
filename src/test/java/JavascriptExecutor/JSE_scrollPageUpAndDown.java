package JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;

public class JSE_scrollPageUpAndDown
{
	public static void main(String[] args) throws Throwable
	{
		 WebDriver driver = new EdgeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 driver.get("https://demoapp.skillrary.com/");
		 Thread.sleep(3000);
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 Thread.sleep(3000);
		 jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
		 Thread.sleep(3000);
		 //scroll down
		 jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//scroll up
		 System.out.println("Scrolled to the end");
		 
		
	}
}
