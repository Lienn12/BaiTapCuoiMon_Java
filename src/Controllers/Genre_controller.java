/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Genres;
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
public class Genre_controller {
     Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private Genres genre;
    private Movie_model movieModel;
    public Genre_controller(){
        conn=new dbConnect().getConnect();
    }
    public List<Genres> getGenre(Genres genreModel) throws SQLException{
        List<Genres> dsGenre=  new ArrayList<Genres>();
        String sql="SELECT * FROM Genres";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int genreID = rs.getInt("genre_id");
            String genreName =rs.getString("genre_name");
            Genres genre = new Genres(genreID,genreName);
            dsGenre.add(genre);
        }
        pstmt.close();
        rs.close();
        return dsGenre;
    }
    
}
