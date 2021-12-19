package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.user.User;

public interface IUserDao extends IBaseDao<User> {
    @Override
    default void create(User user) {

    }

    @Override
    default User getById(Integer id) {
        return null;
    }

    @Override
    default void update(User user) {

    }

    @Override
    default void delete(Integer id) {

    }
}
