package practice.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testNGConfigAnnotationsOrderOFExe 
{
	@BeforeMethod
	public void ConfigBM()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void ConfigAM()
	{
		System.out.println("After Method");
	}
	
	@BeforeClass
	public void ConfigBC()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void ConfigAC()
	{
		System.out.println("After class");
	}
	
	@BeforeSuite
	public void ConfigBS()
	{
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void ConfigAS()
	{
		System.out.println( " After Suite");
	}
	
	@Test
	public void method1Test()
	{
		System.out.println("@Test == Method 1");
	}
	
	@Test
	public void method2Test()
	{
		System.out.println("@Test == Method 2");
	}
}
