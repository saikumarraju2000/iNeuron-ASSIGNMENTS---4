package problem2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import ineuron.jdbcUtil.JdbcUtil;

public class insertdate
{
	

	public static void main(String[] args) throws SQLException, ParseException
	  {
		Connection connection= null;
		PreparedStatement pstmt=null;
		
		Scanner sc= new Scanner(System.in);      
		/*System.out.println("Enter sid");
		int sid= sc.nextInt();*/
		System.out.println("Enter sname");
		String name= sc.next();
		System.out.println("Enter address");
		
		String address=sc.next();
		System.out.println("Enter gender");
		String gender=sc.next();
		System.out.println("Enter date of birth(dd-mm-yyyy)");
		String dob=sc.next();
		System.out.println("Enter date of joining(mm-dd-yyyy)");
		String doj=sc.next();
		System.out.println("Enter date of marriage(yyyy-mm-dd)");
		String dom=sc.next();
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udob=sdf1.parse(dob);
		Long sdob= udob.getTime();
		java.sql.Date DOB=new java.sql.Date(sdob) ;
		
		
		
		SimpleDateFormat sdf2= new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date udoj=sdf2.parse(doj);
		Long sdoj= udoj.getTime();
		java.sql.Date DOJ=new java.sql.Date(sdoj) ;
		
		
		
		
		java.sql.Date DOM= java.sql.Date.valueOf(dom) ;
		
		
		
		
		
		
		
		String Query= "insert into dateoperations(`name`,`address`,`gender`,`DOB`,`DOJ`,`DOM`) values(?,?,?,?,?,?)";
		
		
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
				   pstmt.setString(2, address);
				   pstmt.setString(3, gender);
				   pstmt.setDate(4, DOB);
				   pstmt.setDate(5, DOJ);
				   pstmt.setDate(6, DOM);
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
