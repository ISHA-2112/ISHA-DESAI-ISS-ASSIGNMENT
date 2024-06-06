<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
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
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="icon" type="image" href="images/rupee.jpg">
</head>
<body>
    <div class="login-container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="username" placeholder="Username" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>" required>
            <input type="email" name="email" placeholder="Email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" required>
            <input type="password" name="password" placeholder="Password" value="<%= request.getAttribute("password") != null ? request.getAttribute("password") : "" %>" required>
            <input type="password" name="confirm_password" placeholder="Confirm Password" required>
            <input type="submit" value="Register">
        </form>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <div class="error-message">
                <p><mark style = "background-color: rgba(255, 165, 0, 0.2);"><%= errorMessage %></mark></p>
            </div>
        <% } %>
        <p>Already have an account? <a href="Login.jsp">Login</a></p>
    </div>
</body>
</html>
