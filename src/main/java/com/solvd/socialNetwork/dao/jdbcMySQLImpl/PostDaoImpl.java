package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IPostDao;
import com.solvd.socialNetwork.model.userContent.Post;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDaoImpl extends AbstractDao<Post> implements IPostDao {

    private static final Logger LOGGER = LogManager.getLogger(PostDaoImpl.class);
    private static final String CREATE_POST = "Insert into post (location, " +
            "caption, is_picture, user_id) VALUES (?, ?, ?, ?)";
    private static final String GET_POST_BY_ID = "Select * from post where id=?";
    private static final String UPDATE_POST = "Update post set caption = ? where id = ?";
    private static final String DELETE_POST = "Delete from post where id = ?";
    @Override
    public void create(Post post) {

    }

    @Override
    public Post getById(Long id) {
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
    public void update(Post entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_POST);
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
