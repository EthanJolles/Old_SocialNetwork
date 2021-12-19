package com.solvd.socialNetwork.dao;

import com.solvd.socialNetwork.userLists.BlockedList;

public interface IBlockedListDao extends IBaseDao<BlockedList> {
    @Override
    default void create(BlockedList blockedList) {

    }

    @Override
    default BlockedList getById(Integer id) {
        return null;
    }

    @Override
    default void update(BlockedList blockedList) {

    }

    @Override
    default void delete(Integer id) {

    }
}
