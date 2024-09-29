package practice.testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSample 
{
	@Test
	public void createContactTest()
	{ 
		//ExtentSparkReporter : To setup the High Level Configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM create contact Report");
		spark.config().setTheme(Theme.DARK);
		
		//ExtentReport: To Add Environment Information and create test
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "EDGE");
		ExtentTest test = report.createTest("createContactTest"); //create Test returns the object of ExtentTest
		
		
		test.log(Status.INFO,"Login to app");//info log
		test.log(Status.INFO,"Navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created==> PASS"); // pass log
		}
		else
		{
			test.log(Status.FAIL,"contact not created==>FAIL");
		}
		
		report.flush(); // log will not be saved if we dont use this. Take a backup
		test.log(Status.INFO,"Logout of app");
	}
}
