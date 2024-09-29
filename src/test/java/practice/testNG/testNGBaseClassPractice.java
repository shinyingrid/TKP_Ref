package practice.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class testNGBaseClassPractice 
{

	@BeforeSuite
	public void ConfigBS()
	{
		System.out.println("Before Suite===>connect to DB, Report Config");
	}
	
	@BeforeClass
	public void ConfigBC()
	{
		System.out.println("After class===>Launch the browser");
	}

	@BeforeMethod
	public void ConfigBM()
	{
		System.out.println("Before Method==>Login");
	}
	
	@AfterMethod
	public void ConfigAM()
	{
		System.out.println("After Method==>Logout");
	}
	
	@AfterClass
	public void ConfigAC()
	{
		System.out.println("Before Class==>Close the browser");
	}
	

	@AfterSuite
	public void ConfigAS()
	{
		System.out.println( " After Suite==>Close the configuration");
	}
	
}
