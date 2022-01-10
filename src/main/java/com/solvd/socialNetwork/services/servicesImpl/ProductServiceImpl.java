package com.solvd.socialNetwork.services.servicesImpl;

import com.solvd.socialNetwork.model.order.Product;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.services.interfaces.IProductService;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements IProductService {

    private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
    private static final String GET_ALL_PRODUCT = "Select * from product";

    @Override
    public List<Product> getAll(Product product) throws SQLException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet;
        List<Product> productList = null;

        try {
            statement = connection.prepareStatement(GET_ALL_PRODUCT);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product temppProduct = new Product();
                temppProduct.setId(resultSet.getLong("id"));
                temppProduct.setName(resultSet.getString("name"));
                temppProduct.setPrice(resultSet.getDouble("price"));
                temppProduct.setDesc(resultSet.getString("desc"));
                temppProduct.setDateListed(resultSet.getDate("date_listed"));
                temppProduct.setIsOutOfStock(resultSet.getBytes("is_out_of_stock"));
                temppProduct.setSku(resultSet.getLong("sku"));
                temppProduct.setModelNumber(resultSet.getString("model_number"));
                try {
                    productList.add(temppProduct);
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
        return productList;
    }
}
