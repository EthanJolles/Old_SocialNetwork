package com.solvd.socialNetwork;

import com.solvd.socialNetwork.utils.CredentialValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        LOGGER.info("Hello, world");

        CredentialValues credentialValues = new CredentialValues();

        credentialValues.getPropValues("db.properties");

        Connection connection = null;
        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

            // Create a connection to the database

//            String serverName = System.getenv("SERVER");
            String serverName = credentialValues.getUrl();

//            String schema = System.getenv("SCHEMA");
            String schema = credentialValues.getSchema();

            String url = "jdbc:mysql://" + serverName +  "/" + schema;

//            String username = System.getenv("USER");
            String username = credentialValues.getName();


            String password = credentialValues.getPassword();

            connection = DriverManager.getConnection(url, username, password);


            LOGGER.info("Successfully Connected to the database!");


        } catch (ClassNotFoundException e) {

            LOGGER.info("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            LOGGER.info("Could not connect to the database " + e.getMessage());
        }

        try {
            // Get a result set containing all data from test_table

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM SocialNetwork.user");

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