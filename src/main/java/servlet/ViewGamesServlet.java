/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import model.Game;
import dao.GameDAO;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author xalvarezxpr
 */
@WebServlet("/viewGames")
public class ViewGamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }
        
        GameDAO gameDAO = new GameDAO();
        ArrayList<Game> games = gameDAO.getAllGames();
        
        request.setAttribute("games", games);
        
        String message = request.getParameter("message");
        
        if ("added".equals(message)) {
            request.setAttribute("successMessage", "Game added successfully.");
        } else if ("updated".equals(message)) {
            request.setAttribute("successMessage", "Game updated successfully.");
        } else if ("deleted".equals(message)) {
            request.setAttribute("successMessage", "Game deleted successfully.");
        }
        
        request.getRequestDispatcher("/viewGames.jsp").forward(request, response);
    }
}
