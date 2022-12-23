package problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class delete 
{
	void deletemethod() throws SQLException
	{
		  Connection connection=null;
  	       Statement statement=null;
  		
  		
  		
  		
  		
  		String url = "jdbc:mysql://localhost:3306/student_ineuron";
  		String username="root";
  		String password="password";
  		
  		Scanner sc= new Scanner(System.in);
  		System.out.println("--------------------------------------------------------");
  		System.out.println("Enter the age of the student from the available table to perform delete operation");
  		int age=sc.nextInt();
  	
  		
  		
  		try 
		{
			connection=DriverManager.getConnection(url,username,password);
			
			if(connection !=null)
			{
				statement = connection.createStatement();
			}
			if(statement!=null)
			{
				String sqlquery = "delete from student where sage="+age+"";
				
				System.out.println(sqlquery);
				int rowsaffected=  statement.executeUpdate(sqlquery);
				
				System.out.println("No.of rows deleted===>  "+rowsaffected);
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
