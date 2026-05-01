
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;          
import java.sql.SQLException;
import java.util.ArrayList;

import model.Game;
import util.DBConnection;

/**
 * GameDAO class handles all the database CRUD operations related to the game objects.
 */
public class GameDAO {
    
    // This method add a new game to the database
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
    
    // This method retrieves all the games storen in the database.
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
    
    // This method delets a game from the database using the game ID.
    public boolean deleteGame(int id) {
        String sql = "DELETE FROM games WHERE id = ?";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    // Retrieves a single game by their ID.
    public Game getGameById(int id) {
        String sql = "SELECT * FROM games WHERE id = ?";
        Game game = null;
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    game = new Game();
                    game.setId(rs.getInt("id"));
                    game.setTitle(rs.getString("title"));
                    game.setPlatform(rs.getString("platform"));
                    game.setGenre(rs.getString("genre"));
                    game.setStatus(rs.getString("status"));
                    game.setRating(rs.getDouble("rating"));
                    game.setNotes(rs.getString("notes"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return game;
    }
    
    // This method updates an existing game.
    public boolean updateGame(Game game) {
        String sql = "UPDATE games SET title = ?, platform = ?, genre = ?, status = ?, rating = ?, notes = ? WHERE id = ?";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, game.getTitle());
            ps.setString(2, game.getPlatform());
            ps.setString(3, game.getGenre());
            ps.setString(4, game.getStatus());
            ps.setDouble(5, game.getRating());
            ps.setString(6, game.getNotes());
            ps.setInt(7, game.getId());
            
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    // This method retrieves the total amount of games stored in the database.
    public int getTotalGames() {
        String sql = "SELECT COUNT(*) FROM games";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // This method returns the total amount of games with the 'completed' status.
    public int getCompletedGames() {
        String sql = "SELECT COUNT(*) FROM games WHERE status = 'completed'";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // // This method returns the total amount of games with the 'startedNotFinish' status.
    public int getStartedGames() {
        String sql = "SELECT COUNT(*) FROM games WHERE status = 'startedNotFinish'";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // This methods calculates the average game rating of all games.
    public double getAverageRating() {
        String sql = "SELECT AVG(rating) FROM games";
        
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // This method returns the 5 recent game added to the database.
    public ArrayList<Game> getRecentGames() {
        ArrayList<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games ORDER BY id DESC LIMIT 5";
        
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
