package com.solvd.socialNetwork;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.solvd.socialNetwork.utils.CredentialValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.PooledConnection;
import java.io.IOException;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException, SQLException {

        CredentialValues credentialValues = new CredentialValues();
        credentialValues.getPropValues("db.properties");

        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

        ds.setURL(credentialValues.getUrl());
        ds.setUser(credentialValues.getUser());
        ds.setPassword(credentialValues.getPassword());

        PooledConnection pc = ds.getPooledConnection();

        Connection con = pc.getConnection();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM SocialNetwork.user");

        while (rs.next()) {
            String data = rs.getString("username");
            LOGGER.info("Fetching data by column name for row " + rs.getRow() + " : " + data);
            String dataId = rs.getString("id");
            LOGGER.info("Fetching data by column name for row " + rs.getRow() + " : " + dataId);
        }
    }
}