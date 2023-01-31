package org.cistech.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchDemo {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        int[] count;
        try {
            Statement st = con.createStatement();
            st.addBatch("Insert into Persons\n" +
                    "values (12, 'Last 7', 'First 7',31 )");
            st.addBatch("Insert into Persons\n" +
                    "values (13, 'Last 8', 'First 8',32 )");
            st.addBatch("Insert into Persons\n" +
                    "values (14, 'Last 9', 'First 9',33 )");
            st.addBatch("Insert into Persons\n" +
                    "values (15, 'Last 10', 'First 10',34 )");
            st.addBatch("Insert into Persons\n" +
                    "values (16, 'Last 11', 'First 11',35 )");
           count = st.executeBatch();

            System.out.println(Arrays.toString(count));

            for(int i =0; i< count.length;i++){
                System.out.println(count[i] +" rows updated for query : "+ (i+1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /**
         *
         * Create a table called Employees with columns ID, Name, Salary, Email
         * Insert at least 5 or 6 Employee record
         * Write a JDBC program to retrieve employee objects from the table and print out all the
         * employees from the table that's created.
         */

    }
}
