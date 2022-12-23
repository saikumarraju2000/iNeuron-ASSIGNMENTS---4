package problem2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import ineuron.jdbcUtil.JdbcUtil;

public class dateretrieval
{
	public static void main(String[] args) throws SQLException, ParseException
	  {
		Connection connection= null;
		PreparedStatement pstmt=null;
		ResultSet resultset=null;
		
		Scanner sc= new Scanner(System.in);      
		/*System.out.println("Enter sid");
		int sid= sc.nextInt();*/
		System.out.println("Enter sname");
		String name= sc.next();
		
		
		
		
		
		String Query= "select name,address,gender,DOB,DOJ,DOM from dateoperations where name=?";
		
		
		try
		{
			connection= JdbcUtil.getJdbcConnection();
			
			   if(connection!=null)
				{
				  pstmt= connection.prepareStatement(Query);
				}
			   if(pstmt!=null)
			   {
				  
				   pstmt.setString(1, name);
				 
				   resultset = pstmt.executeQuery();
			   }
			   if(resultset!=null)
			   {
				   if(resultset.next())
					{
					  SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
					  java.sql.Date dob= resultset.getDate(4);
					  String DOB=sdf.format(dob);
					  
					  java.sql.Date doj= resultset.getDate(5);
					  String DOJ=sdf.format(dob); 
					  
					  java.sql.Date dom= resultset.getDate(6);
					  String DOM=sdf.format(dob);
					  
					  
					  
				     System.out.println("Name\t             address\t             gender\t                   DateOfBirth\t           DateOfJoining\t           DateOfMarriage");
					 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					 System.out.println(resultset.getString(1)+"\t             "+resultset.getString(2)+"\t             "+resultset.getString(3)+"\t                    "+DOB+"\t              "+DOJ+"\t              "+DOM);
				    }
					else
						System.out.println("Invalid credentials, Name not found in database");
				   
			   }
		}
		catch(SQLException se) {se.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		finally
		{
			JdbcUtil.closeConnetion(resultset, pstmt, connection);
			if(sc!=null) sc.close();
			
		}
		
		
		
	  }

}
