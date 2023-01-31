package org.cistech.jdbc;

import java.sql.*;

public class JDBC3 {

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
            String sql = "Select * from MyDB.Persons ";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println("Total Column count: "+ metaData.getColumnCount());
            int columnCount = metaData.getColumnCount();


        } catch (Exception ex) {
            // handle the error
            ex.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
