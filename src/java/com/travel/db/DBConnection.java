package com.travel.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/travel_db",
                        "root",
                        "Access@123"
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
