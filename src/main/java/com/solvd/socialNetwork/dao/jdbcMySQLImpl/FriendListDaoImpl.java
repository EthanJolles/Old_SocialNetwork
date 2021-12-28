package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IFriendListDao;
import com.solvd.socialNetwork.model.userLists.FriendList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FriendListDaoImpl extends AbstractDao<FriendList> implements IFriendListDao {

    private static final Logger LOGGER = LogManager.getLogger(FriendListDaoImpl.class);
    private static final String CREATE_FRIEND_LIST = "Insert into friend_list (profile_id, friend_profile_id) VALUES (?, ?)";
    private static final String GET_FRIEND_LIST_BY_ID = "Select * from friend_list where id=?";
    private static final String UPDATE_FRIEND_LIST = "Update friend_list set profile_id = ? where id = ?";
    private static final String DELETE_FRIEND_LIST = "Delete from friend_list where id = ?";
    @Override
    public void create(FriendList friendList) {

    }

    @Override
    public FriendList getById(Long id) {
        return null;
    }

    @Override
    public void update(FriendList entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
