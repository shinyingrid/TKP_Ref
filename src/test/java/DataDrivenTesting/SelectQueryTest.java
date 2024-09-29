package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	
	public static void main(String[] args) throws SQLException {
		
		//Step 1: Load/Register the database driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2: Connect to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("DB connected");
		
		//Step 3: Create a sql statement
		Statement stat = conn.createStatement();
		
		//Step 4: Execute select query and get the result
		ResultSet resultSet = stat.executeQuery("select * from project");
		
		while(resultSet.next())
		{
			//System.out.println(resultSet.getString(1));
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
		}
		
		//Step 5: Close the connection
		conn.close();
	}
}
