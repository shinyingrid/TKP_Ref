package JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JSE_clickAnElement 
{
	public static void main(String[] args) throws Throwable {
		
		 WebDriver driver = new EdgeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 driver.get("https://www.browserstack.com/users/sign_in");
		 jse.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
		 jse.executeScript("document.getElementById('user_password').value='password';");
		 jse.executeScript("document.getElementById('user_submit').click();");
		// jse.executeScript("alert('enter correct login credentials to continue');");
	}
}
