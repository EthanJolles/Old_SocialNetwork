package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IDirectMessageDao;
import com.solvd.socialNetwork.model.user.DirectMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DirectMessageDaoImpl extends AbstractDao<DirectMessage> implements IDirectMessageDao {

    private static final Logger LOGGER = LogManager.getLogger(DirectMessageDaoImpl.class);
    private static final String CREATE_DIRECT_MESSAGE = "Insert into direct_message (message, " +
            "user_id, recipient_id, date_sent) VALUES (?, ?, ?, ?)";
    private static final String GET_DIRECT_MESSAGE_BY_ID = "Select * from direct_message where id=?";
    private static final String UPDATE_DIRECT_MESSAGE = "Update direct_message set message = ? where id = ?";
    private static final String DELETE_DIRECT_MESSAGE = "Delete from direct_message where id = ?";

    @Override
    public void create(DirectMessage directMessage) throws SQLException {

    }

    @Override
    public DirectMessage getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void update(DirectMessage entity) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
