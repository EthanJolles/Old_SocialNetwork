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

    private static ConnectionPool connectionPool = new ConnectionPool();
    private static final int INITIAL_POOL_SIZE = 5;
    private final List<Connection> CONNECTIONS = new CopyOnWriteArrayList<>();

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public ConnectionPool() {
        LOGGER.info("Entering pool constrsuctor");
        CredentialValues credentialValues = new CredentialValues("db.properties");
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            LOGGER.info("Creating connection");
            Connection connection;
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(credentialValues.getUrl(),
                        credentialValues.getUser(), credentialValues.getPassword());
                CONNECTIONS.add(connection);
            } catch (SQLException | ClassNotFoundException e) {
                LOGGER.error(e);
            }
        }
    }

    public static ConnectionPool getConnectionPool() {
        LOGGER.info("Getting connection pool");
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                    connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }


    private boolean isConnectionAvailable() {
        if (CONNECTIONS.isEmpty()) {
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
            LOGGER.info("Pool size = " + CONNECTIONS.size());
            connection = CONNECTIONS.get(0);
            CONNECTIONS.remove(0);
            LOGGER.info("Pool size after = " + CONNECTIONS.size());
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        CONNECTIONS.add(connection);
    }
}
