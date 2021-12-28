package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ISavedPostDao;
import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavedPostDaoImpl extends AbstractDao<SavedPost> implements ISavedPostDao {
    private static final Logger LOGGER = LogManager.getLogger(SavedPostDaoImpl.class);
    private static final String CREATE_SAVED_POST = "Insert into saved_post (name, post_id) VALUES (?, ?)";
    private static final String GET_SAVED_POST_BY_ID = "Select * from saved_post where id = ?";
    private static final String UPDATE_SAVED_POST = "Update saved_post set name = ? where id = ?";
    private static final String DELETE_SAVED_POST = "Delete from saved_post where id = ?";
    @Override
    public void create(SavedPost savedPost) {

    }

    @Override
    public SavedPost getById(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        SavedPost savedPost = null;

        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(GET_SAVED_POST_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            savedPost = resultSetToSavedPost(resultSet);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
        return savedPost;
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
    public void update(SavedPost entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
