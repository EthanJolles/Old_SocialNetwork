package com.solvd.socialNetwork.utils;

import com.solvd.socialNetwork.model.order.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxBHandler {

    public static Product unmarshal(File importFile) throws JAXBException {
        Product product;
        JAXBContext context;

        context = JAXBContext.newInstance(Product.class);
        Unmarshaller um = context.createUnmarshaller();
        product = (Product) um.unmarshal(importFile);
        return product;
    }
}
