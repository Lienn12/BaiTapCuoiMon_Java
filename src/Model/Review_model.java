
package Model;
import java.sql.*;
import java.util.Date;

public class Review_model {
    private int reviewID;
    private Movie_model movieModel;
    private User_model userModel;
    private float rating;
    private String comment;
    private Date reviewDate;

    public Review_model() {
    }

    public Review_model(int reviewID, Movie_model movieModel, User_model userModel, float rating, String comment, Date reviewDate) {
        this.reviewID = reviewID;
        this.movieModel = movieModel;
        this.userModel = userModel;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }
    public Review_model(ResultSet rs) throws SQLException {
        this.reviewID = rs.getInt("review_ID");
//        this.movieModel = new Movie_model(rs);
//        this.userModel = new User_model(rs);
//        this.rating = rs.getFloat("rating");
//        this.comment = rs.getString("comment");
//        this.reviewDate = rs.getDate("review_Date");
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
    
}
