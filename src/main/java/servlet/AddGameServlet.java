/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import model.Game;
import dao.GameDAO;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addGame")
public class AddGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }

        request.getRequestDispatcher("addGame.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }
        
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
        
        String idStr = request.getParameter("id");
        int id = 0;

        if (idStr != null && !idStr.isEmpty()) {
            rating = Integer.parseInt(idStr);
        }

        Game game = new Game(id, title, platform, genre, status, rating, notes);

        GameDAO gameDAO = new GameDAO();
        boolean added = gameDAO.addGame(game);
        
        if (added) {
            response.sendRedirect("viewGames");
        } else {
            request.setAttribute("errorMessage", "Unable to add game.");
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
        }
    }
}
