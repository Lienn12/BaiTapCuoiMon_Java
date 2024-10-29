/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.sql.*;
import Controllers.dbConnect.*;
import Model.User_model;

public class User_controller {
    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;
    private User_model userModel;
    public User_controller(){
        conn=new dbConnect().getConnect();
    }
    
    public boolean CheckLoginUser(String username, String password) throws SQLException{
       //khởi tạo truy vấn 
       String check_login_query="SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
       //khởi tạp preparedStatement để thực hiện truy vấn
       prst=conn.prepareStatement(check_login_query);
       prst.setString(1, username);
       prst.setString(2, password);
       //chọn phương thực thi phù hợp với truy vấn
       rs=prst.executeQuery();
       if(rs.next()){
            rs.close();
            prst.close();
           return true;
       }
           return false;
    }

    public boolean checkUsername(String username) throws SQLException{
         // Truy vấn để kiểm tra xem người dùng đã tồn tại hay chưa
        String check_user_query = "SELECT * FROM USERS WHERE USERNAME=?";
        prst = conn.prepareStatement(check_user_query);
        prst.setString(1, username);
        rs = prst.executeQuery();

        if (rs.next()) {
            rs.close();
            prst.close();
            return false;
        }else{
            return true;
        }  
    }
    
    public boolean checkEmail(String email){
        String emailRegex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    
    public boolean checkPassword(String password){
        if(password.length()<6){
            return false;
        }
        String passwordRegex="^(?=.*[A-Za-z])(?=.*\\d).+$";
        return password.matches(passwordRegex);
    }
    
    public boolean checkComfirmPassword(String password, String confirmPassword){
        return password.matches(confirmPassword);
    }
    
    public boolean CheckSignup(String username, String email, String password, String confirmPassword) throws SQLException{
        String insert_sql="INSERT INTO USERS(USERNAME, EMAIL, PASSWORD, CONFIRM_PASSWORD) VALUES (?, ?, ?, ?)";
        prst=conn.prepareStatement(insert_sql);
        prst.setString(1, userModel.getUsername());
        prst.setString(2, userModel.getEmail());
        prst.setString(3, password);
        prst.setString(4, confirmPassword);
        int rowsAffected =prst.executeUpdate();
        
        prst.close();  
        return rowsAffected > 0;
    }
    
}
