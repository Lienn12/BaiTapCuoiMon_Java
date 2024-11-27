package Controllers;




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
    
    public List<Review_model> getReview() throws SQLException {
        List<Review_model> dsReview= new ArrayList<Review_model>();
        String sql="SELECT REVIEW_ID,USERNAME,TITLE,REVIEW_DATE FROM REVIEWS,USERS,MOVIES WHERE REVIEWS.MOVIE_ID=MOVIES.MOVIE_ID AND REVIEWS.USER_ID=USERS.USER_ID";        
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
    
    public boolean InsertReview(Review_model reviewModel) throws SQLException{
        String sql="INSERT INTO REVIEWS VALUES (?,?,?,?,?,?)";
        prst= conn.prepareStatement(sql);
        prst.setInt(1, reviewModel.getReviewID());
        prst.setInt(2, reviewModel.getMovieModel().getMovieID());
        prst.setInt(3, reviewModel.getUserModel().getUserID());
        prst.setFloat(4, reviewModel.getRating());
        prst.setString(5, reviewModel.getComment());
        prst.setTimestamp(6, new Timestamp(reviewModel.getReviewDate().getTime()));
        int row= prst.executeUpdate();
        prst.close();
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
        return row>0;
    }
    
    public boolean DeleteReview(int reviewId) throws SQLException{
        String sql="DELETE FROM REVIEWS WHERE REVIEW_ID=?";
        prst=conn.prepareStatement(sql);
        prst.setInt(1,reviewId);
        int row=prst.executeUpdate();
        prst.close();
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
        
    public List<String> getRepliesFromDatabase(int reviewId) throws SQLException{
        List<String> replies = new ArrayList<>();
        String sql = "SELECT value AS IndividualReply FROM  STRING_SPLIT((SELECT REPLY FROM REVIEWS WHERE REVIEW_ID = ?), ';')";
        prst= conn.prepareStatement(sql);
        prst.setInt(1, reviewId);
        rs=prst.executeQuery();
        while (rs.next()) {
            String reply = rs.getString("IndividualReply");
            if (reply != null && !reply.isEmpty()) {
                replies.add(reply);
                    }
            }
        return replies;
    }
    
    public boolean setReply(int reviewId,String reply) throws SQLException{
        String sql="UPDATE REVIEWS SET REPLY=CONCAT(REPLY, '; ', ?), STATUS='responded' WHERE REVIEW_ID= ?";
        prst=conn.prepareStatement(sql);
        prst.setString (1, reply);
        prst.setInt(2, reviewId);
        int row= prst.executeUpdate();
        prst.close();
        return row>0;
    }
    
    public boolean deleteReply(int reviewId,String reply ) throws SQLException{
        String sql="UPDATE reviews SET reply = REPLACE(reply, ?, '') WHERE review_ID = ? ";
        prst=conn.prepareStatement(sql);
        prst.setString(1, reply);
        prst.setInt(2, reviewId);
        int row= prst.executeUpdate();
        prst.close();
        return row>0;
    }
}
