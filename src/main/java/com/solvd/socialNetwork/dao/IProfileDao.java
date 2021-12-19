package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.profile.Profile;

public interface IProfileDao extends IBaseDao<Profile> {
    @Override
    default void create(Profile profile) {

    }

    @Override
    default Profile getById(Integer id) {
        return null;
    }

    @Override
    default void update(Profile profile) {

    }

    @Override
    default void delete(Integer id) {

    }
}
