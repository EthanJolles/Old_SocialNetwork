package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ICommentDao;
import com.solvd.socialNetwork.model.userContent.Comment;
import com.solvd.socialNetwork.model.userContent.SavedPost;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDaoImpl extends AbstractDao<Comment> implements ICommentDao {

    private static final Logger LOGGER = LogManager.getLogger(CommentDaoImpl.class);
    private static final String CREATE_COMMENT = "Insert into comment (contents, post_id) VALUES (?, ?)";
    private static final String GET_COMMENT_BY_ID = "Select * from comment where id=?";
    private static final String UPDATE_COMMENT = "Update comment set contents = ? where id = ?";
    private static final String DELETE_COMMENT = "Delete from comment where id = ?";
    @Override
    public void create(Comment comment) {

    }

    @Override
    public Comment getById(Long id) {
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
    public void update(Comment entity) {

    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(DELETE_COMMENT);
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
