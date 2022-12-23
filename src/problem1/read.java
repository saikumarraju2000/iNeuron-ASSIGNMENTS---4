package problem1;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class read 
{
	
	void readmethod() throws SQLException
	{
		
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		
		
		String url = "jdbc:mysql://localhost:3306/student_ineuron";
		String username="root";
		String password="password";
		
		try 
		{
			connection=DriverManager.getConnection(url,username,password);
			
			if(connection !=null)
			{
				statement = connection.createStatement();
			}
			if(statement!=null)
			{
				String sqlquery="select sid,sname,sage,saddr from student";
				resultset=  statement.executeQuery(sqlquery);	
			}
			if(resultset!=null)
			{
				System.out.println("SID\tSNAME\tSAGE\tSADDR");
				System.out.println("--------------------------------------");
				while(resultset.next()){
				Integer id = resultset.getInt(1);
				String name = resultset.getString(2);
				Integer age = resultset.getInt(3);
				String addr = resultset.getString(4);
				System.out.println(id+"\t"+name+"\t"+age+"\t"+addr);
				}
			}
		}
		
		
		
		catch(SQLException se){se.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		finally 
		{
			if(resultset!=null)resultset.close();
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
