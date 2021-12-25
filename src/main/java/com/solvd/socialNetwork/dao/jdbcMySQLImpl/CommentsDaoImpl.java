package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ICommentsDao;
import com.solvd.socialNetwork.model.userContent.Comments;

public class CommentsDaoImpl extends AbstractDao<Comments> implements ICommentsDao {
    @Override
    public void create(Comments comments) {

    }

    @Override
    public Comments getById(Long id) {
        return null;
    }

    @Override
    public void update(Comments comments) {

    }

    @Override
    public void delete(Long id) {

    }
}
