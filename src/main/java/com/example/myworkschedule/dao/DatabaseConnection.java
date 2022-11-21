package com.example.myworkschedule.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/management?serverTimezone=UTC";
    static String USER = "root";
    static String PASSWORD = "root";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
