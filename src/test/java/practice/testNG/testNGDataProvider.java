package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGDataProvider 
{
	@Test(dataProvider = "getData")
	public void createContactTest(String FN,String LN, Long PhNo)
	{
		System.out.println("First name :"+FN+", Last Name :"+LN+" , Phone No :"+PhNo);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="Shiny";
		objArr[0][1]="Ingrid";
		objArr[0][2]=9324234423l; //Add l at the end since it is long datatype
		
		objArr[1][0]="Stoney";
		objArr[1][1]="Armando";
		objArr[1][2]=9435453454l;
		
		objArr[2][0]="Kate";
		objArr[2][1]="Winslet";
		objArr[2][2]=5234345443l;
		
		return objArr;
	}
	
}
