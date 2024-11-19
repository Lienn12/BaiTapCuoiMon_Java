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
    public void saveInfo(String name,int year,String director,String cast,String genre,String country,int episodes,String descrip ,File imageFile) {
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
            pstmt.setInt(7, episodes);
            pstmt.setString(8, descrip);
            pstmt.setBytes(9, imageBytes);

            pstmt.executeUpdate();
            System.out.println("Lưu thông tin thành công vào cơ sở dữ liệu!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean DeleteFilm(int movie_id) throws SQLException{
        String sql="Delete from Movies where movie_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, movie_id);
        int row= pstmt.executeUpdate();
        return row>0;
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
                return new Movie_model(
                    rs.getString("title"),
                    rs.getInt("release_year"),
                    rs.getString("genre"),
                    rs.getString("country"),
                    rs.getString("director"),
                    rs.getString("cast"),
                    rs.getFloat("rating"),
                    rs.getString("description"),
                    rs.getInt("episode"),
                    rs.getBytes("cover_image")
                    
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Movie_model updateMovie(Movie_model movie) throws SQLException{
        String query = "UPDATE MOVIES SET TITLE = ?, RELEASE_YEAR = ?, GENRE = ?, DESCRIPTION = ?,COVER_IMAGE=? WHERE MOVIE_ID = ?";
        try {
            PreparedStatement prst = conn.prepareStatement(query);
            prst.setString(1, movie.getTitle());       // TITLE
            prst.setInt(2, movie.getReleaseYear());          // RELEASE_YEAR
            prst.setString(3, movie.getGenre());      // GENRE
            prst.setString(4, movie.getDescription()); // DESCRIPTION
            prst.setBytes(5, movie.getImg());         // IMAGE
            prst.setInt(6, movie.getMovieID()); 
            System.out.println("Movie ID: " + movie.getMovieID());
            int rowsUpdated = prst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Movie updated successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
