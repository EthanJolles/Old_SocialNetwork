package com.solvd.socialNetwork;

import com.solvd.socialNetwork.dao.jdbcMySQLImpl.user.UserDaoImpl;
import com.solvd.socialNetwork.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.sql.*;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
//        User test1 = new User("test1","solvdintern123");
//        userDao.create(test1);
//
//        User test2 = new User("test2","solvdIntern123");
//        userDao.create(test2);
//
//        User test3 = new User("test3","solvdintern123");
//        userDao.create(test3);
//
//        User test4 = new User("test4","solvdintern123");
//        userDao.create(test4);

        User test5 = new User("test5", "solvdintern123");
//        userDao.create(test5);
        userDao.update(test5);

//        System.out.println(JAXBHandler.unmarshal(new File("product.xml")));
    }
}