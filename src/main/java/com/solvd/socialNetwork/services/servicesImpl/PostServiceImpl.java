package com.solvd.socialNetwork.services.servicesImpl;

import com.solvd.socialNetwork.model.user.User;
import com.solvd.socialNetwork.model.userContent.Post;
import com.solvd.socialNetwork.services.interfaces.IPostService;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostServiceImpl extends AbstractServiceImpl<Post> implements IPostService {

    private static final Logger LOGGER = LogManager.getLogger(PostServiceImpl.class);
    private static final String GET_ALL_POST = "Select * from post";

    @Override
    public List<Post> getAll(Post post) throws SQLException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet;
        List<Post> postList = null;

        try {
            statement = connection.prepareStatement(GET_ALL_POST);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Post tempPost = new Post();
                tempPost.setId(resultSet.getLong("id"));
                tempPost.setLocation(resultSet.getString("location"));
                tempPost.setCaption(resultSet.getString("caption"));
                tempPost.setPicture(resultSet.getBoolean("is_picture"));
                tempPost.setUserId(resultSet.getLong("user_id"));
                try {
                    postList.add(tempPost);
                } catch (NullPointerException e) {
                    LOGGER.error(e);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            assert statement != null;
            statement.close();
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
        return postList;
    }
}
