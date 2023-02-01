package org.cistech.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        Statement st = null;
        try {
             connection.setAutoCommit(false);
             st = connection.createStatement();
             String sql1= "Insert into Persons\n" +
                     "values (8, 'Last 8', 'First 8',31 )";
             String sql2 = "Update Persons set Age = Age_5 where ID = 6";

             st.executeUpdate(sql1);
             st.executeUpdate(sql2);
             connection.commit();
        } catch (SQLException e) {
            System.out.println("Transaction is being rolled back!");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
         DBUtil.closeStatement(st);
         DBUtil.closeConnection(connection);
    }
}
