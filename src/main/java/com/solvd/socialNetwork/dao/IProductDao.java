package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.order.Product;

public interface IProductDao extends IBaseDao<Product> {
    @Override
    default void create(Product product) {

    }

    @Override
    default Product getById(Integer id) {
        return null;
    }

    @Override
    default void update(Product product) {

    }

    @Override
    default void delete(Integer id) {

    }
}
