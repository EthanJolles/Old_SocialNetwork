package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IBaseDao;

public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
    @Override
    public void create(T t) {

    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(Long id) {

    }
}
