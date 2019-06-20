package com.codecool.shop.config;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SqlInitalizer {

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


    void add (String name, String defaultprice, String currencystring, String description, String category, String artist) {
        String query = "INSERT INTO tetkok (name, defaultprice, currencystring, description, category, artist) " +
                String.format("VALUES ('%s', '%s', '%s', '%s', '%s', '%s');", name, defaultprice, currencystring, description, category, artist);
        executeQuery(query);
    }



    public List<String> selectFromString (String name) {
        String query = "select * from tetkok" +
                String.format(" WHERE name='%s';", name);
        executeQuery(query);


        executeQuery(query);

        List<String> productList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){

                String  teszt3 = resultSet.getString(3);


                productList.add(resultSet.getString("name"));

                productList.add(resultSet.getString("defaultprice"));

                productList.add(resultSet.getString("currencystring"));

                productList.add(resultSet.getString("description"));

                productList.add(resultSet.getString("category"));

                productList.add(resultSet.getString("artist"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }


    public List<String> sqlTest(List<String> testString){

        add(testString.get(0), testString.get(1), testString.get(2), testString.get(3), testString.get(4), testString.get(5));

        List<String> sqlTest = selectFromString(testString.get(0));

        deleteAll();
        return sqlTest;
    }


    // package private so test can see it, but TodoList not
    void deleteAll() {
        String query = "DELETE FROM tetkok where name='tetko';";
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