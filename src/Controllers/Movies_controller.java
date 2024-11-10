package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import Controllers.dbConnect;

/**
 *
 * @author lienn
 */
public class Movies_controller {
    Connection conn=null;
    PreparedStatement pstmt=null;
    
    public Movies_controller(){
        conn=new dbConnect().getConnect();
    }
    public void saveInfo(String name,int year,String director,String cast,String genre, String descrip ,File imageFile) {
        try (FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = bos.toByteArray();
            String sql = "INSERT INTO MOVIES (TITLE,RELEASE_YEAR,DIRECTOR,CAST,GENRE,DESCRIPTION,COVER_IMAGE) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, year);
            pstmt.setString(3, director);
            pstmt.setString(4, cast);
            pstmt.setString(5, genre);
            pstmt.setString(6, descrip);
            pstmt.setBytes(7, imageBytes);

            pstmt.executeUpdate();
            System.out.println("Lưu thông tin thành công vào cơ sở dữ liệu!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
