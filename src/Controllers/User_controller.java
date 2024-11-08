/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.sql.*;
import Controllers.dbConnect.*;
import Model.User_model;
import java.text.DecimalFormat;
import java.util.Random;

public class User_controller {
    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;
    private User_model userModel;
    public User_controller(){
        conn=new dbConnect().getConnect();
    }
    
    public boolean CheckLoginUser(User_model userModel, String password) throws SQLException{
       //khởi tạo truy vấn r_model userModel
       String check_login_query="SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
       //khởi tạp preparedStatement để thực hiện truy vấn
       prst=conn.prepareStatement(check_login_query);
       prst.setString(1, userModel.getUsername());
       prst.setString(2, password);
       //chọn phương thực thi phù hợp với truy vấn
       rs=prst.executeQuery();
       boolean exist=rs.next();
       rs.close();
       prst.close();
       return exist;
    }
    
    public void CheckSignup(User_model userModel, String password) throws SQLException{
        String insert_sql="INSERT INTO USERS(USERNAME, EMAIL, PASSWORD,VERIFYCODE) VALUES (?, ?, ?, ?)";
        String code= generateVerifyCode();
        prst=conn.prepareStatement(insert_sql,Statement.RETURN_GENERATED_KEYS);
        prst.setString(1, userModel.getUsername());
        prst.setString(2, userModel.getEmail());
        prst.setString(3, password);
        prst.setString(4, code);
        prst.executeUpdate();
        rs=prst.getGeneratedKeys();//lấy các khóa chính tự động sinh ra sau khi insert
        if(rs.next()){
            int userID=rs.getInt(1);//lấy giá trị cột đầu
            userModel.setUserID(userID);
        }
        
        rs.close();
        prst.close(); 
        userModel.setVerifyCode(code);
    }
    
    public boolean checkDuplicateUser(String username) throws SQLException{
        prst=conn.prepareStatement("SELECT USER_ID FROM USERS WHERE USERNAME=? AND STATUS='VERIFIED'");
        prst.setString(1, username);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
    public boolean checkDuplicateEmail(String email) throws SQLException{
        prst=conn.prepareStatement("SELECT USER_ID FROM USERS WHERE EMAIL=? AND STATUS='VERIFIED'");
        prst.setString(1, email);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
    
    public boolean checkEmail(User_model userModel){
        String emailRegex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return userModel.getEmail().matches(emailRegex);
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
    
    private String generateVerifyCode() throws SQLException{
        DecimalFormat df= new DecimalFormat("000000");
        Random random = new Random();
        String code= df.format(random.nextInt(1000000));
        while (checkDuplicateCode(code)){
            code=df.format(random.nextInt(1000000));
        }
        return code;
    }
    //ktra verifyCode có trung với userid ko
    public boolean checkDuplicateCode(String code) throws SQLException{
        prst= conn.prepareStatement("SELECT USER_ID FROM USERS WHERE VERIFYCODE=?");
        prst.setString(1, code);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
    public void doneVerify(int userID) throws SQLException{
        prst=conn.prepareStatement("UPDATE USERS SET VERIFYCODE='',STATUS='VERIFIED' WHERE USER_ID=?");
        prst.setInt(1, userID);
        prst.executeUpdate();
        prst.close();
    }
    public boolean verifyCodeWithUser(int userID, String code) throws SQLException{
        prst = conn.prepareStatement("SELECT USER_ID FROM USERS WHERE USER_ID=? AND VERIFYCODE =?");
        prst.setInt(1, userID);
        prst.setString(2, code);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
}