package com.solvd.socialNetwork.utils;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionPool {
    final private static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
    private final Properties prop = new Properties();

    public ConnectionPool(String file) throws IOException {
        getPropValues(file);
    }

    private void getPropValues(String file) throws IOException {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(file + " not found");
            }

            ds.setURL(prop.getProperty("url"));
            ds.setUser(prop.getProperty("user"));
            ds.setPassword(prop.getProperty("password"));
        } catch (IOException e) {
            LOGGER.error("Met IOException");
            throw new IOException();
        } catch (Exception e) {
            LOGGER.error("Met exception " + e);
        }
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public ResultSet easyQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return  statement.executeQuery(sql);
    }
}
