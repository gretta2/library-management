package org.example.LAB3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String URL= System.getenv("Capstone1");
    static final String USER = System.getenv("USER");
    static final String PASSWORD = System.getenv("PASS");

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database!");
        } catch (SQLException e) {
            System.out.println(" Database connection failed!");
            e.printStackTrace();
        }
        return conn;
    }
}
