package com.solvd.socialNetwork.dao;

//This interface is here to state all of the different CRUD operations we want to perform.
//Take a look at resources/DaoDesign.png for a model of it.

import java.sql.SQLException;

public interface IBaseDao<T>{
    void create(T t) throws SQLException;
    T getById(Long id);
    void update(T t);
    void delete(Long id);
}
