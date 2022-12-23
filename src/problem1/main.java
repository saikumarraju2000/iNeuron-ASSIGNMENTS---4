package problem1;

import java.sql.SQLException;
import java.util.Scanner;

public class main
{

	public static void main(String[] args) throws SQLException
	{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the option below");
		System.out.println("1)Create/insert    2)Read    3)Update    4)Delete");
		int option=sc.nextInt();
		
		if(option==1) 
		  {
			insert in= new insert();
			in.insertmethod();
		  }
		if(option==2)	
		 {
			read rd=new read();
			rd.readmethod();
		 }
		
		if(option==3)
		{
			read rd=new read();
			rd.readmethod();
			update up= new update();
			up.updatemethod();
		}
		
		if(option==4)
		{
			read rd=new read();
			rd.readmethod();
			delete d= new delete();
			d.deletemethod();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	  
		
		
		
		
		}
	
	
}
