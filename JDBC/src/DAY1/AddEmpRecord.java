package DAY1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

import javax.swing.*;

class Employee extends Frame implements ActionListener
{
   Label l1,l2,l3;
   Button b1;
   TextField t1,t2,t3;
   Employee()
    {     
      setLayout(null);
      setVisible(true);
      setSize(400,350);
        l1=new Label("Employee ID");
        l2=new Label("Employee Name");
        l3=new Label("Salary");

        t1=new TextField();
        t2=new TextField();
        t3=new TextField();
	
        b1=new Button("Submit");
       
        

        l1.setBounds(50,50,90,20);
  	l1.setVisible(true);
        add(l1);
       
        l2.setBounds(50,100,100,20);
  	l1.setVisible(true);
        add(l2);
       
        l3.setBounds(50,150,90,20);
  	l1.setVisible(true);
        add(l3);
      
       t1.setBounds(150,50,90,20);
       t1.setVisible(true);
       add(t1);

       t2.setBounds(150,100,90,20);
       t2.setVisible(true);
       add(t2);

       t3.setBounds(150,150,90,20);
       t3.setVisible(true);
       add(t3);
      

  b1.setBounds(120,200,80,20);
  b1.setVisible(true);
  b1.addActionListener(this);
  add(b1);

 
}
public void actionPerformed(ActionEvent ae)
 {
       
      
      if(ae.getSource()==b1)
       {
            try{
            	 //step1 load the driver class  
       		 //step1 load the driver class  
       		 Class.forName("oracle.jdbc.driver.OracleDriver");  
       		  
       		 //step2 create  the connection object                //localhost
       		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
       		  

                     PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
                    
                     ps.setInt(1,Integer.parseInt(t1.getText()));
                     ps.setString(2,(t2.getText()));
                     ps.setInt(3,Integer.parseInt(t3.getText()));
           
                     int i=ps.executeUpdate(); 
           
                      if(i==1)
                       JOptionPane.showMessageDialog(this,"Record inserted successfully...!!!");
                  con.close();
               } 
             catch(Exception e)
                {  System.out.println(e);        }
      
             }
}
}
public class AddEmpRecord 
{
	public static void main(String args[])
	{
	  Employee e1=new Employee();
	}

}
