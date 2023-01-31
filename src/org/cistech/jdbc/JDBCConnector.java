package org.cistech.jdbc;

import java.sql.*;

public class JDBCConnector {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        try {
            st   =  conn.createStatement();
            rs = st.executeQuery("SELECT * FROM MyDB.Persons");

            while(rs.next()){
                int id = rs.getInt(1);
                String lastname  = rs.getString(2);
                String firstname  = rs.getString(3);
                int age  = rs.getInt(4);
                System.out.print("Id:"+ id + " LastName:" + lastname + " FirstName:"+ firstname + " Age:"+age);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(st);
        DBUtil.closeConnection(conn);
    }
}
