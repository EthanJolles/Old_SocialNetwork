package com.solvd.socialNetwork;

import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, SQLException {

        ConnectionPool connPool = new ConnectionPool("db.properties");

        ResultSet rs = connPool.easyQuery("SELECT * FROM SocialNetwork.user");

        while (rs.next()) {
            LOGGER.info("UserID: " + rs.getString("id"));
            LOGGER.info("Username: " + rs.getString("username"));
        }
    }
}