
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.GameDAO;
import jakarta.servlet.http.HttpSession;

/**
 *
 * DeleteGameServlet handles the deletion of a game from the database.
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
        
        // Deleteing a game based on the game ID.
        String idStr = request.getParameter("id");
        
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            
            GameDAO gameDAO = new GameDAO();
            gameDAO.deleteGame(id);
        }
        
        response.sendRedirect("viewGames?message=deleted");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("viewGames");
    }

}
