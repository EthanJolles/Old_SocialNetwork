package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.billing.Country;

public interface ICountryDao extends IBaseDao<Country> {
    @Override
    default void create(Country country) {

    }

    @Override
    default Country getById(Integer id) {
        return null;
    }

    @Override
    default void update(Country country) {

    }

    @Override
    default void delete(Integer id) {

    }
}
