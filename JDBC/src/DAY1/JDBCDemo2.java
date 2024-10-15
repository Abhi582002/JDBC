package DAY1;

import java.sql.*;
public class JDBCDemo2
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
	  String sql="insert into emp values(104,'aaa',12000)";
	  //Step 5:Associate SQL Query with connection.
	  Statement stmt=con.createStatement();
	  int i=stmt.executeUpdate(sql);  // i/u/d
	   if(i>0)
	  {
		  System.out.println("Record Inserted Successfully...");
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