package com.codecool.shop.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_NAME = System.getenv("DB_NAME");
    private static final String DB_HOST = System.getenv("DB_HOST");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public static final String URL = "jdbc:postgresql://localhost:5432/webshop";

    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    URL,
                    DB_USER,
                    DB_PASSWORD
            );
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
