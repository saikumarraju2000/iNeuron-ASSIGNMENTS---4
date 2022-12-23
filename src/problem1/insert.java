package problem1;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;

public class insert 
{

	void insertmethod() throws SQLException
	{
		Connection connection=null;
		Statement statement=null;
		
		
		
		
		
		String url = "jdbc:mysql://localhost:3306/student_ineuron";
		String username="root";
		String password="password";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sname..!");
		String sname=sc.next();
		
		System.out.println("Enter sage..!");
		int sage=sc.nextInt();
		
		System.out.println("Enter saddr..!");
		String saddr=sc.next();
		
		try 
		{
			connection=DriverManager.getConnection(url,username,password);
			
			if(connection !=null)
			{
				statement = connection.createStatement();
			}
			if(statement!=null)
			{
				String sqlquery =String.format( "insert into student(`sname`,`sage`,`saddr`) values('%s',%d,'%s')",sname,sage,saddr );
				
				System.out.println(sqlquery);
				int rowsaffected=  statement.executeUpdate(sqlquery);
				
				System.out.println("No.of rows affected===>  "+rowsaffected);
			}
			
		}
		
		
		
		catch(SQLException se){se.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		finally 
		{
			
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		}
		
		
	}

}

	
	
