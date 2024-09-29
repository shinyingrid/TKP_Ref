package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {

	public static void main(String[] args) throws SQLException 
	{
		String ExpectedProjectID="TK_PROJ_2024";
		boolean flag = false;
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("DB connected");
		Statement stat = conn.createStatement();
		ResultSet resultSet = stat.executeQuery("select * from project");
		while(resultSet.next())
		{
			String actProjectID = resultSet.getString(1);
			if(actProjectID.equals(ExpectedProjectID))
			{
				flag=true;
				System.out.println(ExpectedProjectID +" is available. Test is PASS");
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
			}
		}
		
		if(flag==false)
		{
			System.out.println(ExpectedProjectID +" is not available. Test is FAIL");
		}
		
		
	}

}
