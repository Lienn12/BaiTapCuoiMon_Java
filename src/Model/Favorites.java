
package Model;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class Favorites {
    private int favotiteId;
    private User_model user;
    private Movie_model movie;

    public Favorites(int favotiteId, User_model user, Movie_model movie) {
        this.favotiteId = favotiteId;
        this.user = user;
        this.movie = movie;
    }
    public Favorites(ResultSet rs) throws SQLException{
        this.favotiteId= rs.getInt("favorite_Id");
        int userId= rs.getInt("User_ID");
        this.user = new User_model(); 
        this.user.setUserID(userId);
        String title= rs.getString("Title");
        int year= rs.getInt("Release_year");
        this.movie = new Movie_model();
        this.movie.setTitle(title);
        this.movie.setReleaseYear(year);
    }
    public Favorites() {
    }

    public int getFavotiteId() {
        return favotiteId;
    }

    public void setFavotite(int favotiteId) {
        this.favotiteId = favotiteId;
    }

    public User_model getUser() {
        return user;
    }

    public void setUser(User_model user) {
        this.user = user;
    }

    public Movie_model getMovie() {
        return movie;
    }

    public void setMovie(Movie_model movie) {
        this.movie = movie;
    }
    
}
