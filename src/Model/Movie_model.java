/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
import java.util.List;


public class Movie_model {
    private int movieID;
    private String title;
    private int releaseYear;
    private Genres genre;
    private Formats format;
    private Countries country;
    private String director;
    private String cast;
    private float rating;
    private String description;
    private int episodes;
    private byte[] coverImage; 
    private String vidpath;

    public Movie_model() {
    }

    public Movie_model(String vidpath) {
        this.vidpath = vidpath;
    }
    public Movie_model(int movieID){
        this.movieID =movieID;
    }
    public Movie_model(int movieID,String title, float rating, byte[] coverImage) {
         this.movieID=movieID;
        this.title = title;
        this.rating = rating;
        this.coverImage = coverImage;
    }

    public Movie_model(int movieID,String title, float rating, String description, byte[] coverImage) {
        this.movieID=movieID;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.coverImage = coverImage;
    }
   
    public Movie_model(String title, int releaseYear, Genres genre, Formats format, Countries country, String director, String cast, float rating, String description, int episodes, byte[] coverImage, String vidpath) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.format = format;
        this.country = country;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
        this.description = description;
        this.episodes = episodes;
        this.coverImage = coverImage;
        this.vidpath = vidpath;
    }
    
    public Movie_model(int movieID, String title, int releaseYear, Genres genre, Formats format, Countries country, String director, String cast, float rating, String description, int episodes, byte[] coverImage,String vidpath) {
        this.movieID = movieID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.format = format;
        this.country = country;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
        this.description = description;
        this.episodes = episodes;
        this.coverImage = coverImage;
        this.vidpath = vidpath;
    }
    

    public Movie_model(ResultSet rs) throws SQLException {
        this.movieID = rs.getInt("movie_id");
        this.title = rs.getString("title");
        this.releaseYear = rs.getInt("release_year");
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

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }
    
    public Formats getFormat (){
        return format;
    }
    public void setFormat(Formats format){
        this.format=format;
    }
    
    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
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

    public String getVidpath() {
        return vidpath;
    }

    public void setVidpath(String vidpath) {
        this.vidpath = vidpath;
    }
    @Override
        public String toString() {
            return "Movie: " + title + " - " + description;
        }
}
