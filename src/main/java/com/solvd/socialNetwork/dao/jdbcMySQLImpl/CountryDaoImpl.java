package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.model.billing.Country;
import com.solvd.socialNetwork.dao.ICountryDao;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDaoImpl extends AbstractDao<Country> implements ICountryDao {

    private static final Logger LOGGER = LogManager.getLogger(CountryDaoImpl.class);
    private static final String CREATE_COUNTRY = "Insert into country (username, password) VALUES (?, ?)";
    private static final String GET_COUNTRY_BY_ID = "Select * from user where id=?";
    private static final String UPDATE_COUNTRY = "Update country set country = ? where id = ?";
    private static final String DELETE_COUNTRY = "Delete from country where id = ?";
    @Override
    public void create(Country country) {

    }

    @Override
    public Country getById(Long id) {
        return null;
    }

    public SavedPost resultSetToSavedPost(ResultSet resultSet) {
        SavedPost savedPost = new SavedPost();
        try {
            savedPost.setTitle(resultSet.getString("name"));
            savedPost.setPostId(resultSet.getLong("post_id"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return savedPost;
    }

    @Override
    public void update(Country entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_COUNTRY);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }
}
