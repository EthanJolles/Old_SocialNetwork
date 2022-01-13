package com.solvd.socialNetwork;

import com.solvd.socialNetwork.model.order.Product;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.JaxBHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

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
            LOGGER.info(JaxBHandler.unmarshall("product.xml", Product.class));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }

        try {
            User userObj = new User("Test2", "Test2");
            LOGGER.info("Attempting to marshal");
            JaxBHandler.marshaller(userObj, User.class, "userObj");
            LOGGER.info("Marshal completed");
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }


}