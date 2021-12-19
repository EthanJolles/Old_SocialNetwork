package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userContent.Comments;

public interface ICommentsDao extends IBaseDao<Comments> {
    @Override
    default void create(Comments comments) {

    }

    @Override
    default Comments getById(Integer id) {
        return null;
    }

    @Override
    default void update(Comments comments) {

    }

    @Override
    default void delete(Integer id) {

    }
}
