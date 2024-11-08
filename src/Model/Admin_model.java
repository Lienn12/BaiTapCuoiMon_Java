/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
public class Admin_model {
    private String username;
    private String password;

    public Admin_model() {
    }

    public Admin_model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin_model(ResultSet rs) throws SQLException{
        this.username=rs.getString("username");
        this.password=rs.getString("password");
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
