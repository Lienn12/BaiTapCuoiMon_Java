/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;


public class Movie_model {
    private int id;
    private String name;
    private int year;
    private String director;
    private String cast;
    private String genre;
    private String description;
    private byte[] img; // Thêm thuộc tính để lưu trữ ảnh

    // Constructors
    public Movie_model() {
    }

    public Movie_model(int id, String name, int year, String director, String cast, String genre, String description, byte[] img) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.description = description;
        this.img = img;
    }

    // Constructor to initialize from ResultSet
    public Movie_model(ResultSet rs) throws SQLException {
        this.id = rs.getInt("movie_id");
        this.name = rs.getString("title");
        this.year = rs.getInt("release_year");
        this.director = rs.getString("director");
        this.cast = rs.getString("cast");
        this.genre = rs.getString("genre");
        this.description = rs.getString("description");
        this.img = rs.getBytes("cover_image"); // Lấy dữ liệu ảnh từ ResultSet
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
