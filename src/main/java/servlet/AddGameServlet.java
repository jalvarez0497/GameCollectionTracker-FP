
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Game;
import dao.GameDAO;
import jakarta.servlet.http.HttpSession;

/*
 * AddGameServlet display the add game form and process the form submissions.
*/

@WebServlet("/addGame")
public class AddGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        // Ckecking if the user is logged in before allowing access.
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
        
        // Retrieve the form parameters.
        String title = request.getParameter("title");
        String[] genres = request.getParameterValues("genre");
        String platform = request.getParameter("platform");
        String status = request.getParameter("status");
        String notes = request.getParameter("notes");
        String ratingStr = request.getParameter("rating");
        
        // Validating the form fields (title, genres, platform, status, and rating).
        if (title == null || title.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Title is required");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;
        }
        
        String genre = "";
        
        if (genres == null || genres.length == 0) {
            request.setAttribute("errorMessage", "At least one genre is required.");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;
        }
        
        genre = String.join(", ", genres);
        
        if (platform == null || platform.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Platform is required");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;
        }
        
        if (status == null || status.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Status is required");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;
        }

        double rating = 0.0;

        // Changing rating from String to double and validating the rating ranges.
        try {
            
            if (ratingStr != null && !ratingStr.isEmpty()) {
                rating = Double.parseDouble(ratingStr);
                
                if (rating < 0 || rating > 10) {
                    request.setAttribute("errorMessage", "Rating must be between 0 and 10.");
                    request.setAttribute("title", title);
                    request.setAttribute("platform", platform);
                    request.setAttribute("status", status);
                    request.setAttribute("notes", notes);
                    request.setAttribute("rating", ratingStr);
                    request.setAttribute("selectedGenres", genres);
                    request.getRequestDispatcher("addGame.jsp").forward(request, response);
                    return;
                }
            }
            
        } catch (NumberFormatException e) {
            
            request.setAttribute("errorMessage", "Rating must be a valid number.");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;      
        }
        
        if (notes != null && notes.length() > 255) {
            request.setAttribute("errorMessage", "Notes must be 255 characters or less.");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
            return;
        }

        // Creating a game object to save it to the database.
        Game game = new Game(title, platform, genre, status, rating, notes);

        GameDAO gameDAO = new GameDAO();
        boolean added = gameDAO.addGame(game);
        
        if (added) {
            response.sendRedirect("viewGames?message=added");
        } else {
            request.setAttribute("errorMessage", "Unable to add game.");
            request.setAttribute("title", title);
            request.setAttribute("platform", platform);
            request.setAttribute("status", status);
            request.setAttribute("notes", notes);
            request.setAttribute("rating", ratingStr);
            request.setAttribute("selectedGenres", genres);
            request.getRequestDispatcher("addGame.jsp").forward(request, response);
        }
    }
}
