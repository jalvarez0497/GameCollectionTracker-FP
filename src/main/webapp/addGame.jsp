<%-- 
    Document   : addGame
    Created on : Mar 14, 2026, 10:23:41?PM
    Author     : xalvarezxpr
--%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="pageTitle" value="Add Game" />
</jsp:include>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%
    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("login");
        return;
    }
%>



<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>Add a new game</h2>
    
    <p>This page allows the user to add a new game to their collection</p>
    
    <c:if test="${not empty erroMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>
    
    <section id="addGameForm">
        
        <form action="${pageContext.request.contextPath}/addGame" method="post">
            <label for="gameTitle">Game Title:</label><br>
            <input type="text" name="title" id="title" value="${title}"><br>
            
            <label for="genre">Select game genre's:</label><br>
            <input type="checkbox" name="genre" value="action"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'action')}">checked</c:if>>Action<br>

            <input type="checkbox" name="genre" value="adventure"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'adventure')}">checked</c:if>>Adventure<br>

            <input type="checkbox" name="genre" value="br"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'br')}">checked</c:if>>Battle Royale game's<br>

            <input type="checkbox" name="genre" value="rpg"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'rpg')}">checked</c:if>>Role-playing games (RPG)<br>

            <input type="checkbox" name="genre" value="shooter"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'shooter')}">checked</c:if>>Shooter<br>

            <input type="checkbox" name="genre" value="simulation"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'simulation')}">checked</c:if>>Simulation<br>

            <input type="checkbox" name="genre" value="strategy"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'strategy')}">checked</c:if>>Strategy<br>

            <input type="checkbox" name="genre" value="sports"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'sports')}">checked</c:if>>Sports<br>

            <input type="checkbox" name="genre" value="survival"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'survival')}">checked</c:if>>Survival<br>

            <input type="checkbox" name="genre" value="racing"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'racing')}">checked</c:if>>Racing<br>

            <input type="checkbox" name="genre" value="platform"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'platform')}">checked</c:if>>Platform<br>

            <input type="checkbox" name="genre" value="puzzle"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'puzzle')}">checked</c:if>>Puzzle<br>

            <input type="checkbox" name="genre" value="fighting"
                <c:if test="${selectedGenres != null && fn:contains(fn:join(selectedGenres, ','), 'fighting')}">checked</c:if>>Fighting<br>
            
            
            <label for="platform">Platform:</label><br>
            
            <select name="platform" id="platform">
                <option value="" disabled ${empty platform ? 'selected' : ''}>---Choose a platform---</option>
                <option value="xbox" <c:if test="${platform == 'xbox'}">selected</c:if>>Xbox (Original)</option>
                <option value="xbox360" <c:if test="${platform == 'xbox360'}">selected</c:if>>Xbox 360</option>
                <option value="xbox1" <c:if test="${platform == 'xbox1'}">selected</c:if>>Xbox One</option>
                <option value="xboxXS" <c:if test="${platform == 'xboxXS'}">selected</c:if>>Xbox Series X/S</option>
                <option value="ps3" <c:if test="${platform == 'ps3'}">selected</c:if>>PlayStation 3</option>
                <option value="ps4" <c:if test="${platform == 'ps4'}">selected</c:if>>PlayStation 4</option>
                <option value="ps5" <c:if test="${platform == 'ps5'}">selected</c:if>>PlayStation 5</option>
                <option value="psp" <c:if test="${platform == 'psp'}">selected</c:if>>PlayStation Portable</option>
                <option value="nintendoDs" <c:if test="${platform == 'nintendoDs'}">selected</c:if>>Nintendo DS</option>
                <option value="nintendo3ds" <c:if test="${platform == 'nintendo3ds'}">selected</c:if>>Nintendo 3DS</option>
                <option value="switch" <c:if test="${platform == 'switch'}">selected</c:if>>Nintendo Switch / Switch 2</option>
            </select>
            
            <br>
            
            <label for="status">Status:</label>
            
            <br>
            
            <select name="status" id="status">
                <option value="" disabled ${empty status ? 'selected' : ''}>---Game Status---</option>
                <option value="completed" <c:if test="${status == 'completed'}">selected</c:if>>Completed</option>
                <option value="notStarted" <c:if test="${status == 'notStarted'}">selected</c:if>>Haven't started</option>
                <option value="startedNotFinish" <c:if test="${status == 'startedNotFinish'}">selected</c:if>>Started, not finished</option>
            </select>

            <br>
            
            <label for="rating">Rating:</label><br>
            <input type="text" name="rating" id="rating" value="${rating}"><br>
            
            <label for="notes">Notes:</label><br>
            <textarea name="notes" cols="40" rows="5">${notes}</textarea>
<!--            <input type="text" for="notes" id="notes"><br>-->
<br><br>
            <button type="submit">Add Game</button>
        </form>
        
    </section>
</main>

<jsp:include page="includes/footer.jsp" />
