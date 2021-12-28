package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IDirectMessageDao;
import com.solvd.socialNetwork.model.user.DirectMessage;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public SavedPost resultSetToSavedPost(ResultSet resultSet) {
        SavedPost savedPost = new SavedPost();
        try {
            savedPost.setTitle(resultSet.getString("name"));
            savedPost.setPostId(resultSet.getLong("post_id"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return savedPost;
    }

    @Override
    public void update(DirectMessage entity) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_DIRECT_MESSAGE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }
}
