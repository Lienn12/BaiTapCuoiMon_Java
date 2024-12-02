
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
    public boolean insertFavorite (Favorites favorite) throws SQLException{
        String sql="INSERT INTO FAVORITE (USER_ID, MOVIE_ID) VALUES (?, ?)";
        pstmt= conn.prepareStatement(sql);
        pstmt.setInt(1, favorite.getUser().getUserID());
        pstmt.setInt(2,favorite.getMovie().getMovieID());
        int row= pstmt.executeUpdate();
        pstmt.close();
        return row>0;
    }
}
