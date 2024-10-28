/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.sql.*;
import Controllers.dbConnect.*;
/**
 *
 * @author lienn
 */
public class User_controller {
    Connection conn;
    public User_controller(){
        conn=new dbConnect().getConnect();
    }
    public boolean CheckLoginUser(String username, String password) throws SQLException{
       //khởi tạo truy vấn 
       String check_login_query="SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
       //khởi tạp preparedStatement để thực hiện truy vấn
       PreparedStatement prst=conn.prepareStatement(check_login_query);
       prst.setString(1, username);
       prst.setString(2, password);
       //chọn phương thực thi phù hợp với truy vấn
       ResultSet rs=prst.executeQuery();
       //xử lý dữ liệu trả về
       if(rs.next()){
            rs.close();
            prst.close();
           //đăng nhập thành công
           return true;
       }
           //đăng nhập thất bại
           return false;
    }
//    public boolean CheckLoginAdmin(String username, String password ) {
//        return "admin".equals(username) && "123456".equals(password);
//    }
    public boolean checkUsername(String username) throws SQLException{
         // Truy vấn để kiểm tra xem người dùng đã tồn tại hay chưa
        String check_user_query = "SELECT * FROM USERS WHERE USERNAME=?";
        PreparedStatement checkUserStmt = conn.prepareStatement(check_user_query);
        checkUserStmt.setString(1, username);
        ResultSet rs = checkUserStmt.executeQuery();

        if (rs.next()) {
            rs.close();
            checkUserStmt.close();
            return false; // Người dùng đã tồn tại
        }else{
            return true;
        }
        
    }
    
    public boolean checkEmail(String email){
        String emailRegex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    
    public boolean checkPassword(String password){
        if(password.length()<8){
            return false;
        }
        String passwordRegex="^(?=.*[A-Za-z])(?=.*\\d).+$";
        return password.matches(passwordRegex);
    }
    
    public boolean checkComfirmPassword(String password, String confirmPassword){
        return password.matches(confirmPassword);
    }
    
    public boolean CheckSignup(String username, String email, String password, String confirmPassword) throws SQLException{
        String insert_sql="INSERT INTO USERS VALUES (?, ?, ?, ?)";
        PreparedStatement prst=conn.prepareStatement(insert_sql);
        prst.setString(1, username);
        prst.setString(2, email);
        prst.setString(3, password);
        prst.setString(4, confirmPassword);
        int rowsAffected =prst.executeUpdate();
        
        prst.close();
            // Trả về true nếu đã chèn thành công
        return rowsAffected > 0;
    }
    
}
