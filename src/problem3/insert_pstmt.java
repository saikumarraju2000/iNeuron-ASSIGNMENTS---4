package problem3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import ineuron.jdbcUtil.JdbcUtil;


public class insert_pstmt
{
  public static void main(String[] args) throws SQLException
  {
	Connection connection= null;
	PreparedStatement pstmt=null;
	
	Scanner sc= new Scanner(System.in);
	/*System.out.println("Enter sid");
	int sid= sc.nextInt();*/
	System.out.println("Enter sname");
	String sname= sc.next();
	System.out.println("Enter sage");
	int sage= sc.nextInt();
	System.out.println("Enter address");
	String saddr=sc.next();
	
	String sqlQuery= "insert into school(`sname`,`sage`,`saddr`) values(?,?,?)";
	
	
	try
	{
		connection= JdbcUtil.getJdbcConnection();
		
		   if(connection!=null)
			{
			  pstmt= connection.prepareStatement(sqlQuery);
			}
		   if(pstmt!=null)
		   {
			  // pstmt.setInt(1, sid);
			   pstmt.setString(1, sname);
			   pstmt.setInt(2, sage);
			   pstmt.setString(3, saddr);
			   
			   int rowsaffected= pstmt.executeUpdate();
			   System.out.println("No of record added :"+rowsaffected);
		   }
	}
	catch(SQLException se) {se.printStackTrace();}
	catch(Exception e) {e.printStackTrace();}
	
	finally
	{
		JdbcUtil.closeConnetion(null, pstmt, connection);
		if(sc!=null) sc.close();
		
	}
	
	
	
  }
}
