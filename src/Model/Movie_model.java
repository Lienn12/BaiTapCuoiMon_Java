/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;


public class Movie_model {
    private int movieID;
    private String title;
    private int releaseYear;
    private String genre;
    private String country;
    private String director;
    private String cast;
    private float rating;
    private String description;
    private int episodes;
    private byte[] coverImage; // Thêm thuộc tính để lưu trữ ảnh


    public Movie_model() {
    }

    public Movie_model(int movieID, String title, int releaseYear, String genre, String country, String director, String cast, float rating, String description, int episodes, byte[] coverImage) {
        this.movieID = movieID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.country = country;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
        this.description = description;
        this.episodes = episodes;
        this.coverImage = coverImage;
    }


    public Movie_model(ResultSet rs) throws SQLException {
        this.movieID = rs.getInt("movie_id");
        this.title = rs.getString("title");
        this.releaseYear = rs.getInt("release_year");
        this.genre = rs.getString("genre");
        this.country = rs.getString("country");
        this.director = rs.getString("director");
        this.cast = rs.getString("cast");
        this.rating = rs.getFloat("rating");
        this.description = rs.getString("description");
        this.episodes = rs.getInt("episodes");
        this.coverImage = rs.getBytes("cover_image"); // Lấy dữ liệu ảnh từ ResultSet
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public byte[] getImg() {
        return coverImage;
    }

    public void setImg(byte[] coverImage) {
        this.coverImage = coverImage;
    }

}
