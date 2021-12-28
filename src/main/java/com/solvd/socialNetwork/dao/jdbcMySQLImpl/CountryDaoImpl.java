package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.model.billing.Country;
import com.solvd.socialNetwork.dao.ICountryDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryDaoImpl extends AbstractDao<Country> implements ICountryDao {

    private static final Logger LOGGER = LogManager.getLogger(CountryDaoImpl.class);
    private static final String CREATE_COUNTRY = "Insert into country (username, password) VALUES (?, ?)";
    private static final String GET_COUNTRY_BY_ID = "Select * from user where id=?";
    private static final String UPDATE_COUNTRY = "Update country set country = ? where id = ?";
    private static final String DELETE_COUNTRY = "Delete from country where id = ?";
    @Override
    public void create(Country country) {

    }

    @Override
    public Country getById(Long id) {
        return null;
    }

    @Override
    public void update(Country entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
