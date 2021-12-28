package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.model.billing.BillingAddress;
import com.solvd.socialNetwork.dao.IBillingAddressDao;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingAddressDaoImpl extends AbstractDao<BillingAddress> implements IBillingAddressDao {

    private static final Logger LOGGER = LogManager.getLogger(BillingAddressDaoImpl.class);
    private static final String CREATE_BILLING_ADDRESS = "Insert into billing_address (user_id, zip, street, city_id) VALUES (?, ?, ?, ?)";
    private static final String GET_BILLING_ADDRESS_BY_ID = "Select * from billing_address where id=?";
    private static final String UPDATE_BILLING_ADDRESS = "Update billing_address set user_id =?, zip =?, street =?" +
            ",city_id =? where id = ?";
    private static final String DELETE_BILLING_ADDRESS = "Delete from billing_address where id = ?";
    @Override
    public void create(BillingAddress billingAddress) {

    }

    @Override
    public BillingAddress getById(Long id) {
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
    public void update(BillingAddress entity) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(UPDATE_BILLING_ADDRESS);
            statement.setLong(1,entity.getUserId());
            statement.setLong(2, entity.getZip());
            statement.setString(3, entity.getStreet());
            statement.setLong(4,entity.getCityId());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_BILLING_ADDRESS);
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
