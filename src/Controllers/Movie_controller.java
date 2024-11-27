package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import Controllers.dbConnect;
import Model.Movie_model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lienn
 */
public class Movie_controller {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private Movie_model movieModel;
    public Movie_controller(){
        conn=new dbConnect().getConnect();
    }
    
    public List<Movie_model> getMovie(Movie_model movieModel) throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT MOVIE_ID, TITLE, RELEASE_YEAR FROM MOVIES";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            Movie_model movie= new Movie_model(rs);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public void saveInfo(String name,int year,String director,String cast,String genre,String country,int episode,String descrip ,File imageFile) {
        try (FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = bos.toByteArray();
            String sql = "INSERT INTO MOVIES (TITLE,RELEASE_YEAR,DIRECTOR,CAST,GENRE,COUNTRY,EPISODE,DESCRIPTION,COVER_IMAGE) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, year);
            pstmt.setString(3, director);
            pstmt.setString(4, cast);
            pstmt.setString(5, genre);
            pstmt.setString(6, country);
            pstmt.setInt(7, episode);
            pstmt.setString(8, descrip);
            pstmt.setBytes(9, imageBytes);

            pstmt.executeUpdate();
            System.out.println("Lưu thông tin thành công vào cơ sở dữ liệu!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean DeleteFilm(int movie_id) throws SQLException {
        String deleteReviews = "DELETE FROM Reviews WHERE movie_id = ?";
        String deleteMovies = "DELETE FROM Movies WHERE movie_id = ?";

        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(deleteReviews);
            pstmt.setInt(1, movie_id);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(deleteMovies);
            pstmt.setInt(1, movie_id);
            int rows = pstmt.executeUpdate();

            conn.commit(); 
            return rows > 0;
        } catch (SQLException e) {
            conn.rollback(); 
            throw e;
        } finally {
            conn.setAutoCommit(true); 
            if (pstmt != null) pstmt.close();
        }
    }

    public List<Movie_model> searchMovies(String column, String query) {
            List<Movie_model> movies = new ArrayList<>();
            try {
                String sql = "SELECT * FROM movies WHERE " + column + " LIKE ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + query + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    int movieId = rs.getInt("movie_id");
                    String title = rs.getString("title");
                    int releaseYear = rs.getInt("release_year");
                    String director = rs.getString("director");
                    String description = rs.getString("description");

//                    movies.add(new Movie_model(movieId, title, releaseYear, director, description));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return movies;
        }
    
    public Movie_model getMovieById(int movieID) throws SQLException{
        String query = "SELECT * FROM MOVIES WHERE MOVIE_ID = ?";
        try {
            PreparedStatement prst = conn.prepareStatement(query);
            prst.setInt(1, movieID);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                    String name= rs.getString("title");
                    int  year=rs.getInt("release_year");
                    String genre=rs.getString("genre");
                    String country=rs.getString("country");
                    String director=rs.getString("director");
                    String cast= rs.getString("cast");
                    float rating=rs.getFloat("rating");
                    String des=rs.getString("description");
                    int episode=rs.getInt("episode");
                    byte[] img=rs.getBytes("cover_image");
                return new Movie_model(movieID,name,year,genre,country,director,cast,rating,des,episode,img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateMovie(Movie_model movie) throws SQLException{
        String query = "UPDATE MOVIES SET TITLE = ?, RELEASE_YEAR = ?,DIRECTOR=?,CAST=?, GENRE = ?,COUNTRY=?,EPISODE=?, DESCRIPTION = ?,COVER_IMAGE=? WHERE MOVIE_ID = ?";
            PreparedStatement prst = conn.prepareStatement(query);
            prst.setString(1, movie.getTitle());       // TITLE
            prst.setInt(2, movie.getReleaseYear());          // RELEASE_YEAR
            prst.setString(3, movie.getDirector());
            prst.setString(4, movie.getCast());
            prst.setString(5, movie.getGenre());      // GENRE
            prst.setString(6, movie.getCountry());
            prst.setInt(7, movie.getEpisodes());
            prst.setString(8, movie.getDescription()); // DESCRIPTION
            prst.setBytes(9, movie.getImg());         // IMAGE
            prst.setInt(10, movie.getMovieID()); 
            int rowsUpdated = prst.executeUpdate();
            System.out.println("controller id "+ movie.getDescription());
            return rowsUpdated>0;
            
    }
}
