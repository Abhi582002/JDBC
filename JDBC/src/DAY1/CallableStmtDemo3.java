package DAY1;

import java.sql.*;
public class CallableStmtDemo3 
{
 public static void main(String[] args) 
 {
	 try
		{
	     Class.forName("oracle.jdbc.driver.OracleDriver");  
	     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
		 CallableStatement stmt=con.prepareCall("{call insertemp(?,?,?)}");
		 stmt.setInt(1,105);
		 stmt.setString(2,"Rahul");
		 stmt.setInt(3,25000);
		 int status=stmt.executeUpdate();
		 if(status>0)
		 {
		  System.out.println("Data Inserted Sucessfully");
		 }
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		}
 }
}