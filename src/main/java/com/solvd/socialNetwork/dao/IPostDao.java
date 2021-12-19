package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userContent.Post;

public interface IPostDao extends IBaseDao<Post> {
    @Override
    default void create(Post post) {

    }

    @Override
    default Post getById(Integer id) {
        return null;
    }

    @Override
    default void update(Post post) {

    }

    @Override
    default void delete(Integer id) {

    }
}
