package DAY1;

import java.sql.*;
public class CallableStmtDemo1 
{ 
 public static void main(String args[])
 {
   try
	{
     Class.forName("oracle.jdbc.driver.OracleDriver");  
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
	 CallableStatement stmt=con.prepareCall("{call addnum(?,?,?)}");
	 stmt.setInt(1,10);
	 stmt.setInt(2,5);
	 stmt.registerOutParameter(3,Types.INTEGER);
	 stmt.execute();
	 System.out.println("Addition of Numbers:"+stmt.getInt(3));
	}
	catch(Exception e)
	{
	   e.printStackTrace();
	}
 }// end main
}// end class