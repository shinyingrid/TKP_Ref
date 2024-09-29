package practice.testNG;

import org.testng.annotations.Test;

public class testNGDependsOn
{
	@Test
	public void createOrderTest()
	{
		String str = null;
		if(str.equals("123"))  //failing on purpose
		{
			System.out.println("Statement is true");
		}
		System.out.println("Execute CreateOrderTest ==> 123");
	}
	
	@Test(dependsOnMethods = "createOrderTest")
	public void BillingAnOrderTest()
	{
		System.out.println("Execute BillingAnOrderTest ==> 123");
	}
	
	
	
}
