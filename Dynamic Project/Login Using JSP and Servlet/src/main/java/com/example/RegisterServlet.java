package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String errorMessage = "";
    	HttpSession session = request.getSession();
        int flag = 0;
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String c_password = request.getParameter("confirm_password");
        // Check id password and confirm password are matching
        if (!password.equals(c_password)){
        	errorMessage = "Password and Confirm Password don't match";
        	flag = 1;
        	
        	session.setAttribute("errorMessage", errorMessage);
        	session.setAttribute("username", name);
            session.setAttribute("email", email);
            System.out.println("Sent");
            response.sendRedirect("Register.jsp");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Forward the request to result.jsp
     
        if (flag == 0) {
        	
        try {
            Connection conn = DataBaseConnection.getConnection();
            // insert into database
            String sql = "insert into register (username, email, password) values(?, ?, ?);";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name); 
            stmt.setString(2, email); 
            stmt.setString(3, password); 
            stmt.execute();
            
            // get the letters  of name and surname to make the profile image
            String send_name = "";
            String[] split_name = name.split(" ", 2);
            for (int i=0; i<split_name.length;i++) {
            	send_name = send_name + Character.toString(split_name[i].charAt(0)).toUpperCase();

            }
            session.setAttribute("name", send_name);
            response.sendRedirect("MainPage.jsp");

            stmt.close();
            conn.close();
        } 
        
        // check for repeated username or email
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
            if (e.getMessage().contains("Violation of PRIMARY KEY")) {
                errorMessage = "Username already exists. Please choose a different username.";
            }
            
            if (e.getMessage().contains("Violation of UNIQUE KEY")) {
                errorMessage = "Email already exists. Please choose a different email.";
            }
            session.setAttribute("errorMessage", errorMessage);
            session.setAttribute("username", name);
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            response.sendRedirect("Register.jsp");

            out.println("Database connection error: " + errorMessage);
            out.println("Database connection error: " + e.getMessage());
  
        }
    }


    }
    
    }

