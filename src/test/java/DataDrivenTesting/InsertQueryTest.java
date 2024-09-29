package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertQueryTest 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("DB connected");
		Statement stat = conn.createStatement();
		int result=stat.executeUpdate("insert into project values('TK_PROJ_2036','SHINYINGRID','26/04/2024','FB500','On Going','100');");
		//int result = stat.executeUpdate("delete from project values('TK_PROJ_2031','SHINYINGRID','26/04/2024','FB500','On Going','100');");
		System.out.println(result);
		
		ResultSet resultSet = stat.executeQuery("select * from project");
		while(resultSet.next())
		{
		System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
		}
		
	}
}
