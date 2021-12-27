package com.solvd.socialNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionPool {
    final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool connectionPool;
    private List<Connection> connections = new CopyOnWriteArrayList<>();

    private static final String URL = System.getenv("URL");
    private static final String USER = System.getenv("USER");
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static final int INITIAL_POOL_SIZE = 5;

    public ConnectionPool() {
        LOGGER.info("Entering ConnectionPool constructor");
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            Connection connection;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connections.add(connection);
            } catch (SQLException | ClassNotFoundException e) {
                LOGGER.error(e);
            }
        }
    }

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                    connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }


    private boolean isConnectionAvailable() {
        if (connections.isEmpty()) {
            try {
                LOGGER.info("connection is empty");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
            isConnectionAvailable();
        }
        return true;
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        if (isConnectionAvailable()) {
            LOGGER.info("Pool size = " + connections.size());
            connection = connections.get(0);
            connections.remove(0);
            LOGGER.info("Pool size after = " + connections.size());
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }
}
