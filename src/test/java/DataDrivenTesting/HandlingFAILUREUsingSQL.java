package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class HandlingFAILUREUsingSQL 
{

	public static void main(String[] args) throws SQLException
	{
		Connection conn=null; // making conn global so that it can be used in all blocks
		try
		{
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
				System.out.println("DB connected");
				Statement stat = conn.createStatement();
		        ResultSet resultSet = stat.executeQuery("select * from project");
		        //To fail the script - try with incorrect table name Ex:project123
				
				while(resultSet.next())
				{
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
				}
		}	
		catch(Exception e)
			{
				System.out.println("=========Handle the Exception========");
			}
		
		finally
			{
			conn.close();
			}
	}

}
