package practice.testNG;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportAttachingScreenshot {

	ExtentSparkReporter spark;
	ExtentReports report;
	
	@BeforeSuite
	public void bs()
	{
		//ExtentSparkReporter : To setup the High Level Configuration
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM create contact Report");
		spark.config().setTheme(Theme.DARK);
		
		//ExtentReport: To Add Environment Information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "EDGE");
	}

	@Test
	public void createContact()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888");	
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);//ExtentReport supports BASE64
		//Returns screenshot location. Use this path in the test script
		
				
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO,"Login to app");//info log
		test.log(Status.INFO,"Navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HFDSC"))
		{
			test.log(Status.PASS,"contact is created==> PASS"); // pass log
		}
		else
		{
			test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
			//add the captured screenshot and give a name
			
			test.log(Status.FAIL,"contact not created==>FAIL");
		}
		
		report.flush(); 
		test.log(Status.INFO,"createContact==>PASS");
	}
		
	@AfterSuite
	public void as()
	{
		report.flush();
	}

}
