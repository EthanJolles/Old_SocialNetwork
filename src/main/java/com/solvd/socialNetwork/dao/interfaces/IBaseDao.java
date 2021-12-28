package com.solvd.socialNetwork.dao.interfaces;

//This interface is here to state all of the different CRUD operations we want to perform.
//Take a look at resources/DaoDesign.png for a model of it.

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBaseDao<T> {
    T resultSetToEntity(ResultSet resultSet);
    void create(T t) throws SQLException;
    T getById(Long id) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(Long id) throws SQLException;
}
