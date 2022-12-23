package problem3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ineuron.jdbcUtil.JdbcUtil;

public class select_pstmt
{
	 public static void main(String[] args) throws SQLException
	  {
		Connection connection= null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sid");
		int sid=sc.nextInt();
		
		String sqlQuery="select * from school where sid=?";
		//String sqlQuery="select sid,sname,sage,saddr from school";
		
		try
		{
			connection= JdbcUtil.getJdbcConnection();
			
			   if(connection!=null)
				{
				  pstmt= connection.prepareStatement(sqlQuery);
				}
			   if(pstmt!=null)
			   {
				 
				   pstmt.setInt(1, sid);
				   resultset= pstmt.executeQuery();
				   
			   }
			   if(resultset!=null)
				{
				   
					
					if(resultset.next())
					{
				     System.out.println("SID\t             SNAME\t            SAGE\t           SADDR");
					 System.out.println("-----------------------------------------------------------------------");
					 System.out.println(resultset.getInt(1)+"\t             "+resultset.getString(2)+"\t             "+resultset.getInt(3)+"\t                    "+resultset.getString(4));
				    }
					else
						System.out.println("Invalid credentials, ID number not found in database");
				
			   
		}}
		catch(SQLException se) {se.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		finally
		{
			JdbcUtil.closeConnetion(resultset, pstmt, connection);
			if(sc!=null)sc.close();
			
		}
		
		
		
	  }
}
