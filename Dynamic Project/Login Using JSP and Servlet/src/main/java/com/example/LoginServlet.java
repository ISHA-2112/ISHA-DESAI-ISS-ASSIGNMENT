package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DataBaseConnection.getConnection();
            System.out.println("Connected");
            String sql = "SELECT * FROM register WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            String send_name = "";
            String[] split_name = username.split(" ", 2);
            for (int i=0; i<split_name.length;i++) {
            	send_name = send_name + Character.toString(split_name[i].charAt(0)).toUpperCase();
            	System.out.println(send_name);
            }
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Login successful, redirect to main.jsp
            	HttpSession session = request.getSession();
                session.setAttribute("username", send_name);
                request.setAttribute("username", send_name);
                //RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
                //dispatcher.forward(request, response);
                response.sendRedirect("MainPage.jsp");
            } else {
                // Login failed, redirect back to login.jsp with error message
                response.sendRedirect("Login.jsp?error=invalid");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Login.jsp?error=db");
        }
    }
    }



    
 

