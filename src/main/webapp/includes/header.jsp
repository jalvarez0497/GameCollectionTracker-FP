<%-- 
    Document   : header
    Created on : Mar 14, 2026, 11:14:03 PM
    Author     : xalvarezxpr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <%= request.getParameter("pageTitle") %> - Game Collection Tracker
        </title>
        <!-- Add styling link in here!!!!! -->
    </head>
    
    <body>
        <header>
            <h1><%= request.getParameter("pageTitle") %> </h1>
        </header>