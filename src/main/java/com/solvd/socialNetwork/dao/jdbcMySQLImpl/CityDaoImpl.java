package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.model.billing.City;
import com.solvd.socialNetwork.dao.ICityDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CityDaoImpl extends AbstractDao<City> implements ICityDao {

    private static final Logger LOGGER = LogManager.getLogger(CityDaoImpl.class);
    private static final String CREATE_CITY = "Insert into city (city, state_id) VALUES (?, ?)";
    private static final String GET_CITY_BY_ID = "Select * from city where id=?";
    private static final String UPDATE_CITY = "Update city set city = ? where id = ?";
    private static final String DELETE_CITY = "Delete from city where id = ?";
    @Override
    public void create(City city) {

    }

    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
