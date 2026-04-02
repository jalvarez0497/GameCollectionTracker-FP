/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xalvarezxpr
 */
public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/game_collection_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "Alvarez#0497";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
