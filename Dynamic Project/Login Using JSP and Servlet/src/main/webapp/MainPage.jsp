<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinNews</title>
    <link rel="stylesheet" href="css/styling.css">
    <link rel="icon" type="image" href="images/rupee.jpg">
</head>
<body>

    <header>
        <div class="logo-container">
            <img src="images/rupee.jpg" alt="Logo" class="logo-image">
            <div class="logo-text">FinNews</div>
        </div>
        <nav>
            <ul class="left-nav">
                <li><a style = "margin-left: 20px" href="#">Home</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
            <ul class="right-nav">
                <li><a href="LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="content">
            <div class="finance-articles">
                <div class="article-box">
              
                    <h2>Article 1</h2>
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Esse corrupti ex nulla ducimus maxime molestiae quis voluptatibus dolor neque quasi voluptatem pariatur reiciendis aliquam hic incidunt porro, ab suscipit consequuntur!</p>
                </div>
                <div class="article-box">
                    <h2>Article 2</h2>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel, dignissimos iste, saepe quis numquam laudantium dolorem velit tenetur earum voluptas unde nam, aspernatur veritatis odio quod asperiores quaerat perspiciatis alias!</p>
                </div>
            </div>
            
            <aside class="user-profile-summary">
                <div class="profile-image">${username }</div>
                <p>Username: [User's Name]</p>
                <p>Email: [Email]</p>
                <br>
                <a href="#" class="edit-profile-button">Edit Profile</a>
                <br>
                <a href="LogoutServlet" class="edit-profile-button">Logout</a>
            </aside>
        </div>
    </main>

</body>
</html>
