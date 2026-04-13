<%-- 
    Document   : editGame
    Created on : Mar 14, 2026, 10:24:07?PM
    Author     : xalvarezxpr
--%>

<jsp:include page="includes/header.jsp">
    <jsp:param name="pageTitle" value="Edit Game" />
</jsp:include>

<%
    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("login");
        return;
    }
%>

<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>Edit Game</h2>
    
    <p>This page allows the user to edit any information for a selected game.</p>
    
    <p>The edit form will be placed here!!!!</p>
</main>

<jsp:include page="includes/footer.jsp" />