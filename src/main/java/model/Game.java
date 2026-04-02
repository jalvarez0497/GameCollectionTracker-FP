/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xalvarezxpr
 */
public class Game {
    // id, title, platform, genre, status, rating, notes
    //private int id;
    private int id;
    private String title;
    private String platform;
    private String genre;
    private String status;
    private double rating;
    private String notes;
    
    // No parameter default Constructor
    public Game() {
        
    }
    // Constructor with Parameters
    public Game(int id, String title, String platform, String genre, 
            String status, double rating, String notes) {
        
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.genre = genre;
        this.status = status;
        this.rating = rating;
        this.notes = notes;
    }
    // Getters methods
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getPlatform() {
        return platform;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getStatus() {
        return status;
    }
    
    public double getRating() {
        return rating;
    }
    
    public String getNotes() {
        return notes;
    }
    
    // Setters methods
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Game{" + "title=" + title + ", platform=" + platform + ", genre=" + genre + ", status=" + status + ", rating=" + rating + ", notes=" + notes + '}';
    }
    
}
