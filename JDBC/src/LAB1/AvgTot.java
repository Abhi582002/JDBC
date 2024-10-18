package LAB1;

import java.sql.*;
public class AvgTot
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
			
			String sql1="select min(price) from products";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();
			
			String sql2="select max(price) from products";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ResultSet rs2=ps2.executeQuery();
			
			String sql3="select avg(price) from products";
			PreparedStatement ps3=con.prepareStatement(sql3);
			ResultSet rs3=ps3.executeQuery();
			
			String sql4="select count(product_code) from products";
			PreparedStatement ps4=con.prepareStatement(sql4);
			ResultSet rs4=ps4.executeQuery();
			
			if(rs1.next())
			{
				System.out.println("Minimum of product:- "+rs1.getInt(1));
			}
			if(rs2.next())
			{
				System.out.println("Maximum of product:- "+rs2.getInt(1));
			}
			if(rs3.next())
			{
				System.out.println("Average of product:- "+rs3.getInt(1));
			}
			if(rs4.next())
			{
				System.out.println("Total Count of product:- "+rs4.getInt(1));
			}
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}

}