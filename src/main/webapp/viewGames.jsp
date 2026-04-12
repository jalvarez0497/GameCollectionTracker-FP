<%-- 
    Document   : viewGames
    Created on : Mar 14, 2026, 10:23:56?PM
    Author     : xalvarezxpr
--%>

<%@taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:include page="includes/header.jsp">
    <jsp:param name="pageTitle" value="View Collection" />
</jsp:include>

<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>My Game Collection</h2>
    
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Platform</th>
                <th>Genre</th>
                <th>Status</th>
                <th>Rating</th>
                <th>Notes</th>
                <th>Actions</th>
            </tr>
            
            <c:forEach var="game" items="${games}">
                <tr>
                    <td>${game.id}</td>
                    <td>${game.title}</td>
                    <td>${game.platform}</td>
                    <td>${game.genre}</td>
                    <td>${game.status}</td>
                    <td>${game.rating}</td>
                    <td>${game.notes}</td>
                    <td>
                        <a href="deleteGame?id=${game.id}">Delete</a>
                        /
                        <a href="updateGame?id=${game.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    
    <br>
    
    <a href="addGame">Add Another Game</a>
        
</main>

<jsp:include page="includes/footer.jsp" />
