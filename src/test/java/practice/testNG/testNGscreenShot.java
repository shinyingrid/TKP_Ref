package practice.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class testNGscreenShot 
{
	@Test
	public void takeScreenShot() throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		//Step 1:Create an object for EventFiringWebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//Step 2: Use getScreenShotAs method to get the file type of screenshot
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//Step 3: Store screeshot in local driver
		FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
	}
}
