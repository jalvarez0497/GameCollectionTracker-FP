<%-- 
    Document   : addGame
    Created on : Mar 14, 2026, 10:23:41?PM
    Author     : xalvarezxpr
--%>

<jsp:include page="includes/header.jsp" >
    <jsp:param name="pageTitle" value="Add Game" />
</jsp:include>

<jsp:include page="includes/navigation.jsp" />

<main>
    <h2>Add a new game</h2>
    
    <p>This page allows the user to add a new game to their collection</p>
    
    <section id="addGameForm">
        
        <form action="/AddGameServlet.java" method="post">
            <label for="gameTitle">Game Title:</label><br>
            <input type="text" for="gameTitle" id="title"><br>
            
            <label for="genres">Select game genre's:</label><br>
            <input type="checkbox" for="genres" value="action">Action<br>
            <input type="checkbox" for="genres" value="adventure">Adventure<br>
            <input type="checkbox" for="genres" value="br">Battle Royale game's<br>
            <input type="checkbox" for="genres" value="rpg">Role-playing games (RPG)<br>
            <input type="checkbox" for="genres" value="shooter">Shooter<br>
            <input type="checkbox" for="genres" value="simulation">Simulation<br>
            <input type="checkbox" for="genres" value="strategy">Strategy<br>
            <input type="checkbox" for="genres" value="sports">Sports<br>
            <input type="checkbox" for="genres" value="survival">Survival<br>
            <input type="checkbox" for="genres" value="racing">Racing<br>
            <input type="checkbox" for="genres" value="platform">Platform<br>
            <input type="checkbox" for="genres" value="puzzle">Puzzle<br>
            <input type="checkbox" for="genres" value="fighting">Fighting<br>
            
            
            <label for="platform">Platform:</label><br>
            
            <select name="platform" id="platform">
                <option value="default">---Choose a platform---</option>
                <option value="xbox">Xbox (Original)</option>
                <option value="xbox360">Xbox 360</option>
                <option value="xbox1">Xbox One</option>
                <option value="xboxXS">Xbox Series X/S</option>
                <option value="ps3">PlayStation 3</option>
                <option value="ps4">PlayStation 4</option>
                <option value="ps5">PlayStation 5</option>
                <option value="psp">PlayStation Portable</option>
                <option value="nintendoDs">Nintendo DS</option>
                <option value="nintendo3ds">Nintendo 3DS</option>
                <option value="switch">Nintendo Switch / Switch 2</option>
            </select>
            
            <br>
            
            <label for="status">Status:</label>
            
            <br>
            
            <select name="status" id="status">
                <option value="default">---Game Status---</option>
                <option value="completed">Completed</option>
                <option value="notStarted">Haven't started</option>
                <option value="startedNotFinish">Started, Not yet finished</option>
            </select>
            
            <br>
            
            <label for="rating">Rating:</label><br>
            <input type="text" for="rating" id="rating"><br>
            
            <label for="notes">Notes:</label><br>
            <textarea name="notes" cols="40" rows="5"></textarea>
<!--            <input type="text" for="notes" id="notes"><br>-->
            
            <label 
        </form>
        
    </section>
</main>

<jsp:include page="includes/footer.jsp" />
