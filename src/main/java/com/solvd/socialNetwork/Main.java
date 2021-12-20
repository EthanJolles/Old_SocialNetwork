package com.solvd.socialNetwork;

import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        LOGGER.info("Hello, world");

        ConnectionPool connectionPool = new ConnectionPool(
                System.getenv("SERVER"),
                System.getenv("SCHEMA"),
                System.getenv("USER"),
                System.getenv("PASSWORD"));
    }
}
