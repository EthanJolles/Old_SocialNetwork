package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IUserDao;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
    private static final String GET_USERS_BY_ID = "Select * from user where id=?";
    private static final String CREATE_USER = "Insert into user (username, password) VALUES (?, ?)";
    private static final String UPDATE_USER = "Update user set password = ? where username = ?";
    private static final String DELETE_USER = "Delete from user where id = ?";
    private static final String GET_USER_BY_USERNAME = "Select * from user where username = ?";

    @Override
    public void create(User user) throws SQLException {
        Connection connection;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(CREATE_USER);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool();
        }
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {
    }
}
