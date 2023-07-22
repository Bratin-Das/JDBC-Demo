package in.Ineuron.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectApp
{
	public static void main(String[] args) throws SQLException 
	{
		//Load the Driver
//		Driver driver = new Driver();                                     // still works
//		DriverManager.registerDriver(driver);
		
		//Establish the connection	b/w Java & DB (the road towards gold shop)
		String url = "jdbc:mysql://localhost:3306/javaenterprise";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		
		// Create the Statement Object (Car to reach the Gold shop)
		Statement statement  = connection.createStatement();
		
		//Send and Execute the Query (conversation with the shop for buying Gold)
		String sqlSelectQuery = "select sid , sname , sage , saddr from student";
		ResultSet resultset = statement.executeQuery(sqlSelectQuery);
		
		//Process the Result from ResultSet
		System.out.println("SID\tSNAME\tSAGE\tSADDR");
		System.out.println("==============================");
		while(resultset.next())
		{
			Integer id = resultset.getInt(1);
			String name = resultset.getString(2);
			Integer age = resultset.getInt(3);
			String addr = resultset.getString(4);
			System.out.println(id+"\t"+name+"\t"+age+"\t"+addr);
		}
		
		// close the statements by order or just close the connection or leave it as jvm will do 
		connection.close();
	}
}
