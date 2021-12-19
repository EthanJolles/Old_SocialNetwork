package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userLists.FriendList;

public interface IFriendListDao extends IBaseDao<FriendList> {
    @Override
    default void create(FriendList friendList) {

    }

    @Override
    default FriendList getById(Integer id) {
        return null;
    }

    @Override
    default void update(FriendList friendList) {

    }

    @Override
    default void delete(Integer id) {

    }
}
