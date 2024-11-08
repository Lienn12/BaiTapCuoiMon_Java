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
    private int userID;
    private String username;
    private String email;
    private String password;
    private String verifyCode;
        
    public User_model() {
    }

    public User_model(int userID, String username, String email, String password, String verifyCode) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }
    public User_model(int userID,String username, String email, String password) {
        this.userID=userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public User_model(ResultSet rs) throws SQLException{
        this.userID=rs.getInt("UserID");
        this.username =rs.getString("Username");     
        this.email = rs.getString("Email");
        this.password =rs.getString("Password");
        this.verifyCode= rs.getString("VerifyCode");
    }
    
    
    
    
}