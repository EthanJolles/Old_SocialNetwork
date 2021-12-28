package com.solvd.socialNetwork.dao.jdbcMySQLImpl.userContent;

import com.solvd.socialNetwork.dao.interfaces.userContent.IPostDao;
import com.solvd.socialNetwork.dao.jdbcMySQLImpl.AbstractDao;
import com.solvd.socialNetwork.model.userContent.Post;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PostDaoImpl extends AbstractDao<Post> implements IPostDao {

    private static final Logger LOGGER = LogManager.getLogger(PostDaoImpl.class);
    private static final String CREATE_POST = "Insert into post (location, " +
            "caption, is_picture, user_id) VALUES (?, ?, ?, ?)";
    private static final String GET_POST_BY_ID = "Select * from post where id=?";
    private static final String UPDATE_POST = "Update post set caption = ? where id = ?";
    private static final String DELETE_POST = "Delete from post where id = ?";

    @Override
    public void create(Post post) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(CREATE_POST);
            statement.setString(1, post.getLocation());
            statement.setString(2, post.getCaption());
            statement.setBoolean(3, post.getPicture());
            statement.setLong(4, post.getUserId());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }

    @Override
    public Post getById(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        Post post = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(GET_POST_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            post = resultSetToEntity(resultSet);
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
        return post;
    }

    @Override
    public Post resultSetToEntity(ResultSet resultSet) {
        Post post = new Post();
        try {
            post.setLocation(resultSet.getString("location"));
            post.setCaption(resultSet.getString("caption"));
            post.setPicture(resultSet.getBoolean("is_picture"));
            post.setUserId(resultSet.getLong("user_id"));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return post;
    }

    @Override
    public void update(Post entity) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
            statement = connection.prepareStatement(UPDATE_POST);
            statement.setString(1, entity.getCaption());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
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
