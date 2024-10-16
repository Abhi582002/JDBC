package DAY2;

import java.util.*;
import java.sql.*;
public class CustomerMain 
{
 public static void main(String[] args) 
 {
  Scanner sc= new Scanner(System.in);
  int ch=0;
  try
  {
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
   do
   {
	System.out.println("\n\n1)Create Customer");
	System.out.println("2)Search Customer");
	System.out.println("3)Delete Customer");
	System.out.println("4)Update Customer");
	System.out.print("Enter your choice:");
	ch=sc.nextInt();
	switch (ch) 
	{
	 case 1:
		    System.out.print("Customer Id:");
		    int cid=sc.nextInt();
		    System.out.print("Customer Name:");
		    String cname=sc.next();
		    System.out.print("Customer City:");
		    String city=sc.next();
		    PreparedStatement ps1=con.prepareStatement("insert into cust values(?,?,?)");
		    ps1.setInt(1,cid);
		    ps1.setString(2,cname);
		    ps1.setString(3,city);
		    int i=ps1.executeUpdate();
		    if(i>0)
		    	System.out.println("Record inserted sucessfully...!!!");
		    else
		    	System.out.println("Operation Denied...!!!");
		    break;
		    
	 case 2:
		    System.out.print("Customer Id:");
		    cid=sc.nextInt();
		    PreparedStatement ps2=con.prepareStatement("Select * from cust where cid=?");
		    ps2.setInt(1,cid);
		    ResultSet rs=ps2.executeQuery();
		    if(rs.next())
		    {
		    	System.out.println("Customer Id:"+rs.getInt(1));
		        System.out.println("Customer Name:"+rs.getString(2));
		        System.out.println("Customer City:"+rs.getString(3));
		    }
		    else
	        {
		       System.out.println("Record Not Found...!!!");
	        }
		    break;
		    
	 case 3:
		 //delete by idwise
		 System.out.print("Customer Id to delete: ");
         cid = sc.nextInt();
         PreparedStatement ps3 = con.prepareStatement("DELETE FROM cust WHERE cid = ?");
         ps3.setInt(1, cid);
         int j = ps3.executeUpdate();
         if (j > 0)
             System.out.println("Record deleted successfully...!!!");
         else
             System.out.println("Record Not Found...!!!");
         break;

	 case 4:
		 //update idwise
		 System.out.print("Customer Id to update: ");
         cid = sc.nextInt();
         System.out.print("New Customer Name: ");
         cname = sc.next();
         System.out.print("New Customer City: ");
         city = sc.next();
         PreparedStatement ps4 = con.prepareStatement("UPDATE cust SET cname = ?, city = ? WHERE cid = ?");
         ps4.setString(1, cname);
         ps4.setString(2, city);
         ps4.setInt(3, cid);
         int k = ps4.executeUpdate();
         if (k > 0)
             System.out.println("Record updated successfully...!!!");
         else
             System.out.println("Record Not Found...!!!");
         break;
         
	 case 5:
		 //Exit
		 System.out.println("Exiting program...");
         break;
		    
 	default:
 			break;
	}//end switch
   }while(ch!=0);//end while   
  }//end try
  catch (SQLException e) 
  {
	e.printStackTrace();
  }
  catch(ClassNotFoundException e) 
  {
	e.printStackTrace();
  }	 
 }//end main
}//end class