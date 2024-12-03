
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
    
    public List<Favorites> getFavorite(int userId) throws SQLException{
        List<Favorites> dsFavorite= new ArrayList<Favorites>();
        String sql="SELECT FAVORITE_ID, USER_ID, TITLE,RELEASE_YEAR FROM FAVORITEs, MOVIES WHERE MOVIES.MOVIE_ID= FAVORITEs.MOVIE_ID AND USER_ID=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        rs= pstmt.executeQuery();
        while(rs.next()){
            Favorites favorite = new Favorites(rs);
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
    public int getUserId(int favoriteID) throws SQLException{
       String sql="SELECT USER_ID FROM FAVORITES WHERE FAVORITE_ID = ?";
       pstmt=conn.prepareStatement(sql);
       pstmt.setInt(1, favoriteID);
       rs=pstmt.executeQuery();
       if(rs.next()){
           int userId = rs.getInt("USER_ID");
           return userId;
        } else {
            throw new SQLException("Không tìm thấy USER_ID cho FAVORITE_ID = " + favoriteID);
        }
    }
    public boolean insertFavorite (int movieId, int userId) throws SQLException{
        String sql="INSERT INTO FAVORITES (MOVIE_ID, USER_ID) VALUES (?,?)";
        pstmt= conn.prepareStatement(sql);
        pstmt.setInt(1, movieId);
        pstmt.setInt(2, userId);        
        int row= pstmt.executeUpdate();
        pstmt.close();
        return row>0;
    }
    public boolean checkMovie(int movieId, int userId) throws SQLException{
        String sql="SELECT FAVORITE_ID FROM FAVORITES WHERE USER_ID= ? AND MOVIE_ID= ?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setInt(2, movieId);
        rs= pstmt.executeQuery();
        if(rs.next())
            return true;
        rs.close();
        pstmt.close();
        return false;
    }
    public boolean DeleteFavourite(int favouriteID) throws SQLException{
        String sql="DELETE FROM FAVORITES WHERE Favourite_ID=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,favouriteID);
        int row=pstmt.executeUpdate();
        pstmt.close();
        return row>0;
    }
}
