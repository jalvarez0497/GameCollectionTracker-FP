<%-- 
    Document   : navigation
    Created on : Mar 14, 2026, 10:52:07?PM
    Author     : xalvarezxpr
--%>

<nav class="navbar">
    
    <button class="menu-toggle" onclick="toggleMenu()">=</button>
    
    <div class="nav-links" id="navLinks">       
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <a href="${pageContext.request.contextPath}/login">Login</a>
        <a href="${pageContext.request.contextPath}/addGame">Add Game</a>
        <a href="${pageContext.request.contextPath}/viewGames">View Game Collection</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
    
</nav>
    
    <script>
        function toggleMenu() {
            document.getElementById("navLinks").classList.toggle("show");
        }
    </script>
    
    <hr>