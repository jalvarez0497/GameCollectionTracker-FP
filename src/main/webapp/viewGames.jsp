<%-- 
    Document   : viewGames
    Created on : Mar 14, 2026, 10:23:56?PM
    Author     : xalvarezxpr
--%>

<%@page import="java.util.List" %>
<%@page import="model.Game" %>

<jsp:include page="includes/header.jsp">
    <jsp:param name="pageTitle" value="View Collection" />
</jsp:include>

<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>My Game Collection</h2>
    
    <%
        List<Game> games = (List<Game>) session.getAttribute("games");
    %>
    
    <%
        if (games == null || games.isEmpty()) {
    %>
            <p>No games added yet.</p>
    <%        
        } else {
    %>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Platform</th>
                <th>Genre</th>
                <th>Status</th>
                <th>Rating</th>
                <th>Notes</th>
            </tr>
            
            <%
                for (Game game : games) {
            %>
            <tr>
                <td><%= game.getTitle() %></td>
                <td><%= game.getPlatform() %></td>
                <td><%= game.getGenre() %></td>
                <td><%= game.getStatus() %></td>
                <td><%= game.getRating() %></td>
                <td><%= game.getNotes() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>
    
    <br>
    
    <a href="addGame">Add Another Game</a>
        
</main>

<jsp:include page="includes/footer.jsp" />
