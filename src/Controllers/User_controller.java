/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.sql.*;
import Controllers.dbConnect.*;
import Model.Message_model;
import Model.User_model;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class User_controller {
    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;
    private User_model userModel;
    public User_controller(){
        conn=new dbConnect().getConnect();
    }
    
     
    public List<User_model> getUser() throws SQLException {
        List<User_model> dsUser= new ArrayList<User_model>();
        String sql="SELECT USER_ID, USERNAME, GENDERNAME, BIRTH,EMAIL FROM USERS, GENDERS WHERE USERS.GENDERID=GENDERS.GENDERID AND STATUS='VERIFIED'";        
        prst= conn.prepareStatement(sql);
        rs=prst.executeQuery();
        while(rs.next()){
            User_model userModel= new User_model(rs);
            dsUser.add(userModel);
        }
        prst.close();
        rs.close();
        return dsUser;
    }
    
    public User_model getUser(int reviewID) throws SQLException{
        String sql="SELECT * FROM REVIEWS WHERE REVIEW_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setInt(1, reviewID);
        rs=prst.executeQuery();
        if(rs.next()){
            User_model userModel = new User_model(rs);
        }
        prst.close();
        rs.close();
        return userModel;
    }
    
    
    //check đăng nhập người dùng 
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
    
    //check đăng ký 
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
            int userID=rs.getInt(1);
            userModel.setUserID(userID);
        }
        
        rs.close();
        prst.close(); 
        userModel.setVerifyCode(code);
    }
    
    //check user đã tồn tại
    public boolean checkDuplicateUser(String username) throws SQLException{
        prst=conn.prepareStatement("SELECT USER_ID FROM USERS WHERE USERNAME=? AND STATUS='VERIFIED'");
        prst.setString(1, username);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
    
    //check email đã tồn tại
    public boolean checkDuplicateEmail(String email) throws SQLException{
        prst=conn.prepareStatement("SELECT USER_ID FROM USERS WHERE EMAIL=? AND STATUS='VERIFIED'");
        prst.setString(1, email);
        rs=prst.executeQuery();
        boolean exist=rs.next();
        rs.close();
        prst.close();
        return exist;
    }
    
    //check email đúng định dạng
    public boolean checkEmail(User_model userModel){
        String emailRegex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return userModel.getEmail().matches(emailRegex);
    }
    
    //check pass đúng định dạng 
    public boolean checkPassword(String password){
        if(password.length()<6){
            return false;
        }
        String passwordRegex="^(?=.*[A-Za-z])(?=.*\\d).+$";
        return password.matches(passwordRegex);
    }
    
    //check confirm có trùng với pass 
    public boolean checkConfirmPassword(String password, String confirmPassword){
        return password.matches(confirmPassword);
    }
    
    //tạo verifyCode ngẫu nhiên
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
    
    //cập nhật status về Verify
    public void doneVerify(int userID) throws SQLException{
        prst=conn.prepareStatement("UPDATE USERS SET VERIFYCODE='',STATUS='VERIFIED' WHERE USER_ID=?");
        prst.setInt(1, userID);
        prst.executeUpdate();
        prst.close();
    }
    
    //check verifyCode đã đúng với userID cho
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
    
    //gửi mã xác thực 
    public boolean sendVerificationCode(User_model userModel) throws SQLException {
        String verifyCode = generateVerifyCode(); 
        userModel.setVerifyCode(verifyCode); 
        Message_model ms = new Email_controller().sendEmail(userModel.getEmail(), verifyCode);
        if (ms.isSuccess()) {
            return true;
        }
        return false;
    }
    
    
    public void ForgotPassword(User_model userModel) throws SQLException {
        prst = conn.prepareStatement("SELECT USER_ID FROM USERS WHERE EMAIL=? AND STATUS='VERIFIED'");
        prst.setString(1, userModel.getEmail());
        rs = prst.executeQuery();

        if (rs.next()) {
            // Lưu userID trước khi tạo PreparedStatement mới
            int userID = rs.getInt(1);
            String code = generateVerifyCode();
            userModel.setUserID(userID);

            // Đóng ResultSet trước khi tạo PreparedStatement mới
            rs.close();

            // Cập nhật mã xác minh trong cơ sở dữ liệu
            prst = conn.prepareStatement("UPDATE USERS SET VERIFYCODE=? WHERE USER_ID=?");
            prst.setString(1, code);
            prst.setInt(2, userID);
            prst.executeUpdate();

            // Lưu mã xác minh vào đối tượng User_model
            userModel.setVerifyCode(code);
        } else {
            System.out.println("Email không tồn tại hoặc chưa được xác minh.");
        }

        // Đóng các tài nguyên sau khi hoàn thành
        rs.close();
        prst.close();
    }
    
        public void ResetPassword(String email, String password) throws SQLException {
        String sql = "UPDATE USERS SET PASSWORD=? WHERE EMAIL=? AND STATUS='VERIFIED'";
        prst = conn.prepareStatement(sql);
        prst.setString(1, password);
        prst.setString(2, email);
        prst.executeUpdate(); 
        prst.close();
    }
    public boolean DeleteData(int userId) throws SQLException{
        String sql="DELETE FROM USERS WHERE USER_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setInt(1,userId);
        int row=prst.executeUpdate();
        prst.close();
        return row>0;
    }
}