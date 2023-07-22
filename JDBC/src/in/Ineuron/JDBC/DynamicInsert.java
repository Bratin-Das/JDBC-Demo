
package in.Ineuron.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class DynamicInsert
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		int uid		 = sc.nextInt();
		String name  = " ' " +sc.next()+ " ' ";
		int age 	 = sc.nextInt();
		String team  = " ' " +sc.next()+ " ' ";
		
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
						String insertsqlQuery = "insert into student value("  +uid+ "," +name+ "," + age + "," + team +")";
						
						//Using statement object to execute the query(conversation with the shop for buying Gold)
						int noOfRows = statement.executeUpdate(insertsqlQuery);
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
				if(sc != null)
					sc.close();
		
	}
}
