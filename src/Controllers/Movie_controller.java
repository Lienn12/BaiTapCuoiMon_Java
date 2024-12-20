package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import Controllers.dbConnect;
import Model.Countries;
import Model.Formats;
import Model.Genres;
import Model.Movie_model;
import static java.lang.String.format;
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
    public boolean saveInfo(String name,int year,String director,String cast,int genreID,int formatID,int countryID,int episode,String descrip ,File imageFile, String vidpath) {
        int row = 0;
        try (FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = bos.toByteArray();
            String sql = "INSERT INTO MOVIES (TITLE,RELEASE_YEAR,DIRECTOR,CAST,GENRE_ID,FORMAT_ID,COUNTRY_ID,EPISODE,DESCRIPTION,COVER_IMAGE,TRAILER) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, year);
            pstmt.setString(3, director);
            pstmt.setString(4, cast);
            pstmt.setInt(5, genreID);
            pstmt.setInt(6, formatID);
            pstmt.setInt(7, countryID);
            pstmt.setInt(8, episode);
            pstmt.setString(9, descrip);
            pstmt.setBytes(10, imageBytes);
            pstmt.setString(11, vidpath);
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return row>0;
    }
    public boolean DeleteFilm(int movie_id) throws SQLException {
        String deleteFavorite="DELETE FROM FAVORITES WHERE movie_id=?";
        String deleteReviews = "DELETE FROM Reviews WHERE movie_id = ?";
        String deleteMovies = "DELETE FROM Movies WHERE movie_id = ?";

        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(deleteFavorite);
            pstmt.setInt(1, movie_id);
            pstmt.executeUpdate();
            
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

    public List<Movie_model> searchMovies(int genre, int country, int format, int sort) throws SQLException {
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        StringBuilder  sql=new StringBuilder("""
                   SELECT MOVIE_ID, TITLE, RELEASE_YEAR,RATING,COVER_IMAGE, DESCRIPTION
                   FROM MOVIES, COUNTRIES, GENRES,FORMATS
                   WHERE MOVIES.COUNTRY_ID = COUNTRIES.COUNTRY_ID
                    AND MOVIES.GENRE_ID = GENRES.GENRE_ID
                    AND MOVIES.FORMAT_ID = FORMATS.FORMAT_ID 
                    AND (GENRES.GENRE_ID = ? OR ? =  1)
                    AND (COUNTRIES.COUNTRY_ID = ? OR ? =  1)
                    AND (FORMATS.FORMAT_ID = ? OR ? = 1)
                   """);
        if(sort==1){
            sql.append(" ORDER BY title ASC");
        }else if(sort==2){
            sql.append(" ORDER BY RELEASE_YEAR DESC");
        }else if(sort==3){
            sql.append(" ORDER BY RATING DESC");
        }
        PreparedStatement prst = conn.prepareStatement(sql.toString());
        prst.setInt(1, genre);
        prst.setInt(2, genre);
        prst.setInt(3, country);
        prst.setInt(4, country);
        prst.setInt(5, format);
        prst.setInt(6, format);
        ResultSet rs = prst.executeQuery();
        while(rs.next()){
              int movieId= rs.getInt("MOVIE_ID");
                String title= rs.getString("TITLE");
                float rating =rs.getFloat("Rating");
                byte[] img= rs.getBytes("COVER_IMAGE");
                String des= rs.getString("DESCRIPTION");
                Movie_model movie= new Movie_model(movieId,title,rating,des,img);
                dsMovie.add(movie);
        }
        prst.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getMoviesByGenreID(int genreId) throws SQLException {
        String sql = """
                    SELECT MOVIE_ID,TITLE, RATING, COVER_IMAGE, DESCRIPTION
                    FROM MOVIES, GENRES
                    WHERE MOVIES.GENRE_ID = GENRES.GENRE_ID
                    AND GENRES.GENRE_ID = ?
                    """;
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, genreId);
        rs = pstmt.executeQuery();
        
        List<Movie_model> movieList = new ArrayList<>();
        
        while (rs.next()) {
            int movieId= rs.getInt("MOVIE_ID");
            String title = rs.getString("TITLE");
            float rating = rs.getFloat("RATING");
            byte[] img = rs.getBytes("COVER_IMAGE");
            String description = rs.getString("DESCRIPTION");
            
            Movie_model movie = new Movie_model(movieId,title, rating, description, img);
            movieList.add(movie);
        }       
        return movieList;
    }
    public List<Movie_model> getMoviesByCountryID(int coutryId) throws SQLException {
        String sql = """
                    SELECT MOVIE_ID,TITLE, RATING, COVER_IMAGE, DESCRIPTION
                    FROM MOVIES, COUNTRIES
                    WHERE MOVIES.COUNTRY_ID = COUNTRIES.COUNTRY_ID
                    AND COUNTRIES.COUNTRY_ID = ?
                    """;
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, coutryId);
        rs = pstmt.executeQuery();
        
        List<Movie_model> movieList = new ArrayList<>();
        
        while (rs.next()) {
            int movieId= rs.getInt("MOVIE_ID");
            String title = rs.getString("TITLE");
            float rating = rs.getFloat("RATING");
            byte[] img = rs.getBytes("COVER_IMAGE");
            String description = rs.getString("DESCRIPTION");
            
            Movie_model movie = new Movie_model(movieId,title, rating, description, img);
            movieList.add(movie);
        }       
        return movieList;
    }
    public Movie_model getMovieById(int movieID) throws SQLException{
        String query = """
                       SELECT MOVIE_ID, TITLE, RELEASE_YEAR, GENRE_NAME, COUNTRY_NAME, FORMAT_NAME, DIRECTOR, CAST, RATING, DESCRIPTION, EPISODE, COVER_IMAGE, TRAILER 
                       FROM MOVIES, COUNTRIES, GENRES,FORMATS
                       WHERE MOVIES.COUNTRY_ID = COUNTRIES.COUNTRY_ID
                         AND MOVIES.GENRE_ID = GENRES.GENRE_ID
                         AND MOVIES.FORMAT_ID = FORMATS.FORMAT_ID
                         AND MOVIE_ID = ?;
                       """;
        try {
            PreparedStatement prst = conn.prepareStatement(query);
            prst.setInt(1, movieID);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                String name= rs.getString("title");
                int  year=rs.getInt("release_year");
                String genre=rs.getString("genre_name");
                String format=rs.getString("format_name");
                String country=rs.getString("country_name");
                String director=rs.getString("director");
                String cast= rs.getString("cast");
                float rating=rs.getFloat("rating");
                String des=rs.getString("description");
                int episode=rs.getInt("episode");
                byte[] img=rs.getBytes("cover_image");
                String vidpath=rs.getString("trailer");
                return new Movie_model(movieID,name,year,new Genres(0,genre),new Formats(0,format),new Countries(0,country),director,cast,rating,des,episode,img,vidpath);
             } else {
            System.out.println("Movie not found for movieID: " + movieID);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("getMovieById: Movie_model null");
        return null;
    }
    public boolean updateMovie(Movie_model movie) throws SQLException {
        String query = "UPDATE MOVIES SET TITLE = ?, RELEASE_YEAR = ?, DIRECTOR = ?, CAST = ?, GENRE_ID = ?, FORMAT_ID = ?, COUNTRY_ID = ?, EPISODE = ?, DESCRIPTION = ?, COVER_IMAGE = ? WHERE MOVIE_ID = ?";
        try (PreparedStatement prst = conn.prepareStatement(query)) {
            prst.setString(1, movie.getTitle());
            prst.setInt(2, movie.getReleaseYear());
            prst.setString(3, movie.getDirector());
            prst.setString(4, movie.getCast());
            prst.setInt(5, movie.getGenre().getGenreId());
            prst.setInt(6, movie.getFormat().getFormatId());
            prst.setInt(7, movie.getCountry().getCountryId());
            prst.setInt(8, movie.getEpisodes());
            prst.setString(9, movie.getDescription());
            prst.setBytes(10, movie.getImg());
            prst.setInt(11, movie.getMovieID());
            int rowsUpdated = prst.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    
    public List<Movie_model> getImage() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT MOVIE_ID,TITLE,RATING, COVER_IMAGE, DESCRIPTION FROM MOVIES";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int movieId= rs.getInt("MOVIE_ID");
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(movieId,title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getphimbo() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="""
                   SELECT MOVIE_ID,TITLE,RATING, COVER_IMAGE, DESCRIPTION 
                   FROM MOVIES, FORMATS
                   WHERE MOVIES.FORMAT_ID=  FORMATS.FORMAT_ID AND FORMAT_NAME = N'Phim bộ'
                   """;
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int movieId= rs.getInt("MOVIE_ID");
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(movieId,title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getphimle() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="""
                   SELECT MOVIE_ID,TITLE,RATING, COVER_IMAGE, DESCRIPTION 
                   FROM MOVIES, FORMATS
                   WHERE MOVIES.FORMAT_ID=  FORMATS.FORMAT_ID AND FORMAT_NAME = N'Phim lẻ'
                   """;
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int movieId= rs.getInt("MOVIE_ID");
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(movieId,title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getReview() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT TOP 5 MOVIE_ID,TITLE,RATING,COVER_IMAGE FROM MOVIES ORDER BY RATING DESC";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            int movieId= rs.getInt("MOVIE_ID");
            String title= rs.getString("TITLE");
            float rating = rs.getFloat("RATING");
            byte[] img= rs.getBytes("COVER_IMAGE");
            Movie_model movie= new Movie_model(movieId,title,rating,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
   
}
