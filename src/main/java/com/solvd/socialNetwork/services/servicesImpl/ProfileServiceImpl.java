package com.solvd.socialNetwork.services.servicesImpl;

import com.solvd.socialNetwork.model.profile.Profile;
import com.solvd.socialNetwork.services.interfaces.IProfileService;
import com.solvd.socialNetwork.utils.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProfileServiceImpl extends AbstractServiceImpl<Profile> implements IProfileService {

    private static final Logger LOGGER = LogManager.getLogger(ProfileServiceImpl.class);
    private static final String GET_ALL_PROFILE = "Select * from profile";

    @Override
    public List<Profile> getAll(Profile profile) throws SQLException {

        Connection connection = ConnectionPool.getConnectionPool().getConnection();;
        PreparedStatement statement = null;
        ResultSet resultSet;
        List<Profile> profileList = null;

        try {
            statement = connection.prepareStatement(GET_ALL_PROFILE);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Profile tempProfile = new Profile();
                tempProfile.setId(resultSet.getLong("id"));
                tempProfile.setFirstName(resultSet.getString("username"));
                tempProfile.setLastName(resultSet.getString("password"));
                tempProfile.setMiddleInitial(resultSet.getString("middle_intiial"));
                tempProfile.setBio(resultSet.getString("bio"));
                tempProfile.setVerified(resultSet.getBoolean("is_verified"));
                tempProfile.setBirthday(resultSet.getDate("birthday"));
                tempProfile.setAge(resultSet.getLong("age"));
                tempProfile.setUserId(resultSet.getLong("user_id"));
                try {
                    profileList.add(tempProfile);
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
        return profileList;
    }
}
