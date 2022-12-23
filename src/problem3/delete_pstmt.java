package problem3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ineuron.jdbcUtil.JdbcUtil;

public class delete_pstmt
{

	 public static void main(String[] args) throws SQLException
	  {
		Connection connection= null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter sid");
		int sid=sc.nextInt();
		
		String sqlQuery = "delete from school where sid=?";
		
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
				   
				   int rowsdeleted= pstmt.executeUpdate();
				   if(rowsdeleted<1)System.out.println("You have entered wrong sid. kindly enter sid only which is available in database");
				   else System.out.println("Rows deleted "+rowsdeleted);
				   
			   }
		
			   }
		catch(SQLException se) {se.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		finally
		{
			JdbcUtil.closeConnetion(null, pstmt, connection);
			if(sc!=null)sc.close();
			
		}
		
		
		
	  }
}
