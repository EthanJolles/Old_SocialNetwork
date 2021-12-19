package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.billing.City;

public interface ICityDao extends IBaseDao<City> {
    @Override
    default void create(City city) {

    }

    @Override
    default City getById(Integer id) {
        return null;
    }

    @Override
    default void update(City city) {

    }

    @Override
    default void delete(Integer id) {

    }
}
