package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.ISavedPostDao;
import com.solvd.socialNetwork.model.userContent.SavedPost;

public class SavedPostDaoImpl extends AbstractDao<SavedPost> implements ISavedPostDao {
    @Override
    public void create(SavedPost savedPost) {

    }

    @Override
    public SavedPost getById(Long id) {
        return null;
    }

    @Override
    public void update(SavedPost savedPost) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
