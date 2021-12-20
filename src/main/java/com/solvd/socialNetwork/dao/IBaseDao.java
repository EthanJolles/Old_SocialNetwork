package com.solvd.socialNetwork.dao;

public interface IBaseDao<T>{
    void create(T t);
    T getById(Long id);
    void update(T t);
    void delete(Long id);
}
