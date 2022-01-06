package com.solvd.socialNetwork;

import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.JaxBHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, JAXBException {
//        UserDaoImpl userDao = new UserDaoImpl();
//        User user = new User("test13","solvdintern123");
//        userDao.create(user);

//        File xmlFile = new File("" +
//                "/Users/ethanjolles/Desktop/SocialNetwork/SocialNetwork/src/main/resources/user.xml");
//
//        JAXBContext jaxbContext;
//        try
//        {
//            jaxbContext = JAXBContext.newInstance(User.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//            User user = (User) jaxbUnmarshaller.unmarshal(xmlFile);
//
//            System.out.println(user);
//        }
//        catch (JAXBException e)
//        {
//            LOGGER.error(e);
//        }
    }
}