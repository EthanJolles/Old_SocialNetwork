package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userContent.Repost;

public interface IRepostDao extends IBaseDao<Repost> {
    @Override
    default void create(Repost repost) {

    }

    @Override
    default Repost getById(Integer id) {
        return null;
    }

    @Override
    default void update(Repost repost) {

    }

    @Override
    default void delete(Integer id) {

    }
}
