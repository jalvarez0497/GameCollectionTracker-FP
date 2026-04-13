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

/**
 *
 * @author xalvarezxpr
 */
@WebServlet("/deleteGame")
public class DeleteGameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            gameDAO.deleteGame(id);
        }
        
        response.sendRedirect("viewGames");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("viewGames");
    }

}
