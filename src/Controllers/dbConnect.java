/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/**
 *
 * @author lienn
 */
public class dbConnect {
    Connection conn=null;
    public Connection getConnect(){
        try{
            //Nạp driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Tạo kết nối đến DB Server
            String username="sa";
            String password="Lien12122004@";
            String dbUrl="jdbc:sqlserver://localhost:1433;databaseName=Quan_ly_thu_vien_phim;encrypt=false;trustServerCertificate=true";
            conn=DriverManager.getConnection(dbUrl, username, password );
            System.out.println("KET NOI THANH CONG");
        }catch(Exception ex){
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, "Lỗi khi kết nối cơ sở dữ liệu", ex);
        }
        return conn;
    }
}
