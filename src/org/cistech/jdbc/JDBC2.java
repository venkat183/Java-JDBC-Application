package org.cistech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {

    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/MyDB";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "password";
        Statement st = null;

        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("connection ready");
            st = conn.createStatement();
            String sql = "Delete from MyDB.Persons where ID = 5 or ID =4 ";
            int count =  st.executeUpdate(sql);
            System.out.println("No of rows deleted: " + count);

        } catch (Exception ex) {
            // handle the error
            ex.printStackTrace();
        }
        finally{
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
