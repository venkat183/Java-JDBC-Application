package org.cistech.jdbc;

import java.sql.*;

public class PreParedStatementDemo {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "SELECT * FROM MyDB.Persons where lastname=? or lastname = ?";
            pt  = conn.prepareStatement(sql);
            pt.setString(1, "Last 2");
            pt.setString(2, "Last 3");
            rs = pt.executeQuery();

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
        DBUtil.closeStatement(pt);
        DBUtil.closeConnection(conn);
    }

}
