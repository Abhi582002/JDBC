package DAY1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class PrepareWithUpdateQuery 
{
	public static void main(String[] args) 
	{

		try
		{  
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
		PreparedStatement stmt=con.prepareStatement("update emp set ename=? where eid=?");  
		
		stmt.setString(1,"bbb");		
		stmt.setInt(2,101); 
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records Updated");  
		
		con.close();  
	}catch(Exception e){ System.out.println(e);}  


	}

}