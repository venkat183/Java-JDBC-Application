package org.cistech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableDemo2 {

    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();

        try {
            CallableStatement cs = connection.prepareCall("{ call spStoredproc2()}");
            ResultSet rs = cs.executeQuery();

            rs.next();
            int totalRows = rs.getInt(1);
            System.out.println("totalRows: "+ totalRows);
            
            if(cs.getMoreResults()){
                ResultSet rs2 = cs.getResultSet();
                while(rs2.next()){
                    int id = rs2.getInt(1);
                    String fistName  = rs2.getString(2);
                    int  age  = rs2.getInt(3);
                    System.out.print("Id:"+ id + " fistName:" + fistName + " Age:"+age);
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
