package java_concepts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class practice_TK_basics 
{
	public static void main(String[] args) throws Throwable 
	{
		 WebDriver driver = new EdgeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 driver.get("https://demoapp.skillrary.com/");
		 Thread.sleep(3000);
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollTo(0,document.body.Scrollheight)");
		 
		
		
	}
}
