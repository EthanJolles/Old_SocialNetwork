package com.solvd.socialNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialValues {

    public CredentialValues() {
    }

    final private Logger LOGGER = LogManager.getLogger(CredentialValues.class);
    private final Properties prop = new Properties();
    private String url;
    private String user;
    private String password;

    public String getUrl () {
        return url;
    }

    public String getUser () {
        return user;
    }

    public String getPassword () {
        return password;
    }

    public void getPropValues(String file) throws IOException {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(file + " not found");
            }

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (Exception e) {
            LOGGER.error("Met exception " + e);
        }
    }
}
