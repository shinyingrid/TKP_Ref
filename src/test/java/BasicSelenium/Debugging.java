package BasicSelenium;

public class Debugging {
   
	public static void main(String[] args) {
		int num=123;
		int rem=0,sum=0;
		while(num>0) {
			rem=num%10;
			sum=sum+rem;
			num=num/10;
		}
		System.out.println(sum);
	}
}
