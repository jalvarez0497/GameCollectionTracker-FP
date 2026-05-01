package servlet;

import dao.GameDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author xalvarezxpr
 */
@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GameDAO gameDAO = new GameDAO();
        
        request.setAttribute("totalGames", gameDAO.getTotalGames());
        request.setAttribute("completedGames", gameDAO.getCompletedGames());
        request.setAttribute("startedGames", gameDAO.getStartedGames());
        request.setAttribute("averageRating", gameDAO.getAverageRating());
        request.setAttribute("recentGames", gameDAO.getRecentGames());
        
        request.getRequestDispatcher("index.jsp").forward(request, response);       
    }
}
