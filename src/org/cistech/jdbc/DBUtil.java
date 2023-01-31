package org.cistech.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static boolean isInitialized;

    public static Connection getConnection(){
        if(isInitialized) return null;

        Connection con =null;
        Properties p = new Properties();
        InputStream is =  DBUtil.class.getResourceAsStream("dbUtils.properties");

        try {
            p.load(is);
            Class.forName(p.getProperty("driverClass"));
            con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("pwd"));
            System.out.println("connection ready");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        isInitialized = true;
      return con;
    }


    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void  closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
