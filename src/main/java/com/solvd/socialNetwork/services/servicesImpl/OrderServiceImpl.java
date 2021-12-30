package com.solvd.socialNetwork.services.servicesImpl;

import com.solvd.socialNetwork.model.order.Order;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.services.interfaces.IOrderService;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements IOrderService {

    private static final Logger LOGGER = LogManager.getLogger(PostServiceImpl.class);
    private static final String GET_ALL_ORDER = "Select * from order";

    @Override
    public List<Order> getAll(Order order) throws SQLException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet;
        List<Order> orderList = null;

        try {
            statement = connection.prepareStatement(GET_ALL_ORDER);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order tempOrder = new Order();
                tempOrder.setId(resultSet.getLong("id"));
                tempOrder.setUserId(resultSet.getLong("user_id"));
                tempOrder.setProductId(resultSet.getLong("product_id"));
                try {
                    orderList.add(tempOrder);
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
        return orderList;
    }
}
