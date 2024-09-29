package JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;

public class JSE_RefreshBrowser 
{
	public static void main(String[] args) {
		
	WebDriver driver = new EdgeDriver();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.manage().window().maximize();
	driver.get("https://www.browserstack.com/users/sign_in");
	js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
	js.executeScript("document.getElementById('user_password').value='password';");
	js.executeScript("location.reload()");
	js.executeScript("document.getElementById('user_submit').click();");
}
}
