package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userContent.LikedPost;

public interface ILikedPostDao extends IBaseDao<LikedPost> {
    @Override
    default void create(LikedPost likedPost) {

    }

    @Override
    default LikedPost getById(Integer id) {
        return null;
    }

    @Override
    default void update(LikedPost likedPost) {

    }

    @Override
    default void delete(Integer id) {

    }
}
