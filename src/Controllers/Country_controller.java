/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Countries;
import Model.Movie_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lienn
 */
public class Country_controller {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private Countries country;
    public Country_controller(){
        conn=new dbConnect().getConnect();
    }
    public List<Countries> getCountry(Countries countryModel) throws SQLException{
        List<Countries> dsCountry=  new ArrayList<Countries>();
        String sql="SELECT * FROM Countries";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int countryId= rs.getInt("country_id");
            String countryName =rs.getString("Country_name");
            Countries country = new Countries(countryId,countryName);
            dsCountry.add(country);
        }
        pstmt.close();
        rs.close();
        return dsCountry;
    }
}
