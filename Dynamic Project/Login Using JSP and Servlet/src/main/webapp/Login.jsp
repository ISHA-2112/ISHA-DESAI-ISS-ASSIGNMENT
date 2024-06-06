<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
    
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="icon" type="image" href="images/rupee.jpg">

</head>
<body >
    <div class="login-container">
        <h2>Login</h2>
        <% String error = request.getParameter("error"); %>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>
        <% if ("invalid".equals(error)) { %>
            <div class="error-message">
                <p><mark style = "background-color: rgba(255, 165, 0, 0.2);">Username and password don't match. Please try again.</mark></p>
            </div>
        <% } else if ("db".equals(error)) { %>
            <div class="error-message">
                <p>Database connection error. Please try again later.</p>
            </div>
        <% } %>
        <p>Don't have an account? <a href="Register.jsp">Register</a></p>
    </div>
</body>
</html>
