package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IProfileDao;
import com.solvd.socialNetwork.model.profile.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfileDaoImpl extends AbstractDao<Profile> implements IProfileDao {

    private static final Logger LOGGER = LogManager.getLogger(ProfileDaoImpl.class);
    private static final String CREATE_PROFILE = "Insert into profile (first_name, last_name, " +
            "middle_intiial, bio, is_verified, birthday, age, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PROFILE_BY_ID = "Select * from profile where id=?";
    private static final String UPDATE_PROFILE = "Update profile set bio = ? where id = ?";
    private static final String DELETE_PROFILE = "Delete from profile where id = ?";
    @Override
    public void create(Profile profile) {

    }

    @Override
    public Profile getById(Long id) {
        return null;
    }

    @Override
    public void update(Profile entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
