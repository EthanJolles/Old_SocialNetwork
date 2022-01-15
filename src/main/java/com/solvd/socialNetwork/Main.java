package com.solvd.socialNetwork;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.socialNetwork.dao.jdbcMySQLImpl.UserDaoImpl;
import com.solvd.socialNetwork.model.order.Product;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.JaxBHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        for (int i = 1; i <= 1; i++) {
            try {
                UserDaoImpl userDao = new UserDaoImpl();
                User test = new User("test" + i,"" + i);
                userDao.create(test);
                LOGGER.info("Entry:" + i + " completed");

                userDao.delete(test.getId());
                LOGGER.info("Delete:" + i + " completed");

            } catch (Exception e) {
                LOGGER.error(e);
            }
        }

//        //JaxB unmarshaller
//        try {
//            LOGGER.info(JaxBHandler.unmarshal("product.xml", Product.class));
//        } catch (JAXBException e) {
//            LOGGER.error(e);
//        }
//
//        try {
//            User userObj = new User("Test2", "Test2");
//            LOGGER.info("Attempting to marshal");
//            JaxBHandler.marshal(userObj, User.class, "userObj");
//            LOGGER.info("Marshal completed");
//        } catch (JAXBException e) {
//            LOGGER.error(e);
//        }
//
//        try {
//            ObjectMapper om = new ObjectMapper();
//            User u = om.readValue("src/main/resources/user.json", User.class);
//            String result = om.writeValueAsString(u);
//        }catch(JsonProcessingException e) {
//            LOGGER.error(e);
//        }
    }


}