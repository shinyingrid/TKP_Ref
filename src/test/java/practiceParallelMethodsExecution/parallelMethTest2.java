package practiceParallelMethodsExecution;

import java.lang.reflect.Method;

import org.checkerframework.common.reflection.qual.GetMethod;
import org.testng.annotations.Test;

public class parallelMethTest2 
{
	@Test
	public void method3()
	{
		System.out.println("m3 - 1");
		System.out.println("m3 - 2");
		System.out.println("m3 - 3");
		System.out.println("m3 - 4");
		System.out.println("m3 - 5");
	}
	
	@Test
	public void method4()
	{
		System.out.println("m4 - 1");
		System.out.println("m4 - 2");
		System.out.println("m4 - 3");
		System.out.println("m4 - 4");
		System.out.println("m4 - 5");
		
	}
	
	

}
