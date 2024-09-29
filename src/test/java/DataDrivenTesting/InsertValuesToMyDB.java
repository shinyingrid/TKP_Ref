package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertValuesToMyDB 
{
	public static void main(String[] args) throws SQLException, Throwable
	{
		Random ran = new Random();
		int ranNum=ran.nextInt();
		String ExpectedProjectID="TK_07"+ranNum;
		System.out.println(ExpectedProjectID);
		boolean flag= false;
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/test", "root", "root");
		Statement stat = conn.createStatement();
		int result = stat.executeUpdate("insert into TekPyramid values('"+ExpectedProjectID+"','Google','Shika','21/04/2024');");
		ResultSet resultSet = stat.executeQuery("select * from TekPyramid");
		while(resultSet.next())
		{
			if(resultSet.getString(1).equals(ExpectedProjectID))
			{
				flag=true;
				System.out.println("Value inserted successfully: PASS");
				System.out.println();
				System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4));
			}
			
		}
		if(flag==false)
		{
			System.out.println("Value is not inserted : FAIL");
		}
			
		
		Thread.sleep(2000);
		conn.close();
	}

}
