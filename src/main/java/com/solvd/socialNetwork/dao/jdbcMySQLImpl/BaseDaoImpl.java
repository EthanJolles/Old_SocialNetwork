package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IBaseDao;

//This class is here for all default implementation of CRUD operations
//Any other implementation will be done in the respective Impl class.
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
