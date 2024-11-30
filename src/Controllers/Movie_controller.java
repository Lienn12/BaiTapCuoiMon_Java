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
    public void saveInfo(String name,int year,String director,String cast,int genreID,int formatID,int countryID,int episode,String descrip ,File imageFile, String vidpath) {
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
            pstmt.executeUpdate();
            System.out.println("Saved to SQL successfully!");
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

    public List<Movie_model> searchMovies(String genre, String country, String format, String sort) throws SQLException {
        StringBuilder  sql=new StringBuilder("""
                   SELECT MOVIE_ID, TITLE, RELEASE_YEAR,RATING, GENRE_NAME, COUNTRY_NAME, FORMAT_NAME
                   FROM MOVIES, COUNTRIES, GENRES,FORMATS
                   WHERE MOVIES.COUNTRY_ID = COUNTRIES.COUNTRY_ID
                     AND MOVIES.GENRE_ID = GENRES.GENRE_ID
                     AND MOVIES.FORMAT_ID = FORMATS.FORMAT_ID AND 1=1
                   """);
        if(!genre.equals("Tất cả")){
            sql.append(" AND GENRE_NAME =?");
        }           
        if(!country.equals("Tất cả")){
            sql.append(" AND COUNTRY_NAME =?");
        }
        if(!format.equals("Tất cả")){
            sql.append(" AND FORMAT_NAME=?");
        }
        if(sort.equals("Tên phim (A-Z)")){
            sql.append(" ORDER BY title ASC");
        }else if(sort.equals("Năm phát hành(mới nhất)")){
            sql.append(" ORDER BY RELEASE_YEAR DESC");
        }else if(sort.equals("ĐÁNH GIÁ")){
            sql.append(" ORDER BY RATING DESC");
        }
        PreparedStatement prst = conn.prepareStatement(sql.toString());
        int index =1;
             if (!genre.equals("Tất cả")) {
                prst.setString(index++, genre);
            }
            if (!country.equals("Tất cả")) {
                prst.setString(index++, country);
            }
            if (!format.equals("Tất cả")) {
                prst.setString(index++, format);
            }
        ResultSet rs = prst.executeQuery();
        while(rs.next()){
                String movieTitle= rs.getString("title");
                int  moviYear=rs.getInt("release_year");
                String movieGenre=rs.getString("genre_name");
                String movieFormat=rs.getString("format_name");
                String movieCountry=rs.getString("country_name"); 
                float rating=rs.getFloat("rating");
        }
        return null;
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
        String sql="SELECT TITLE,RATING, COVER_IMAGE, DESCRIPTION FROM MOVIES";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getphimbo() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT TITLE,RATING, COVER_IMAGE, DESCRIPTION FROM MOVIES WHERE GENRE_ID= 1";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getphimle() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT TITLE,RATING, COVER_IMAGE, DESCRIPTION FROM MOVIES WHERE GENRE_ID= 2";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            String title= rs.getString("TITLE");
            float rating =rs.getFloat("Rating");
            byte[] img= rs.getBytes("COVER_IMAGE");
            String des= rs.getString("DESCRIPTION");
            Movie_model movie= new Movie_model(title,rating,des,img);
            dsMovie.add(movie);
        }
        pstmt.close();
        rs.close();
        return dsMovie;
    }
    public List<Movie_model> getReview() throws SQLException{
        List<Movie_model> dsMovie=  new ArrayList<Movie_model>();
        String sql="SELECT TOP 5 TITLE,RATING,COVER_IMAGE FROM MOVIES ORDER BY RATING DESC";
        pstmt= conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            String title= rs.getString("TITLE");
            float rating = rs.getFloat("RATING");
            byte[] img= rs.getBytes("COVER_IMAGE");
            Movie_model movie= new Movie_model(title,rating,img);
            dsMovie.add(movie);
        }
        System.out.println("getReview(): dsMovie: "+ dsMovie);
        pstmt.close();
        rs.close();
        return dsMovie;
    }
}
