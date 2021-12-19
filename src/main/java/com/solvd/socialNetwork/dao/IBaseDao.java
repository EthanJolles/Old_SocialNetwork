package com.solvd.socialNetwork.dao;

public interface IBaseDao<T, K>{
    void create(T t);
    T getById(K id);
    void update(T t);
    void delete(K id);
}
