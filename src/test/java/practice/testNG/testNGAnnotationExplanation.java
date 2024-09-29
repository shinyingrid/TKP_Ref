package practice.testNG;

import org.testng.annotations.Test;

public class testNGAnnotationExplanation 
{
	@Test
	public void test1()
	{
		System.out.println("Execute TestNG sample test");
	}
	
	//Multiple @Test methods can be used within a class
	@Test
	public void CreateContTest()
	{
		System.out.println("Execute TestNG CreateContTest test");
	}
	
	
	//No Annotation - java interpreter considers this method as java method
	//and will look for main method to execute. So this method is not executed
	public void withoutAnnotationTest()
	{
		System.out.println("Execute TestNG createConWithPhoneTest test");
	}
	
	
	//Changing the return type - we need to add a return statement within 
	//method - it is not executed: As per rule - return type is VOID
	@Test
	public int returnTypeTest()
	{
		System.out.println("Chaning the return type to int");
		return 0;
	}
	
	//Changing the access specifier to private : It will get executed
	//But it is not advisable to use coz if we use in command line or Jenkins 
	//private scope might create an issue
	@Test
	private void accessSpecifierTest()
	{
		System.out.println("Changing access specifier");
	}
}
