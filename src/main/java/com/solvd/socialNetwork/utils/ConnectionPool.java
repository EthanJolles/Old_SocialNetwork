package com.solvd.socialNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    public void loadDriver() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
    }

    public void obtainConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(System.getenv("URL"),
                    System.getenv("USER"),
                    System.getenv("PASS"));

            LOGGER.info(conn.getSchema());
        } catch (SQLException ex) {
            // handle any errors
            LOGGER.info("SQLException: " + ex.getMessage());
            LOGGER.info("SQLState: " + ex.getSQLState());
            LOGGER.info("VendorError: " + ex.getErrorCode());
        } finally {
            LOGGER.info("Connection success");
        }
    }
}
