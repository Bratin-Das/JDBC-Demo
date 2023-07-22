package in.Ineuron.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

import in.Ineuron.jdbcUtil.JdbcConnection;

public class DynamicInsert
{
	public static void main(String[] args) throws SQLException 
	{
		//Resource used in JDBC
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the User ID : ");
		int uid		 = sc.nextInt();
		
		System.out.println("Enter the Name : ");
		String name  = " ' " +sc.next()+ " ' ";
		
		System.out.println("Enter the age : ");
		int age 	 = sc.nextInt();
		
		System.out.println("Enter the team : ");
		String team  = " ' " +sc.next()+ " ' ";
		char c = 'A'+4;
		System.out.println(c);
		
		String sqlQuery = "insert into student values(?,?,?,?)";
		
		try {
				connection = JdbcConnection.getJdbcConnection();
				if(connection != null)
					pstmt = connection.prepareStatement(sqlQuery);
				if(pstmt != null)
				{
					pstmt.setInt(1, uid);
					pstmt.setString(2, name);
					pstmt.setInt(3, age);
					pstmt.setString(4, team);
					
					int rowsAffected = pstmt.executeUpdate();
					System.out.println("No. of Rows Affected = "+rowsAffected);
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}	
			catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcConnection.closeConnection(null, pstmt, connection);
				
				if(sc != null)
					sc.close();
			}
	}
}
