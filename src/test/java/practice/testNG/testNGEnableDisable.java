package practice.testNG;

import org.testng.annotations.Test;

public class testNGEnableDisable 
{ 
	@Test(enabled=false)
	public void createOrderTest()
	{
		
		System.out.println("Execute CreateOrderTest ==> 123");
	}
	
	@Test
	public void BillingAnOrderTest()
	{
		System.out.println("Execute BillingAnOrderTest ==> 123");
	}
	
	

}
