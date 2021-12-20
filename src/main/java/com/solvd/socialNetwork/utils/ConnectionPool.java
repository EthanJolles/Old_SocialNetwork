package com.solvd.socialNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionPool implements IConnectionPool {
    private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private String url;
    private String user;
    private String password;
    private ConcurrentHashMap<String, Connection> connectionPool;
    private ConcurrentHashMap<String, Connection> usedConnections;
    private static ConnectionPool connectionPoolExample; //singleton
    private static final int INITIAL_POOL_SIZE = 5;

    public ConnectionPool(String server, String schema, String user, String password) {
        this.url = "jdbc:mysql://" + server + "/" +schema;
        this.user = user;
        this.password = password;
    }

    private ConnectionPool() {

    }

    private ConnectionPool(ConcurrentHashMap<String, Connection> pool) {

    }

    private static ConnectionPool create(String url, String user, String password) {
        ConcurrentHashMap<String, Connection> pool = new ConcurrentHashMap<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.put("First created pool", (Connection) create(url, user, password));
        }
        return new ConnectionPool(pool);

    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove("First created pool");
        usedConnections.put("Used connection", connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.put("Connection", connection);
        return usedConnections.remove("Used connection",connection);
    }

    private static Connection createConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.info("SQLException: " + e.getMessage());
            LOGGER.info("SQLState: " + e.getSQLState());
            LOGGER.info("VendorError: " + e.getErrorCode());
        }
        return conn;
    }

    //lazy initialization
    public static ConnectionPool getInstance(){
        if (connectionPoolExample == null)
            connectionPoolExample = new ConnectionPool();
        return connectionPoolExample;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
