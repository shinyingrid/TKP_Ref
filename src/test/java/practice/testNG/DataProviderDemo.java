package practice.testNG;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SampleUtility.PracticeExcelUtility;

public class DataProviderDemo
{

@DataProvider
public Object[][] dataFromDP() throws IOException, Throwable
{
	PracticeExcelUtility elib = new PracticeExcelUtility();
	int lrn = elib.getLastRowNum("DataProvider");
	Object[][] objArr = new Object[lrn+1][2]; //rowcount+1
	
	for(int i=0;i<=lrn;i++)
	{
		objArr[i][0]=elib.getDataFromExcel("DataProvider", i, 0);
		objArr[i][1]=elib.getDataFromExcel("DataProvider", i, 1);
	}
	
	return objArr;
	
}

	@Test(dataProvider="dataFromDP")
	public void demoDataProvider(String ProductName, String ModelName)
	{
		//System.out.println();
	}

}
