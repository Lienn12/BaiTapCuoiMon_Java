package Controllers;




import Model.Movie_model;
import Model.Review_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Review_controller {
    Connection conn=null;
    PreparedStatement prst=null;
    ResultSet rs=null;
    private Review_model reviewModel;
    public Review_controller(){
        conn=new dbConnect().getConnect();
    }
    
    public void updateMovieRatings() {
        String sql = """
            UPDATE MOVIES
            SET RATING = (
                SELECT AVG(CAST(RATING AS FLOAT))
                FROM REVIEWS
                WHERE REVIEWS.MOVIE_ID = MOVIES.MOVIE_ID
            );
        """;
        try (PreparedStatement prst = conn.prepareStatement(sql)) {
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review_model> getReview() throws SQLException {
        List<Review_model> dsReview= new ArrayList<Review_model>();
        String sql="SELECT REVIEW_ID,USERNAME,TITLE,REVIEWS.RATING,REVIEW_DATE FROM REVIEWS,USERS,MOVIES WHERE REVIEWS.MOVIE_ID=MOVIES.MOVIE_ID AND REVIEWS.USER_ID=USERS.USER_ID";        
        prst= conn.prepareStatement(sql);
        rs=prst.executeQuery();
        while(rs.next()){
            Review_model reviewModel= new Review_model(rs);
            dsReview.add(reviewModel);
        }
        prst.close();
        rs.close();
        return dsReview;
    }
    public List<Review_model> getReviewMovie(int movieID) throws SQLException {
        List<Review_model> dsReview= new ArrayList<Review_model>();
        String sql="SELECT REVIEW_ID,USERNAME,TITLE,REVIEW_DATE FROM REVIEWS,USERS,MOVIES WHERE REVIEWS.MOVIE_ID=MOVIES.MOVIE_ID AND REVIEWS.USER_ID=USERS.USER_ID AND MOVIE_ID=?";        
        prst= conn.prepareStatement(sql);
        prst.setInt(1, movieID);
        rs=prst.executeQuery();
        while(rs.next()){
            Review_model reviewModel= new Review_model(rs);
            dsReview.add(reviewModel);
        }
        prst.close();
        rs.close();
        return dsReview;
    }
    
    
    public Review_model getReview(int reviewID) throws SQLException{
        String sql="SELECT * FROM REVIEWS WHERE REVIEW_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setInt(1, reviewID);
        rs=prst.executeQuery();
        if(rs.next()){
            Review_model reviewModel = new Review_model(rs);
        }
        prst.close();
        rs.close();
        return reviewModel;
    }
    
    public boolean InsertReview(int movieID, int userID, int rating, String comment, Timestamp time) throws SQLException{
        String sql="INSERT INTO REVIEWS(movie_ID,user_ID,rating,comment,review_date) VALUES (?,?,?,?,?)";
        prst= conn.prepareStatement(sql);
        prst.setInt(1, movieID);
        prst.setInt(2, userID);
        prst.setFloat(3, rating);
        prst.setString(4, comment);
        prst.setTimestamp(5, time);
        int row= prst.executeUpdate();
        prst.close();
        updateMovieRatings();
        return row>0;
    }
    
    public boolean EditData(Review_model reviewModel) throws SQLException{
        String sql="UPDATE REVIEWS SET RATING=?, COMMENT=?, REVIEW_DATE=? WHERE REVIEW_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setFloat(1, reviewModel.getRating());
        prst.setString(2, reviewModel.getComment());
        prst.setTimestamp(3, new Timestamp(reviewModel.getReviewDate().getTime()));
        int row=prst.executeUpdate();
        prst.close();
        updateMovieRatings();
        return row>0;
    }
    
    public boolean DeleteReview(int reviewId) throws SQLException{
        String sql="DELETE FROM REVIEWS WHERE REVIEW_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setInt(1,reviewId);
        int row=prst.executeUpdate();
        prst.close();
        updateMovieRatings();
        return row>0;
    }
    
    public Review_model getReply(int reviewId) throws SQLException{
        String sql= "SELECT Review_ID,USERNAME, REVIEW_DATE,REVIEWS.RATING,COMMENT,COVER_IMAGE,TITLE,RELEASE_YEAR,REPLY \n" +
                            "FROM USERS, REVIEWS,MOVIES \n" +
                            "WHERE  REVIEWS.MOVIE_ID=MOVIES.MOVIE_ID AND REVIEWS.USER_ID=USERS.USER_ID AND REVIEW_ID=?";
        prst= conn.prepareStatement(sql);
        prst.setInt(1, reviewId);
        rs= prst.executeQuery();
        if(rs.next()){
            String username= rs.getString("Username");
            Timestamp reviewDate= rs.getTimestamp("Review_Date");
            int rating = rs.getInt("Rating");
            String comment =rs.getString("Comment");
            byte[] img=rs.getBytes("cover_image");
            String title= rs.getString("Title");
            int releaseYear= rs.getInt("Release_Year");
            String reply= rs.getString("Reply");
            return new Review_model(reviewId, username,reviewDate,rating,comment,img,title,releaseYear,reply);
        }else{
            return null;
        }
    }
        
   
    
    public boolean setReply(int reviewId,String reply) throws SQLException{
        String sql="UPDATE REVIEWS SET REPLY= ? WHERE REVIEW_ID= ?";
        prst=conn.prepareStatement(sql);
        prst.setString (1, reply);
        prst.setInt(2, reviewId);
        int row= prst.executeUpdate();
        prst.close();
        return row>0;
    }
     public boolean setReview(int reviewId,String cmt) throws SQLException{
        String sql="UPDATE REVIEWS SET REPLY= ? WHERE REVIEW_ID= ?";
        prst=conn.prepareStatement(sql);
        prst.setString (1, cmt);
        prst.setInt(2, reviewId);
        int row= prst.executeUpdate();
        prst.close();
        return row>0;
    }
    public boolean deleteReply(int reviewId) throws SQLException{
        String sql="UPDATE reviews SET reply = '' WHERE review_ID = ? ";
        prst=conn.prepareStatement(sql);
        prst.setInt(1, reviewId);
        int row= prst.executeUpdate();
        prst.close();
        return row>0;
    }
    
    public List<Review_model> getReviewUser(int movieId) throws SQLException{
        List<Review_model> dsReviewUser=  new ArrayList<Review_model>();
        String sql="""
                   SELECT USERNAME ,MOVIES.MOVIE_ID,REVIEWS.RATING,COMMENT 
                   FROM MOVIES,USERS, REVIEWS 
                   WHERE MOVIES.MOVIE_ID= REVIEWS.MOVIE_ID 
                   	AND REVIEWS.USER_ID=USERS.USER_ID
                   	AND MOVIES.MOVIE_ID =?
                   """;
        prst= conn.prepareStatement(sql);
        prst.setInt(1, movieId);
        rs=prst.executeQuery();
        while(rs.next()){
            String username= rs.getString("username");
            int rating = rs.getInt("RATING");
            String comment= rs.getString("comment");
            Review_model reviewModel= new Review_model(username,rating,comment,movieId);
            dsReviewUser.add(reviewModel);
        }
        prst.close();
        rs.close();
        return dsReviewUser;
    }
}
