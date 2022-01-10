package com.solvd.socialNetwork;

import com.solvd.socialNetwork.dao.jdbcMySQLImpl.UserDaoImpl;
import com.solvd.socialNetwork.model.order.Product;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.JaxBHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        try {
//            UserDaoImpl userDao = new UserDaoImpl();
//            User test = new User("test21","solvdintern123");
//            userDao.create(test);
//        } catch (SQLException e) {
//            LOGGER.error(e);
//        }

        //JaxB unmarshaller
        try {
            LOGGER.info(JaxBHandler.unmarshall("product.xml",Product.class));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }
}