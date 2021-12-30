package com.solvd.socialNetwork.services.servicesImpl;

import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.services.interfaces.IUserService;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends AbstractServiceImpl<User> implements IUserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private static final String GET_ALL_USER = "Select * from user";


    @Override
    public List<User> getAll(User user) throws SQLException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet;
        List<User> userList = null;

        try {
            statement = connection.prepareStatement(GET_ALL_USER);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User tempUser = new User();
                tempUser.setId(resultSet.getLong("id"));
                tempUser.setUsername(resultSet.getString("username"));
                tempUser.setPassword(resultSet.getString("password"));
                try {
                    userList.add(tempUser);
                } catch (NullPointerException e) {
                    LOGGER.error(e);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
        return userList;
    }
}
