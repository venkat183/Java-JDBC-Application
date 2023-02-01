package org.cistech.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;


public class BlobDemo2 {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        Statement st = null;
        String sql = "Select * from  MyDB.FileInfo where Id=1";
        ResultSet rs = null;

        try {
             st = connection.createStatement();
             rs = st.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt(1);
                String fileName = rs.getString(2);
                Blob blob = rs.getBlob(3);
                byte[] arr = blob.getBytes(1, (int) blob.length());
                File f = new File("/Users/venkatbhargavreddymekala/Documents/JDBCFiles2/MyImg2.jpeg");
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(arr);
                fo.flush();
                fo.close();
                System.out.println("Written contents to the file");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

          DBUtil.closeResultSet(rs);
          DBUtil.closeStatement(st);
          DBUtil.closeConnection(connection);

    }
}
