package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IOrderDao;
import com.solvd.socialNetwork.model.order.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
