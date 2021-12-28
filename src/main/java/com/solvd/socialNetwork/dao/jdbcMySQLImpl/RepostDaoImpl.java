package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IRepostDao;
import com.solvd.socialNetwork.model.userContent.Repost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepostDaoImpl extends AbstractDao<Repost> implements IRepostDao {

    private static final Logger LOGGER = LogManager.getLogger(RepostDaoImpl.class);
    private static final String CREATE_REPOST = "Insert into repost (name, post_id) VALUES (?, ?)";
    private static final String GET_REPOST_BY_ID = "Select * from repost where id=?";
    private static final String UPDATE_REPOST = "Update repost set name = ? where id = ?";
    private static final String DELETE_REPOST = "Delete from repost where id = ?";

    @Override
    public void create(Repost repost) {

    }

    @Override
    public Repost getById(Long id) {
        return null;
    }

    @Override
    public void update(Repost entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
