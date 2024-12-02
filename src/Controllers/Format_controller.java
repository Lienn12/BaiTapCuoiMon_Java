/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Formats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Format_controller {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private Formats format;
    public Format_controller(){
        conn=new dbConnect().getConnect();
    }
    public List<Formats> getFormat(Formats formatModel) throws SQLException{
        List<Formats> dsFormat=  new ArrayList<Formats>();
        String sql="SELECT * FROM Formats";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int formatId= rs.getInt("format_id");
            String formatName =rs.getString("format_Name");
            Formats format = new Formats(formatId,formatName);
            dsFormat.add(format);
        }
        pstmt.close();
        rs.close();
        return dsFormat;
    }
}
