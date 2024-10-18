package LAB1;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Displaydemo {
    JFrame f;
    JTable j;

    public static void main(String[] args) {
        new Displaydemo().displayData();
    }

    public void displayData() {
        Connection con = null;
        try {
        	 Class.forName("oracle.jdbc.driver.OracleDriver");  
      		  
       		 //step2 create  the connection object                //localhost
       		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hr","hr");
           String str = "SELECT * FROM products";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(str);


            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = metaData.getColumnName(i + 1);
            }

            // Create data array
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            // Set up JTable
            j = new JTable(model);
            JScrollPane sp = new JScrollPane(j);
            f = new JFrame("Product Data");
            f.add(sp);
            f.setSize(600, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            // Clean up
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}