package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load the SQL Server JDBC driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        // Define the connection URL
        String jdbcURL = "jdbc:sqlserver://LAPTOP-IVO2FEIG;databaseName=Exam;integratedSecurity=true;encrypt=false";
       
        
        // Establish and return the connection
        return DriverManager.getConnection(jdbcURL);
    }
}
