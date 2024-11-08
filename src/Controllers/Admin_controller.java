package Controllers;

import Model.Admin_model;
import Model.User_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_controller {
    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;
    private Admin_model adminModel;
    public Admin_controller(){
        conn=new dbConnect().getConnect();
    }
    public boolean CheckLoginAdmin(Admin_model adminModel, String password) throws SQLException{
       //khởi tạo truy vấn r_model userModel
       String check_login_query="SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?";
       //khởi tạp preparedStatement để thực hiện truy vấn
       prst=conn.prepareStatement(check_login_query);
       prst.setString(1, adminModel.getUsername());
       prst.setString(2, password);
       //chọn phương thực thi phù hợp với truy vấn
       rs=prst.executeQuery();
       boolean exist=rs.next();
       rs.close();
       prst.close();
       return exist;
    }
    
    public boolean CheckSignupAdmin(Admin_model adminModel, String password) throws SQLException{
        String insert_sql="INSERT INTO ADMIN(USERNAME, PASSWORD) VALUES (?, ?)";
        prst=conn.prepareStatement(insert_sql,Statement.RETURN_GENERATED_KEYS);
        prst.setString(1, adminModel.getUsername());
        prst.setString(2, password);
        prst.executeUpdate();
        rs=prst.getGeneratedKeys();
        if(rs.next()){
            return true;
        }
        rs.close();
        prst.close(); 
        return false;
    }
}
