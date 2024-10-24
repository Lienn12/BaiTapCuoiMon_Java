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
    private String Username;
    private String Password;
    private String Email;
    private String Role;
    
    public User_model() {
    }

    public User_model(String Username, String Password, String Email, String ROLE) {
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Role = ROLE;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getRole() {
        return Role;
    }
    
    public User_model(ResultSet rs) throws SQLException{
        this.Username =rs.getString("Username");
        this.Password =rs.getString("Password");
        this.Email = rs.getString("Email");
        this.Role = rs.getString("Role");
    }
    
    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setRole(String ROLE) {
        this.Role = ROLE;
    }
    
    
    
}
