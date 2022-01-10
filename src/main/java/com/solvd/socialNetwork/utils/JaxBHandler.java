package com.solvd.socialNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class JaxBHandler<T> {

    private static final Logger LOGGER = LogManager.getLogger(JaxBHandler.class);

    private static final ConcurrentHashMap<Class<?>, JAXBContext> CONTEXT = new ConcurrentHashMap<>();

    private JaxBHandler() {
        throw new AssertionError("Trying to instantiate utility class");
    }

    public static <T> T unmarshall(String xml, Class<T> clazz) throws JAXBException {
        JAXBContext context = CONTEXT.get(clazz);
        if (context == null){
            context = JAXBContext.newInstance(clazz);
            CONTEXT.putIfAbsent(clazz, context);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        File file = new File("src/main/resources/" + xml);
        Object obj = unmarshaller.unmarshal(file);
        if (clazz.isInstance(obj)){
            return clazz.cast(obj);
        }
        throw new IllegalArgumentException("XML does not represent an instance of type:" + clazz.getName());
    }


}
