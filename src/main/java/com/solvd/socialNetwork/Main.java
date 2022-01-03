package com.solvd.socialNetwork;

import com.solvd.socialNetwork.dao.jdbcMySQLImpl.UserDaoImpl;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.ConnectionPool;
import com.solvd.socialNetwork.utils.CredentialValues;
import com.solvd.socialNetwork.utils.JaxBHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, JAXBException {
        UserDaoImpl userDao = new UserDaoImpl();
        User test1 = new User("test12","solvdintern123");
        userDao.create(test1);

//        LOGGER.info(JaxBHandler.unmarshal(new File("resources/product.xml")));

//        JAXBContext jaxbContext;
//        try
//        {
//            jaxbContext = JAXBContext.newInstance(User.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//            User user = (User) jaxbUnmarshaller.unmarshal(new FileReader("product.xml"));
//
//            System.out.println(user);
//        }
//        catch (JAXBException | FileNotFoundException e)
//        {
//            LOGGER.error(e);
//        }
    }
}