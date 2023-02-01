package org.cistech.jdbc;

import java.sql.Blob;
import java.sql.Connection;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobDemo1 {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        File f = new File("/Users/venkatbhargavreddymekala/Documents/JDBCFiles/MyImage1.jpeg");
        String fileName = f.getName();
        byte[] b = new byte[(int) f.length()];
        FileInputStream fis = null;
        PreparedStatement preparedStatement = null;
        try {
             fis = new FileInputStream(f);
             fis.read(b);
             fis.close();
             Blob blob = connection.createBlob();
             blob.setBytes(1, b);
             String sql = "Insert into FileInfo values(?,?,?)";
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, fileName);
            preparedStatement.setBlob(3, blob);
            int rows= preparedStatement.executeUpdate();
            System.out.println("Total rows updated: "+ rows);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBUtil.closeStatement(preparedStatement);
        DBUtil.closeConnection(connection);

    }
}
