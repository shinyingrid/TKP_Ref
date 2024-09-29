package practiceParallelMethodsExecution;

import java.lang.reflect.Method;

import org.checkerframework.common.reflection.qual.GetMethod;
import org.testng.annotations.Test;

public class parallelMethTest 
{
	@Test
	public void method1()
	{
		System.out.println("m1 - 1");
		System.out.println("m1 - 2");
		System.out.println("m1 - 3");
		System.out.println("m1 - 4");
		System.out.println("m1 - 5");
	}
	
	@Test
	public void method2()
	{
		System.out.println("m2 - 1");
		System.out.println("m2 - 2");
		System.out.println("m2 - 3");
		System.out.println("m2 - 4");
		System.out.println("m2 - 5");
		
	}
	
	

}
