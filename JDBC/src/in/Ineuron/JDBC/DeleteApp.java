package in.Ineuron.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DeleteApp
{
	public static void main(String[] args) throws SQLException 
	{

		
		//Establish the connection	b/w Java & DB (the road towards gold shop)
		String url = "jdbc:mysql://localhost:3306/javaenterprise";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url, username, password);

			if(connection != null)
				{
				// Create the Statement Object (Car to reach the Gold shop)
				statement  = connection.createStatement();
				
					if(statement != null)
					{		
						String deleteQuery = "delete from student where sid = 33";
						
						//Using statement object to execute the query(conversation with the shop for buying Gold)
						int noOfRows = statement.executeUpdate(deleteQuery);
						System.out.println("No. of Rows Affected :: "+ noOfRows);;
					}
				}
				
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				// close the statements by order or just close the connection or leave it as jvm will do 
				if(connection != null)
					connection.close();
		
	}
}
