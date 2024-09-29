package DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXmlTest 
{
	@Test
	public void sampleTest(XmlTest test)
	{
//		System.out.println("Sample test");
//		System.out.println(test.getParameter("url"));
//		System.out.println(test.getParameter("username"));
//		System.out.println("password");
		
		String URL=test.getParameter("url");
		String USERNAME=test.getParameter("username");
		String PASSWORD=test.getParameter("password");
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
}
