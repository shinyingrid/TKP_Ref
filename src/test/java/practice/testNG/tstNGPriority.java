package practice.testNG;

import org.testng.annotations.Test;

public class tstNGPriority 
{
	@Test
	public void testSample1()
	{
		System.out.println("Execution of Test 1");
	}
	
	@Test(priority=0)
	public void testSample2()
	{
		System.out.println("Execution of Test 2");
	}
	
	@Test(priority =-1)
	public void testSample3()
	{
		System.out.println("Execution of Test 3");
	}
	@Test(priority=1)
	public void testSample4()
	{
		System.out.println("Execution of Test 4");
	}

}
