package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.billing.State;

public interface IStateDao extends IBaseDao<State> {
    @Override
    default void create(State state) {

    }

    @Override
    default State getById(Integer id) {
        return null;
    }

    @Override
    default void update(State state) {

    }

    @Override
    default void delete(Integer id) {

    }
}
