package DAY1;

import java.sql.*;
public class JDBCDemo1 
{
 public static void main(String[] args) 
 {
	 try
	 {
	  //Step 1:Load the driver
 	  Class.forName("oracle.jdbc.driver.OracleDriver");
  	  //Step 2:Create connection  
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
	  //Step 3:Handle the exceptions
	  //Step 4:Create SQL Query
	  String sql="select * from emp";
	  //Step 5:Associate SQL Query with connection.
	  Statement stmt=con.createStatement();
	  //Step 6:Get the Result
	  ResultSet rs=stmt.executeQuery(sql);
	  //Step 7:Process the Result
	  while(rs.next())
	  {
		  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
	  }
	  //Step 8:Close the Connection
	  con.close();
	 }
	 catch(SQLException e) 
	 {
	   e.printStackTrace();
	 }
	 catch(ClassNotFoundException e) 
	 {
	   e.printStackTrace();
	 }
 }//end main
}//end class