package org.cistech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo1 {

    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        try {
            CallableStatement cs = connection.prepareCall("{call spAddNum(?,?,?)}");
            cs.setInt(1, 50);
            cs.setInt(2, 30);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            int sum = cs.getInt(3);
            System.out.println("Sum from stored proc: "+ sum);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
