<%-- 
    Document   : updateGame
    Created on : Apr 11, 2026, 3:03:54 PM
    Author     : xalvarezxpr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Game Page</title>
    </head>
    <body>
        <h1>Update Game Form</h1>
        
        <form action="${pageContext.request.contextPath}/updateGame" method="post">
            
            <input type="hidden" name="id" value="${game.id}">
            
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${game.title}" required>
            <br><br>
            
            <label>Genre:</label>
            <input type="checkbox" name="genre" value="action"
                   <c:if test="${game.genre != null && game.genre.contains('action')}">checked</c:if>>Action
            
            <input type="checkbox" name="genre" value="adventure"
                   <c:if test="${game.genre != null && game.genre.contains('adventure')}">checked</c:if>>Adventure
            
            <input type="checkbox" name="genre" value="br"
                   <c:if test="${game.genre != null && game.genre.contains('br')}">checked</c:if>>Battle Royale game's
            
            <input type="checkbox" name="genre" value="rpg"
                   <c:if test="${game.genre != null && game.genre.contains('rpg')}">checked</c:if>>RPG
            
            <input type="checkbox" name="genre" value="shooter"
                   <c:if test="${game.genre != null && game.genre.contains('shooter')}">checked</c:if>>Shooter
            
            <input type="checkbox" name="genre" value="simulation"
                   <c:if test="${game.genre != null && game.genre.contains('simulation')}">checked</c:if>>Simulation
            
            <input type="checkbox" name="genre" value="strategy"
                   <c:if test="${game.genre != null && game.genre.contains('strategy')}">checked</c:if>>Strategy
            
            <input type="checkbox" name="genre" value="sport"
                   <c:if test="${game.genre != null && game.genre.contains('sport')}">checked</c:if>>Sports
            
            <input type="checkbox" name="genre" value="survival"
                   <c:if test="${game.genre != null && game.genre.contains('survival')}">checked</c:if>>Survival
            
            <input type="checkbox" name="genre" value="racing"
                   <c:if test="${game.genre != null && game.genre.contains('racing')}">checked</c:if>>Racing
            
            <input type="checkbox" name="genre" value="platform"
                   <c:if test="${game.genre != null && game.genre.contains('platform')}">checked</c:if>>Platform
            
            <input type="checkbox" name="genre" value="puzzle"
                   <c:if test="${game.genre != null && game.genre.contains('puzzle')}">checked</c:if>>Puzzle
            
            <input type="checkbox" name="genre" value="fighting"
                   <c:if test="${game.genre != null && game.genre.contains('figthing')}">checked</c:if>>Fighting
            
            <br><br>
            
            <label for="platform">Platform:</label>
            <select id="platform" name="platform" required>
                <option value="xbox" <c:if test="${game.platform == 'xbox'}">selected</c:if>>Xbox (Original)</option>
                <option value="xbox360" <c:if test="${game.platform == 'xbox360'}">selected</c:if>>Xbox 360</option>
                <option value="xbox1" <c:if test="${game.platform == 'xbox1'}">selected</c:if>>Xbox One</option>
                <option value="xboxXS" <c:if test="${game.platform == 'xboxXS'}">selected</c:if>>Xbox Series X/S</option>
                <option value="ps3" <c:if test="${game.platform == 'ps3'}">selected</c:if>>PlayStation 3</option>
                <option value="ps4" <c:if test="${game.platform == 'ps4'}">selected</c:if>>PlayStation 4</option>
                <option value="ps5" <c:if test="${game.platform == 'ps5'}">selected</c:if>>PlayStation 5</option>
                <option value="psp" <c:if test="${game.platform == 'psp'}">selected</c:if>>PlayStation Portable</option>
                <option value="nintendoDs" <c:if test="${game.platform == 'nintendoDs'}">selected</c:if>>Nintendo DS</option>
                <option value="nintendo3ds" <c:if test="${game.platform == 'nintendo3ds'}">selected</c:if>>Nintendo 3DS</option>
                <option value="switch" <c:if test="${game.platform == 'switch'}">selected</c:if>>Nintendo Switch / Switch 2</option>
            </select>
            
            <br><br>
            
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="completed" <c:if test="${game.status == 'completed'}">selected</c:if>>Completed</option>
                <option value="notStarted" <c:if test="${game.status == 'notStarted'}">selected</c:if>>Haven't started</option>
                <option value="startedNotFinish" <c:if test="${game.status == 'startedNotFinish'}">selected</c:if>>Started, not finished</option>
            </select>
            
            <br><br>
            
            <label for="rating">Rating:</label>
            <input type="number" id="rating" name="rating" step="0.1" min="0" max="10" value="${game.rating}">
            
            <br><br>
            
            <label for="notes">Notes:</label><br>
            <textarea id="notes" name="notes" rows="4" cols="40">${game.notes}</textarea>
            
            <br><br>
            
            <input type="submit" value="Update Game">
            
        </form>
    </body>
</html>
