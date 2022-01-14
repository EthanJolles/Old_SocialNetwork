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


    private ConnectionPool() {
        CredentialValues credentialValues = new CredentialValues("db.properties");
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
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
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }

    @Deprecated
    private boolean isConnectionAvailable() {
        if (CONNECTIONS.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
            isConnectionAvailable();
        }
        return true;
    }

    public synchronized Connection getConnection() {
        while (CONNECTIONS.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
        Connection connection = CONNECTIONS.get(0);
        CONNECTIONS.remove(0);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        CONNECTIONS.add(connection);
    }
}
