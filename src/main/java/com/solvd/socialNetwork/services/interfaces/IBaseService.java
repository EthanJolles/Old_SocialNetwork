package com.solvd.socialNetwork.services.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {

    List<T> getAll(T t) throws SQLException;
}
