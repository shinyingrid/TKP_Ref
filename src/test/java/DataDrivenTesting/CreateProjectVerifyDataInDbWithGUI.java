package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectVerifyDataInDbWithGUI {

	public static void main(String[] args) throws Throwable 
	{
		//Create Project In GUI
		Random ran = new Random();
		int ranNum = ran.nextInt();
			String ProjectName="JDBCDemo"+ranNum;
		boolean flag = false;
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get("http://106.51.90.215:8084/dashboard/projects");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(ProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Shiny Ingrid C");
		WebElement dropDown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon=\"right-from-bracket\"]")).click();
		
//		wait.until(ExpectedConditions.elementToBeClickable(logout));
//		logout.click();
		
		
		//Verify the Project in DB
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		Statement stat = conn.createStatement();
		ResultSet resultSet = stat.executeQuery("select*from project");
		while(resultSet.next())
		{
			//System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5));
			if(resultSet.getString(4).equals(ProjectName))
			{
				flag=true;
				System.out.println("------------*****--------------");
				System.out.println("Project is created successfully : PASS");
				System.out.println("------------*****--------------");
			}
		}
		
		if(flag==false)
		{
			System.out.println("Project is not available in BD: FAIL");
		}
	
	}

}
