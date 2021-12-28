package com.solvd.socialNetwork.dao.jdbcMySQLImpl;

import com.solvd.socialNetwork.dao.IProductDao;
import com.solvd.socialNetwork.model.order.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductDaoImpl extends AbstractDao<Product> implements IProductDao {


    private static final Logger LOGGER = LogManager.getLogger(ProductDaoImpl.class);
    private static final String CREATE_PRODUCT = "Insert into product (name, price, " +
            "desc, date_listed, is_out_of_stock, sku, model_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PRODUCT_BY_ID = "Select * from product where id=?";
    private static final String UPDATE_PRODUCT_PRICE = "Update product set price = ? where id = ?";
    private static final String DELETE_PRODUCT = "Delete from product where id = ?";
    @Override
    public void create(Product product) {

    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
