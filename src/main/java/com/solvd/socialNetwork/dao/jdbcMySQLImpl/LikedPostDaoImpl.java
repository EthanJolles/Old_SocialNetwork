package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ILikedPostDao;
import com.solvd.socialNetwork.model.userContent.LikedPost;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikedPostDaoImpl extends AbstractDao<LikedPost> implements ILikedPostDao {

    private static final Logger LOGGER = LogManager.getLogger(LikedPostDaoImpl.class);
    private static final String CREATE_LIKED_POST = "Insert into liked_post (name, post_id) VALUES (?, ?)";
    private static final String GET_LIKED_POST_BY_ID = "Select * from liked_post where id=?";
    private static final String UPDATE_LIKED_POST = "Update liked_post set name = ? where id = ?";
    private static final String DELETE_LIKED_POST = "Delete from liked_post where id = ?";
    @Override
    public void create(LikedPost likedPost) {

    }

    @Override
    public LikedPost getById(Long id) {
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
    public void update(LikedPost entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_LIKED_POST);
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
