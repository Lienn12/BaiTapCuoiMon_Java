
package Model;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class Review_model {
    private int reviewID;
    private Movie_model movieModel;
    private User_model userModel;
    private int rating;
    private String comment;
    private Timestamp  reviewDate;
    private String reply;

    public Review_model() {
    }
    public Review_model(int rating, String comment, int movieId,int userID) {
        this.userModel = new User_model(userID);
        this.movieModel = new Movie_model(movieId); 
        this.comment = comment;
        this.rating = rating;
    }
    public Review_model(int reviewID, Movie_model movieModel, User_model userModel, int rating, String comment, Timestamp reviewDate) {
        this.reviewID = reviewID;
        this.movieModel = movieModel;
        this.userModel = userModel;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }
    
    public Review_model(int reviewID,String username,Timestamp reviewDate,int rating,String comment,byte[] img,String title, int releaseYear,String reply){
        this.userModel = new User_model(); 
        this.userModel.setUsername(username);
        
        this.movieModel = new Movie_model();
        this.movieModel.setTitle(title); 
        this.movieModel.setReleaseYear(releaseYear); 
        this.movieModel.setImg(img);
        
        this.reviewID=reviewID;
        this.reviewDate = reviewDate;
        this.comment = comment;
        this.rating= rating;
        this.reply= reply;
    }
    public Review_model(String username, int rating, String comment, int movieId) {
        this.userModel = new User_model(username);
        this.movieModel = new Movie_model(movieId); 
        this.comment = comment;
        this.rating = rating;
    }

    public Review_model(ResultSet rs) throws SQLException {
        this.reviewID = rs.getInt("review_ID");
        String title = rs.getString("TITLE");
        this.movieModel = new Movie_model();
        this.movieModel.setTitle(title);
        String username = rs.getString("USERNAME");
        this.userModel = new User_model();
        this.userModel.setUsername(username);
        this.reviewDate = rs.getTimestamp("review_Date");
        this.rating= rs.getInt("Rating");
    }
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public Movie_model getMovieModel() {
        return movieModel;
    }

    public void setMovieModel(Movie_model movieModel) {
        this.movieModel = movieModel;
    }

    public User_model getUserModel() {
        return userModel;
    }

    public void setUserModel(User_model userModel) {
        this.userModel = userModel;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
      @Override
    public String toString() {
        return "Review_model{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }

}
