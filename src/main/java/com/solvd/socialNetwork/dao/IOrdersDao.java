package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.order.Orders;

public interface IOrdersDao extends IBaseDao<Orders> {
    @Override
    default void create(Orders orders) {

    }

    @Override
    default Orders getById(Integer id) {
        return null;
    }

    @Override
    default void update(Orders orders) {

    }

    @Override
    default void delete(Integer id) {

    }
}
