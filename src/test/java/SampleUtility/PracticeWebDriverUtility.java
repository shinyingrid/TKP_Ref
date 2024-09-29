package SampleUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeWebDriverUtility {
	
	WebDriver driver = null;
	
	//1. maximize window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	//2. minimize window
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	//3.implicitly wait
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	//4. Explicit Wait
	public void ExplicitWaitForVisibilityOfEle(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//5.Explicit wait until Alert
	public void ExplicitWaitForAlert(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//Actions class
	//6. Drag And Drop
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	
	//7. Move To Element
	public void moveToElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	//8. Double Click 
	public void doubleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	//9. Double Click on Element
	public void doubleClickElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	//10. Right Click
	public void RightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	//11. Right Click on Element
	public void RightClickElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	//Select class
	//12. Select DD by text
	public void SelectByTextDD(WebElement ele,String text)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	//13. Select DD by index
	public void SelectByIndexDD(WebElement ele, int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	
	//Switch to Windows
	//14. Switch to child window
	public void switchToChildWindow(WebDriver driver)
	{
		String WindowID= driver.getWindowHandle();
		driver.switchTo().window(WindowID);
		
	}
	
	//15. switch to window based on title	
	public void switchToExpectedWindowBasedOnTitle(WebDriver driver,String title)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			String WindowID=iterator.next();
			driver.switchTo().window(WindowID);
			String CurrentWindowTitle=driver.getTitle();
			if(CurrentWindowTitle.contains(title))
			{
				break;
			}
		}
		
	}
	
	//16. Switch to window based on url
	public void switchToExpectedWindowBasedOnUrl(WebDriver driver,String url)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			String WindowID=iterator.next();
			driver.switchTo().window(WindowID);
			String CurrentWindowTitle=driver.getCurrentUrl();
			if(CurrentWindowTitle.contains(url))
			{
				break;
			}
		}
		
	}
	
	//Selenium based utilities
	//17. Sendkeys
	public void sendKeys(WebDriver driver, WebElement ele, String data)
	{
		ele.sendKeys(data);
	}
	
	// 18. click the webelement
	public void clickTheWebElement(WebDriver driver, WebElement ele)
	{
		ele.click();
	}
	
	//JavascriptExecutor
	//19.ScrollDown using JavaScriptExecutor
	public void scrollToTheEndOfPage(WebDriver driver) throws Throwable
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//20.ScrollDown using JavaScriptExecutor
	public void scrollUp(WebDriver driver) throws Throwable
	{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	//Alerts
	//21. Accept Alert
	public void acceptAlert(WebDriver driver)
	{
		Alert al=driver.switchTo().alert();
		al.accept();
		
	}
	
	//22.Dismiss alert
	public void dismissAlert(WebDriver driver)
	{
		Alert al =driver.switchTo().alert();
		al.dismiss();
	}
	
}
