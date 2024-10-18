package LAB1;

import java.util.Scanner;
import java.sql.*;
public class SearchingDemo 
{
	public static void main(String[] args) 
	{
		try
		{
			Scanner sc= new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
			String sql="select * from products where product_code=?";
				
			System.out.print("Enter the Product Code:- ");
			int str=sc.nextInt();
				
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,str);
				
				
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			else
			{
				System.out.println("Enter wrong Product Code");
			}
			
			String sql2="select * from products where price between ? and ?";
			
			System.out.print("Enter the Price Range:- ");
			int pp1=sc.nextInt();
			int pp2=sc.nextInt();
				
			PreparedStatement ps1=con.prepareStatement(sql2);
			ps1.setInt(1,pp1);
			ps1.setInt(2,pp2);
				
				
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next())
			{
				System.out.println(" "+rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getInt(3));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);  
		}
	}

}