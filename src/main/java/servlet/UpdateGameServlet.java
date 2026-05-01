
package servlet;

import dao.GameDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Game;

/*
 * UpdateGameServlet handle the game editing form.
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

        // Retrieves a game by the ID to send to the update form.
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
        String ratingStr = request.getParameter("rating");

        String genre = "";
        if (genres != null) {
            genre = String.join(", ", genres);
        }

        Game game = new Game();
        game.setId(id);
        game.setTitle(title);
        game.setGenre(genre);
        game.setPlatform(platform);
        game.setStatus(status);
        game.setNotes(notes);

        double rating = 0.0;

        // Validating the users inputs in the update game form.
        if (title == null || title.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Title is required");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        if (genres == null || genres.length == 0) {
            request.setAttribute("errorMessage", "At least one genre is required.");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        if (platform == null || platform.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Platform is required");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        if (status == null || status.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Status is required");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        try {
            if (ratingStr != null && !ratingStr.isEmpty()) {
                rating = Double.parseDouble(ratingStr);

                if (rating < 0 || rating > 10) {
                    request.setAttribute("errorMessage", "Rating must be between 0 and 10.");
                    request.setAttribute("game", game);
                    request.getRequestDispatcher("updateGame.jsp").forward(request, response);
                    return;
                }
            }

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Rating must be a valid number.");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        if (notes != null && notes.length() > 255) {
            request.setAttribute("errorMessage", "Notes must be 255 characters or less.");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
            return;
        }

        game.setRating(rating);

        GameDAO gameDAO = new GameDAO();
        boolean updated = gameDAO.updateGame(game);

        if (updated) {
            response.sendRedirect("viewGames?message=updated");
        } else {
            request.setAttribute("errorMessage", "Unable to update game.");
            request.setAttribute("game", game);
            request.getRequestDispatcher("updateGame.jsp").forward(request, response);
        }
    }
}
