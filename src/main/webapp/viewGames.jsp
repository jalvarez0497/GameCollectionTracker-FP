<%-- 
    Document   : viewGames
    Created on : Mar 14, 2026, 10:23:56?PM
    Author     : xalvarezxpr
--%>

<%@taglib uri="jakarta.tags.core" prefix="c" %>

<%
    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("login");
        return;
    }
%>

<jsp:include page="includes/header.jsp">
    <jsp:param name="pageTitle" value="View Collection" />
</jsp:include>


<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>My Game Collection</h2>
    
    <c:if test="${not empty successMessage}">
        <p class="success-message">${successMessage}</p>
    </c:if>
    
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
                        <a class="update-link" href="${pageContext.request.contextPath}/updateGame?id=${game.id}">Update</a>
                        <br><br>
                        <form action="deleteGame" method="post">
                            <input type="hidden" name="id" value="${game.id}">
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    
    <br>
    
    <a href="addGame">Add Another Game</a>
        
</main>

<jsp:include page="includes/footer.jsp" />
