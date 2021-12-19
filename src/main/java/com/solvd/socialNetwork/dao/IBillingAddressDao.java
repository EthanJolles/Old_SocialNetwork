package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.billing.BillingAddress;

public interface IBillingAddressDao extends IBaseDao<BillingAddress> {
    @Override
    default void create(BillingAddress billingAddress) {
    }

    @Override
    default BillingAddress getById(Integer id) {
        return null;
    }

    @Override
    default void update(BillingAddress billingAddress) {
    }

    @Override
    default void delete(Integer id) {

    }
}
