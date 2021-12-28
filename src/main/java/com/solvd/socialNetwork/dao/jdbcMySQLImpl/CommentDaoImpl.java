package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ICommentDao;
import com.solvd.socialNetwork.model.userContent.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
