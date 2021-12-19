package com.solvd.socialNetwork.dao;

public interface IBaseDao<T>{
    void create(T t);
    T getById(Integer id);
    void update(T t);
    void delete(Integer id);
}
