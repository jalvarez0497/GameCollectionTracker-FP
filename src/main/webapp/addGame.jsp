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
    
    <hr>
    
    <section>
        
        <form>
            <label for="gameTitle">Game Title:</label><br>
            <input type="text" for="gameTitle" id="title"><br>
            
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
            
            <label 
        </form>
        
    </section>
</main>

<jsp:include page="includes/footer.jsp" />
