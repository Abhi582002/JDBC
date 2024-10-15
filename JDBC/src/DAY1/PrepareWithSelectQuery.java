package DAY1;

import java.sql.*;
import java.util.*; 
public class PrepareWithSelectQuery
{
	public static void main(String[] args)
	{
			try
			{  
			Scanner sc= new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
			
			String sql="select * from emp where ename=?";
			
			System.out.print("Enter the Employee name:");
			String ename=sc.next();
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,ename);
			
			
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				  System.out.println(" "+rs.getInt("eid")+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			con.close();	
			
			
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);  
			}
			  
		

	}

	}