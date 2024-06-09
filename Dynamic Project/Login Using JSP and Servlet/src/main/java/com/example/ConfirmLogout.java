package com.example;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class ConfirmLogout extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		// Disabling caching in order to prevent the user from visiting Main Page without logging in
		httpRes.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		httpRes.setHeader("Pragma", "no-cache"); // HTTP 1.0
		httpRes.setDateHeader("Expires", 0); // Proxy Server
		
		String[] parts = httpReq.getServletPath().split("/");
		
		String page = parts[parts.length - 1];
		
		HttpSession session = httpReq.getSession();
		
		// If user is not logged in then prevent user from accessing welcome page
		
		if (page.equals("MainPage.jsp") && session.getAttribute("username") == null) {
			httpRes.sendRedirect(httpReq.getContextPath() + "/Login.jsp");
			return;
		} 
		
		
		chain.doFilter(request, response);
	}


}