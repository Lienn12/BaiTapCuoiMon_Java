
package Controllers;

import Model.Favorites;
import Model.Formats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Favorite_controllor {
     Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private Favorites favorite;
    public Favorite_controllor(){
        conn=new dbConnect().getConnect();
    }
    
    public List<Favorites> getFavorite(Favorites favorite) throws SQLException{
        List<Favorites> dsFavorite= new ArrayList<Favorites>();
        String sql="SELECT FAVORITE_ID, USER_ID, TITLE,RELEASE_YEAR FROM FAVORITEs, MOVIES WHERE MOVIES.MOVIE_ID= FAVORITEs.MOVIE_ID";
        pstmt=conn.prepareStatement(sql);
        rs= pstmt.executeQuery();
        while(rs.next()){
            favorite = new Favorites(rs);
            dsFavorite.add(favorite);
        }
        pstmt.close();
        rs.close();
        return dsFavorite;
    }
    public int getMovieId(int favoriteID) throws SQLException{
       String sql="SELECT MOVIE_ID FROM FAVORITES WHERE FAVORITE_ID = ?";
       pstmt=conn.prepareStatement(sql);
       pstmt.setInt(1, favoriteID);
       rs=pstmt.executeQuery();
       if(rs.next()){
           int movieId = rs.getInt("MOVIE_ID");
           return movieId;
        } else {
            throw new SQLException("Không tìm thấy MOVIE_ID cho FAVORITE_ID = " + favoriteID);
        }
    }
    public boolean insertFavorite (int movieId) throws SQLException{
        String sql="INSERT INTO FAVORITES (MOVIE_ID) VALUES (?)";
        pstmt= conn.prepareStatement(sql);
//        pstmt.setInt(1, userId);
        pstmt.setInt(1, movieId);
        int row= pstmt.executeUpdate();
        pstmt.close();
        return row>0;
    }
    public boolean checkMovie(int movieId) throws SQLException{
        String sql="SELECT FAVORITE_ID FROM FAVORITES WHERE MOVIE_ID= ?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, movieId);
        rs= pstmt.executeQuery();
        if(rs.next())
            return true;
        rs.close();
        pstmt.close();
        return false;
    }
}
