package com.codecool.shop.config;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class sqlInitalizer {

    private static final String DATABASE = "jdbc:postgresql://localhost:5432/tethkos";
    private static final String DB_USER = System.getenv("USER_NAME");
    private static final String DB_PASSWORD = System.getenv("USER_PASSWORD");


    public List<Product>  all() {
        String query = "SELECT * FROM tetkok;";


        executeQuery(query);

        List<Product> productList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                Product actTodo = new Product(resultSet.getString("name"),resultSet.getString("defaultprice"), resultSet.getString("currencystring"), resultSet.getString("description"), resultSet.getString("category"), resultSet.getString("artist"));

                productList.add(actTodo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;

    }


    // package private so test can see it, but TodoList not
    void deleteAll() {
        String query = "DELETE FROM todos;";
        executeQuery(query);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
        ){
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}