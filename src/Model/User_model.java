/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author lienn
 */
public class User_model {
    private String userID;
    private String username;
    private String email;
    private String password;
    private String confirmPass;
    private int verifyCode;
    
    public User_model() {
    }

    public User_model(String userID, String username, String email, String password, String confirmPass, int verifyCode) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.verifyCode = verifyCode;
    }

    public User_model(String userID, String username, String email, String password, String confirmPass) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public User_model(ResultSet rs) throws SQLException{
        this.username =rs.getString("Username");     
        this.email = rs.getString("Email");
        this.password =rs.getString("Password");
        this.confirmPass =rs.getString("Confirm_Password");
    }
    
    
    
    
}
