package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IProductDao;
import com.solvd.socialNetwork.model.order.Product;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends AbstractDao<Product> implements IProductDao {


    private static final Logger LOGGER = LogManager.getLogger(ProductDaoImpl.class);
    private static final String CREATE_PRODUCT = "Insert into product (name, price, " +
            "desc, date_listed, is_out_of_stock, sku, model_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PRODUCT_BY_ID = "Select * from product where id=?";
    private static final String UPDATE_PRODUCT_PRICE = "Update product set price = ? where id = ?";
    private static final String DELETE_PRODUCT = "Delete from product where id = ?";
    @Override
    public void create(Product product) {

    }

    @Override
    public Product getById(Long id) {
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
    public void update(Product entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_PRODUCT);
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
