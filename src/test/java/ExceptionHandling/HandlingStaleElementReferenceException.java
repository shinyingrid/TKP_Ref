package ExceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingStaleElementReferenceException {


		@FindBy(name="user_name")
		WebElement ele1;
		
		@FindBy(name="user_password")
		WebElement ele2;
		
		@FindBy(id="submitButton")
		WebElement ele3;
		
		@Test
		public void sampleTestPOM()
		{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		
		//store the elements in a reference variable and use it
		HandlingStaleElementReferenceException pf=PageFactory.initElements(driver, HandlingStaleElementReferenceException.class);
		
		//use the reference variable to load the elements
		pf.ele1.sendKeys("admin");
		pf.ele2.sendKeys("admin");
		
		driver.navigate().refresh();
		
		pf.ele1.sendKeys("admin");
		pf.ele2.sendKeys("admin");
				
		pf.ele3.click();
		
		System.out.println("Logged in successfully");
		

	}

}
