package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IBlockedListDao;
import com.solvd.socialNetwork.model.userLists.BlockedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockedListDaoImpl extends AbstractDao<BlockedList> implements IBlockedListDao {

    private static final Logger LOGGER = LogManager.getLogger(BlockedListDaoImpl.class);
    private static final String CREATE_BLOCKED_LIST = "Insert into blocked_list (profile_id, " +
            "blocked_profile_id) VALUES (?, ?)";
    private static final String GET_BLOCKED_LIST_BY_ID = "Select * from blocked_list where id=?";
    private static final String UPDATE_BLOCKED_LIST = "Update user set blocked_profile_id = ? where id = ?";
    private static final String DELETE_BLOCKED_LIST = "Delete from blocked_list where id = ?";
    @Override
    public void create(BlockedList blockedList) {

    }

    @Override
    public BlockedList getById(Long id) {
        return null;
    }

    @Override
    public void update(BlockedList entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
