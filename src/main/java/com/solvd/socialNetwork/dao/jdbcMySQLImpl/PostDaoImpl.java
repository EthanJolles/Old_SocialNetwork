package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IPostDao;
import com.solvd.socialNetwork.model.userContent.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
