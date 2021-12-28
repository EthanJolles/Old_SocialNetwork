package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.model.billing.BillingAddress;
import com.solvd.socialNetwork.dao.IBillingAddressDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BillingAddressDaoImpl extends AbstractDao<BillingAddress> implements IBillingAddressDao {

    private static final Logger LOGGER = LogManager.getLogger(BillingAddressDaoImpl.class);
    private static final String CREATE_BILLING_ADDRESS = "Insert into billing_address (user_id, zip, street, city_id) VALUES (?, ?, ?, ?)";
    private static final String GET_BILLING_ADDRESS_BY_ID = "Select * from billing_address where id=?";
    private static final String UPDATE_BILLING_ADDRESS = "Update user set city_id = ? where id = ?";
    private static final String DELETE_BILLING_ADDRESS = "Delete from billing_address where id = ?";
    @Override
    public void create(BillingAddress billingAddress) {

    }

    @Override
    public BillingAddress getById(Long id) {
        return null;
    }

    @Override
    public void update(BillingAddress entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
