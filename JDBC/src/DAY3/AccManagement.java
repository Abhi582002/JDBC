package DAY3;

import java.sql.*;
import java.util.Scanner;

public class AccManagement {

	public static void main(String args[]) {
		
		  
		try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		  	  //Step 2:Create connection  
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
			 
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the account no :");
		  int Accno= sc.nextInt();
		  
		 PreparedStatement ps=con.prepareStatement("select* from accounts where Accno=?");
	
         ps.setInt(1, Accno);
         ResultSet i=ps.executeQuery();
         if(i.next())
			{
				  System.out.println("  "+i.getInt(1)+ " "+i.getString(2)+"   "+i.getInt(3));
			}
         else {
             System.out.println("Account not found.");
             return;
         }
			
         System.out.println("Enter the amount you want to withdraw:");
		 int b = sc.nextInt();
		 PreparedStatement ps1=con.prepareStatement("update bank set balance=balance-? where Accno=?");
		 ps1.setInt(1, b);
         ps1.setInt(2, Accno);    
         ps1.execute();
         System.out.println("Enter the account you want to transefer : ");
         int Accno1= sc.nextInt();
         PreparedStatement ps2=con.prepareStatement("update bank set balance=balance+? where Accno=?");
		 ps2.setInt(1, b);
         ps2.setInt(2, Accno1);   
        ps2.execute();
        
        PreparedStatement ps3=con.prepareStatement("select* from bank");
        ResultSet rs=ps3.executeQuery();
        while(rs.next()) {
        	System.out.println("Account no : "+rs.getInt(1)+" Name:"+rs.getString(2)+" balance:"+rs.getInt(3));
        }
		  
		  
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SecurityException e) {
			e.printStackTrace();
		}
	}
}
