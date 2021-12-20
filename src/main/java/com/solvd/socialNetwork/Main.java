package com.solvd.socialNetwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        LOGGER.info("Hello, world");

        Connection connection = null;
        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

            // Create a connection to the database

            String serverName = System.getenv("SERVER");

            String schema = System.getenv("SCHEMA");

            String url = "jdbc:mysql://" + serverName +  "/" + schema;

            String username = System.getenv("USER");

            String password = System.getenv("PASS");

            connection = DriverManager.getConnection(url, username, password);


            System.out.println("Successfully Connected to the database!");


        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }

        try {
            // Get a result set containing all data from test_table

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM SocialNetwork.user");

            // For each row of the result set ...

            while (results.next()) {
                // Get the data from the current row using the column index - column data are in the VARCHAR format
                String data = results.getString("username");
                LOGGER.info("Fetching data by column name for row " + results.getRow() + " : " + data);
            }

        } catch (SQLException e) {

            LOGGER.info("Could not retrieve data from the database " + e.getMessage());
        }
    }
}