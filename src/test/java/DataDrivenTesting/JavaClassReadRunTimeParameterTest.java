package DataDrivenTesting;

public class JavaClassReadRunTimeParameterTest {

	public static void main(String[] args)
	{
		//To get the length of the argument 
		System.out.println(args.length); //output - 0 initial value
		for(String var : args)
		{
			System.out.println(var);
		}
		
	}

}
