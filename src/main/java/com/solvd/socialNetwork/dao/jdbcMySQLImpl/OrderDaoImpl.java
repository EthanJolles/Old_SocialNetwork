package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IOrderDao;
import com.solvd.socialNetwork.model.order.Order;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl extends AbstractDao<Order> implements IOrderDao {

    private static final Logger LOGGER = LogManager.getLogger(OrderDaoImpl.class);
    private static final String CREATE_ORDER = "Insert into order (user_id, product_id) VALUES (?, ?)";
    private static final String GET_ORDER_BY_ID = "Select * from order where id=?";
    private static final String UPDATE_ORDER = "Update order set order_id = ? where id = ?";
    private static final String DELETE_ORDER = "Delete from order where id = ?";
    @Override
    public void create(Order order) {

    }

    @Override
    public Order getById(Long id) {
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
    public void update(Order entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_ORDER);
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
