/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Game;
import util.DBConnection;

/**
 *
 * @author xalvarezxpr
 */
public class GameDAO {
    
    public boolean addGame(Game game) {
        String sql = "INSERT INTO games (title, platform, genre, status, rating, notes) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, game.getTitle());
                ps.setString(2, game.getPlatform());
                ps.setString(3, game.getGenre());
                ps.setString(4, game.getStatus());
                ps.setDouble(5, game.getRating());
                ps.setString(6, game.getNotes());
                
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Game> getAllGames() {
        ArrayList<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setTitle(rs.getString("title"));
                game.setPlatform(rs.getString("platform"));
                game.setGenre(rs.getString("genre"));
                game.setStatus(rs.getString("status"));
                game.setRating(rs.getDouble("rating"));
                game.setNotes(rs.getString("notes"));

                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return games;
    }       
}      
