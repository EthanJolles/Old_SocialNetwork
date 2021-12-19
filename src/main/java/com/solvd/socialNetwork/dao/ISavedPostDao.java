package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userContent.SavedPost;

public interface ISavedPostDao extends IBaseDao<SavedPost> {
    @Override
    default void create(SavedPost savedPost) {

    }

    @Override
    default SavedPost getById(Integer id) {
        return null;
    }

    @Override
    default void update(SavedPost savedPost) {

    }

    @Override
    default void delete(Integer id) {

    }
}
