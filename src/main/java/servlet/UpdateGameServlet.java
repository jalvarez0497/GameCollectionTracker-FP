/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.GameDAO;
import jakarta.servlet.http.HttpSession;
import model.Game;

/**
 *
 * @author xalvarezxpr
 */
@WebServlet("/updateGame")
public class UpdateGameServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }
        
        String idStr = request.getParameter("id");
        
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            
            GameDAO gameDAO = new GameDAO();
            Game game = gameDAO.getGameById(id);
            
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
        } else {
            response.sendRedirect("viewGames");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String[] genres = request.getParameterValues("genre");
        String platform = request.getParameter("platform");
        String status = request.getParameter("status");
        String notes = request.getParameter("notes");

        String genre = "";
        if (genres != null) {
            genre = String.join(", ", genres);
        }

        String ratingStr = request.getParameter("rating");
        double rating = 0.0;
        if (ratingStr != null && !ratingStr.isEmpty()) {
            rating = Double.parseDouble(ratingStr);
        }

        Game game = new Game();
        game.setId(id);
        game.setTitle(title);
        game.setGenre(genre);
        game.setPlatform(platform);
        game.setStatus(status);
        game.setRating(rating);
        game.setNotes(notes);

        GameDAO gameDAO = new GameDAO();
        boolean updated = gameDAO.updateGame(game);

        if (updated) {
            response.sendRedirect("viewGames");
        } else {
            request.setAttribute("errorMessage", "Unable to update game.");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
        }
    }

}
