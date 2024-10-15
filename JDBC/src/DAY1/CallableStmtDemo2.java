package DAY1;

import  java.sql.*;
public class CallableStmtDemo2 
{
 public static void main(String[] args) 
 {
	 try
		{
	     Class.forName("oracle.jdbc.driver.OracleDriver");  
	     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
		 CallableStatement stmt=con.prepareCall("{?=call addnums(?,?)}");
		 stmt.setInt(2,15);
		 stmt.setInt(3,5);
		 stmt.registerOutParameter(1,Types.INTEGER);
		 stmt.execute();
		 System.out.println("Addition of Numbers:"+stmt.getInt(1));
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		}	
 
 }
}
