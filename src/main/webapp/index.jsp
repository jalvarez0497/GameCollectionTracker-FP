<%-- 
    Document   : index
    Created on : Mar 14, 2026, 10:23:07?PM
    Author     : xalvarezxpr
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="includes/header.jsp">
    <jsp:param name="pageTitle" value="Game Collection Tracker Home Page" />
</jsp:include>
        
<jsp:include page="includes/navigation.jsp" />
     
<main>
    <h2>Welcome</h2>
        
    <p>
        This application allows the user to track their video game collection.
        You can add games, view your game collection, and manage your library
    </p>
    
    <section>
        <h3>Game Collection Stats</h3>
        
        <ul>
            <li><strong>Total Games:</strong> ${totalGames}</li>
            <li><strong>Completed Games:</strong> ${completedGames}</li>
            <li><strong>In Progress Games:</strong> ${startedGames}</li>
            <li><strong>Average Games Rating:</strong> <fmt:formatNumber value="${averageRating}" maxFractionDigits="1" /></li>
        </ul>
    </section>
        
    <section>
        <h3>Recently Added Games</h3>

        <c:if test="${empty recentGames}">
            <p>No games added yet.</p>
        </c:if>

        <c:if test="${not empty recentGames}">
            <ul>
                <c:forEach var="game" items="${recentGames}">
                    <li>${game.title} (${game.platform})</li>
                </c:forEach>
            </ul>
        </c:if>
    </section>
        
    <section>
        <h3>About this Project</h3>

        <p>
            This application was built as a Java Web development final project using JSP,
            Servlets, JDBC, DAO, and MySQL. It includes full CRUD functionality,
            authentication, session management, and server-side validation.
        </p>
    </section>
</main>


<jsp:include page="includes/footer.jsp" />
