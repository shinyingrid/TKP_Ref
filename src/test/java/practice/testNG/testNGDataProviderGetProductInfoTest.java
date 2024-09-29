package practice.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGDataProviderGetProductInfoTest 
{
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[2][2];
		
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 15 (128 GB) - Black";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 13 (128GB) - Blue";
		
		return objArr;
	}

	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName,String ProductName) throws Throwable
	{
		@SuppressWarnings("unused")
		WebDriver driver = new EdgeDriver();
		driver.get("http://amazon.in");
		
		//Search product
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brandName,Keys.ENTER);
		
		Thread.sleep(3000);
		//Capture product info
		//String x="//span[text()='Apple iPhone 13 (128GB) - Midnight']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[text()='52,090']";
		//String prodPrice=driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Midnight']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[text()='52,090']")).getText();
		//String element=driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']/../../../following-sibling::div[2]/div/div/div/div/div/a/span")).getText();
		String element=driver.findElement(By.xpath("(//span[text()='"+ProductName+"'])[1]/../../../following-sibling::div[2]/div/div/div/div/div/a/span/span/span[2]")).getText();
		System.out.println(element);
		
	}

}
